import { setFailed } from "@actions/core";
import { buildAndRelease } from "./buildAndRelease";
import { readDistroVersion } from "./readDistroVersion";

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
} catch (error) {
  setFailed(error.message);
}
