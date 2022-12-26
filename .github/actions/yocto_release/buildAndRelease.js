import { info } from "@actions/core";
import { exec } from "@actions/exec";
import { cp, mkdirP } from "@actions/io";
import { createRelease } from "./createRelease.js";
import { deleteRelease } from "./deleteRelease.js";
import { upload } from "./upload.js";

export async function buildAndRelease(options) {
  const release = await createRelease(options.tag, options.name, options.body);
  if (release === null) {
    info(`Tag ${options.tag} already exists, will not release a new version.`);
    return;
  }
  try {
    await exec("kas checkout meta-hulks/kas-project.yml");
    await mkdirP("meta-nao/recipes-support/aldebaran/aldebaran-binaries");
    await cp(
      "/aldebaran_binaries.tar.gz",
      "meta-nao/recipes-support/aldebaran/aldebaran-binaries/"
    );
    await exec(
      `kas build --target nao-image --cmd ${options.task} meta-hulks/kas-project.yml`
    );
    await upload(release.uploadUrl, options.artifactPath);
  } catch (error) {
    deleteRelease(release.id);
    throw error;
  }
}
