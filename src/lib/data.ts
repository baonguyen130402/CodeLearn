import { unstable_noStore as noStore } from "next/cache";
import axios from "axios";

export async function fetchPost() {
  noStore();

  try {
    const { data: posts } = await axios.get("/v3/post");
    return posts;
  } catch (error) {
    console.error("Failed to fetch post:", error);
    throw new Error("Failed to fetch post.");
  }
}
