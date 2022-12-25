const core = require("@actions/core");
const exec = require("@actions/exec");
const fs = require("fs");
const github = require("@actions/github");

const GITHUB_TOKEN = core.getInput("GITHUB_TOKEN");
const octokit = github.getOctokit(GITHUB_TOKEN);
const distroConfPath = "conf/distro/HULKs-OS.conf";

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
  // if (await tagExists(`image-${major}.${minor}.${patch}`)) {
  //   core.info(
  //     `Tag image-${major}.${minor}.${patch} already exists, will not release a new image.`
  //   );
  //   return;
  // }
  await exec.exec("ls -ahl /");
  await createRelease(`test`, "Test2", "Test2");
}

async function createRelease(tag, name, body) {
  console.log(await octokit.request("POST /repos/{owner}/{repo}/releases", {
    owner: github.context.repo.owner,
    repo: github.context.repo.repo,
    tag_name: tag,
    target_commitish: github.context.sha,
    name,
    body,
    draft: false,
    prerelease: false,
    generate_release_notes: false,
  }));
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
