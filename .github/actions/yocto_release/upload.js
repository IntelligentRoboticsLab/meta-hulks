import { getInput } from "@actions/core";
import { HttpClient } from "@actions/http-client";
import { createReadStream, statSync } from "fs";
import { basename } from "path";

export async function upload(uploadUrl, artifactPath) {
  const client = new HttpClient();
  const dataLength = statSync(artifactPath).size;
  const data = createReadStream(artifactPath);
  const GITHUB_TOKEN = getInput("GITHUB_TOKEN");
  const response = await client.post(
    `${uploadUrl}?name=${basename(artifactPath)}`,
    data,
    {
      Authorization: `Bearer ${GITHUB_TOKEN}`,
      "Content-Length": dataLength,
      "Content-Type": "application/octet-stream",
    }
  );
  await response.readBody();
}
