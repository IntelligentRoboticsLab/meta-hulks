import { info } from "@actions/core";
import { exec } from "@actions/exec";
import { cp, mkdirP } from "@actions/io";
import { createRelease } from "./createRelease.js";
import { deleteRelease } from "./deleteRelease.js";
import { upload } from "./upload.js";

export async function buildAndRelease(options) {
  info(`Trying to create ${options.name} release...`);
  const release = await createRelease(options.tag, options.name, options.body);
  if (release === null) {
    info(`Tag ${options.tag} already exists, will not release a new version.`);
    return;
  }
  try {
    info(`Preparing to build ${options.name}...`);
    await exec("kas checkout meta-hulks/kas-project.yml");
    await mkdirP("meta-nao/recipes-support/aldebaran/aldebaran-binaries");
    await cp(
      "/aldebaran_binaries.tar.gz",
      "meta-nao/recipes-support/aldebaran/aldebaran-binaries/"
    );
    info(`Building ${options.name}...`);
    await exec(
      `kas build --target nao-image --cmd ${options.task} meta-hulks/kas-project.yml`
    );
    info(`Uploading artifact to ${options.name}...`);
    await upload(release.uploadUrl, options.artifactPath);
  } catch (error) {
    info(`Removing ${options.name} release...`);
    deleteRelease(release.id);
    throw error;
  }
}
