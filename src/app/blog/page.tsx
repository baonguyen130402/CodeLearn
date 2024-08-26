"use client";

import { useSearchParams } from "next/navigation";
import Article from "./component/Article";
import { ArticlePagination } from "./component/Pagination";
import clsx from "clsx";
import { useTheme } from "next-themes";
import { useEffect, useState } from "react";
import { fetchPost } from "@/lib/data";
import { SkeletonPostCard } from "@/components/skeleton-post-card";

export default function ArticlePage() {
  const { theme } = useTheme();
  const [loading, setLoading] = useState(false);
  const [posts, setPosts] = useState([{
    postId: "",
    title: "",
    desc: "",
    hashtag: "",
    thumbnailUrl: "",
  }]);

  useEffect(() => {
    (async () => {
      setLoading(true);

      const data = await fetchPost();

      await new Promise(() =>
        setTimeout(() => {
          setPosts(data);
          setLoading(false);
        }, 1000)
      );
    })();
  }, []);

  console.log(posts);

  const Hashtags = [
    "ReactJs/FE",
    "Springboot",
    "NodeJs",
    "DevOps",
  ];

  const ITEM_PER_PAGE = 4;
  const searchParams = useSearchParams();
  const currentPage = Number(searchParams.get("page")) || 1;

  return (
    <div className="pl-16 pr-0 py-2 flex flex-col justify-center items-start container">
      <div className="flex flex-col justify-center items-start ">
        <span className="text-3xl font-extrabold mb-10">
          Featured Articles
        </span>
        <p className="w-3/5 text-gray-400 font-light">
          Lorem ipsum dolor sit amet, qui minim labore adipisicing minim sint
          cillum sint consectetur cupidatat.
        </p>
        <div className="flex mt-16">
          <div className="grid row-4 gap-4">
            {!loading && posts.slice(
              ITEM_PER_PAGE * (currentPage - 1),
              ITEM_PER_PAGE * currentPage,
            ).map((
              post,
            ) => (
              <Article
                key={post.postId}
                title={post.title}
                desc={post.desc}
                thumbnail={post.thumbnailUrl}
                hashtags={post.hashtag || []}
              />
            ))}
            {loading &&
              Array(4).fill(0).map((_, id) => <SkeletonPostCard key={id} />)}
          </div>
          <div className="pr-8">
            <span className="font-bold text-md">
              VIEW ARTICLES BY TOPIC
            </span>
            <div className="grid grid-cols-2 gap-2 mt-4">
              {Hashtags.map((hashtag) => (
                <div className="px-3 py-0.5 rounded-3xl cursor-pointer transition ease-linear bg-slate-900 hover:bg-slate-800">
                  {hashtag}
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
      <div className="mt-16 self-center">
        <ArticlePagination totalPages={8} />
      </div>
    </div>
  );
}
