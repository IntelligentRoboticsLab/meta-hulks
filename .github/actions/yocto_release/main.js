import { setFailed } from "@actions/core";
import { buildAndRelease } from "./buildAndRelease.js";
import { readDistroVersion } from "./readDistroVersion.js";

try {
  const distroVersion = readDistroVersion(
    `meta-hulks/conf/distro/HULKs-OS.conf`
  );
  buildAndRelease({
    tag: `image-${distroVersion.major}.${distroVersion.minor}.${distroVersion.patch}`,
    name: `HULKs-OS Image ${distroVersion.major}.${distroVersion.minor}.${distroVersion.patch}`,
    body: `Flashable image containing HULKs-OS ${distroVersion.major}.${distroVersion.minor}.${distroVersion.patch}, for instructions see https://hulks.de/hulk/setup/overview/`,
    task: "build",
    artifactPath: `build/tmp/deploy/images/nao-v6/nao-image-HULKs-OS-${distroVersion.major}.${distroVersion.minor}.${distroVersion.patch}.ext3.gz.opn`,
  });
  buildAndRelease({
    tag: `sdk-${distroVersion.major}.${distroVersion.minor}`,
    name: `HULKs-OS SDK ${distroVersion.major}.${distroVersion.minor}`,
    body: `Toolchain and other tools targeting HULKs-OS, for instructions see https://hulks.de/hulk/setup/overview/`,
    task: "populate_sdk",
    artifactPath: `build/tmp/deploy/sdk/HULKs-OS-toolchain-${distroVersion.major}.${distroVersion.minor}.sh`,
  });
} catch (error) {
  setFailed(error.message);
}
