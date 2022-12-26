import { getInput } from "@actions/core";
import { context, getOctokit } from "@actions/github";

export async function deleteRelease(releaseId) {
  const GITHUB_TOKEN = getInput("GITHUB_TOKEN");
  const octokit = getOctokit(GITHUB_TOKEN);
  await octokit.request("DELETE /repos/{owner}/{repo}/releases/{release_id}", {
    owner: context.repo.owner,
    repo: context.repo.repo,
    release_id: releaseId,
  });
}
