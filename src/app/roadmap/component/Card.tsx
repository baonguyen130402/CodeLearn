"use client";

import { Button } from "@/components/ui/button";
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { useTheme } from "next-themes";

interface Props {
  title: string;
  content: string;
  image?: string;
}

export default function CardRoadMap(props: Props) {
  const { theme } = useTheme();
  const { title, content, image } = props;

  return (
    <div className="relative group cursor-pointer">
      <div className="absolute -inset-1 bg-gradient-to-r from-red-600 to-violet-600 rounded-lg blur opacity-25 group-hover:opacity-100 transition duration-1000 group-hover:duration-200">
      </div>
      <div className="relative bg-white ring-1 ring-gray-900/5 rounded-lg leading-none flex items-top justify-start space-x-6">
        <div className="space-y-2">
          <div className="rounded-lg bg-gradient-to-tr from-pink-300 to-blue-300 shadow-lg p-[0.5px] w-[501px]">
            <div className="rounded-md">
              <Card className="w-[500px] flex">
                <div className="w-2/3">
                  <CardHeader>
                    <CardTitle>{title}</CardTitle>
                  </CardHeader>
                  <CardContent>
                    <p>{content}</p>
                  </CardContent>
                  <CardFooter>
                    <Button>View Detail</Button>
                  </CardFooter>
                </div>
                <div className="pt-7 pl-2">
                  <img
                    src={image}
                    className="rounded-full h-28 w-28 border-4 border-blue-400 bg-white"
                  />
                </div>
              </Card>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
