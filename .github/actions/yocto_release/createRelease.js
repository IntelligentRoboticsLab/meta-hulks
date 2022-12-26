import { getInput } from "@actions/core";
import { context, getOctokit } from "@actions/github";

export async function createRelease(tag, name, body) {
  const GITHUB_TOKEN = getInput("GITHUB_TOKEN");
  const octokit = getOctokit(GITHUB_TOKEN);
  try {
    const response = await octokit.request(
      "POST /repos/{owner}/{repo}/releases",
      {
        owner: context.repo.owner,
        repo: context.repo.repo,
        tag_name: tag,
        target_commitish: context.sha,
        name,
        body,
        draft: false,
        prerelease: false,
        generate_release_notes: false,
      }
    );
    return {
      id: response.data.id,
      uploadUrl: (() => {
        const templateMarkerPosition = response.data.upload_url.indexOf("{");
        if (templateMarkerPosition > -1) {
          return response.data.upload_url.substring(0, templateMarkerPosition);
        }
        return response.data.upload_url;
      })(),
    };
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
