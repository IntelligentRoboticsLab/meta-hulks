const core = require("@actions/core");
const exec = require("@actions/exec");
const fs = require("fs");
const github = require("@actions/github");

const GITHUB_TOKEN = core.getInput("GITHUB_TOKEN");
const octokit = github.getOctokit(GITHUB_TOKEN);
const distroConfPath = `${github.context.repo.repo}/conf/distro/HULKs-OS.conf`;

async function release() {
  const distroVersion = readDistroVersion();
  if (distroVersion === null) {
    return;
  }
  const [major, minor, patch] = distroVersion;
  // console.log(await tagExists(`image-${major}.${minor}.${patch}`));
  await releaseImage(major, minor, patch);
}

function readDistroVersion() {
  const distroConf = fs.readFileSync(distroConfPath).toString();
  const matches = distroConf.match(
    /DISTRO_VERSION\s*=\s*"(\d+)\.(\d+)\.(\d+)"/
  );
  if (matches === null) {
    core.setFailed(
      `DISTRO_VERSION in ${distroConfPath} does not match \\d+\\.\\d+\\.\\d+`
    );
    return null;
  }
  return [parseInt(matches[1]), parseInt(matches[2]), parseInt(matches[3])];
}

async function releaseImage(major, minor, patch) {
  // const tag = `image-${major}.${minor}.${patch}`;
  // const releaseId = await createRelease(
  //   tag,
  //   `HULKs-OS Image ${major}.${minor}.${patch}`,
  //   `Flashable image containing HULKs-OS ${major}.${minor}.${patch}, for instructions see https://hulks.de/hulk/setup/overview/`
  // );
  // if (releaseId === null) {
  //   core.info(
  //     `Tag ${tag} already exists, will not release a new image for ${major}.${minor}.${patch}.`
  //   );
  //   return;
  // }
  try {
    await exec.exec("kas checkout meta-hulks/kas-project.yml");
    await exec.exec("mkdir -p meta-nao/recipes-support/aldebaran/aldebaran-binaries");
    await exec.exec("cp /aldebaran_binaries.tar.gz meta-nao/recipes-support/aldebaran/aldebaran-binaries/");
    await exec.exec("kas build --target nao-image --cmd do_image meta-hulks/kas-project.yml");
  } catch (error) {
    // deleteRelease(releaseId);
    throw error;
  }
}

async function createRelease(tag, name, body) {
  try {
    const response = await octokit.request(
      "POST /repos/{owner}/{repo}/releases",
      {
        owner: github.context.repo.owner,
        repo: github.context.repo.repo,
        tag_name: tag,
        target_commitish: github.context.sha,
        name,
        body,
        draft: false,
        prerelease: false,
        generate_release_notes: false,
      }
    );
    return response.data.id;
  } catch (error) {
    if (
      error.status === 422 &&
      error.response.data.errors.some(
        (error) => error.code === "already_exists" && error.field === "tag_name"
      )
    ) {
      return null;
    }
    throw error;
  }
}

async function deleteRelease(releaseId) {
  await octokit.request("DELETE /repos/{owner}/{repo}/releases/{release_id}", {
    owner: github.context.repo.owner,
    repo: github.context.repo.repo,
    release_id: releaseId,
  });
}

async function tagExists(tag) {
  try {
    await octokit.request("GET /repos/{owner}/{repo}/releases/tags/{tag}", {
      owner: "HULKs",
      repo: "meta-hulks",
      tag,
    });
    return true;
  } catch (error) {
    return false;
  }
}

try {
  release();
} catch (error) {
  core.setFailed(error.message);
}
