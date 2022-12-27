import { getInput } from "@actions/core";
import { context, getOctokit } from "@actions/github";

export async function deleteRelease(releaseId, tag) {
  const GITHUB_TOKEN = getInput("GITHUB_TOKEN");
  const octokit = getOctokit(GITHUB_TOKEN);
  await octokit.request("DELETE /repos/{owner}/{repo}/releases/{release_id}", {
    owner: context.repo.owner,
    repo: context.repo.repo,
    release_id: releaseId,
  });
  await octokit.request("DELETE /repos/{owner}/{repo}/git/refs/tags/{tag}", {
    owner: context.repo.owner,
    repo: context.repo.repo,
    tag,
  });
}
