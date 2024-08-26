import { Icons } from "@/components/icons/icons";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Avatar, AvatarImage } from "@radix-ui/react-avatar";

interface Props {
  avatar?: string;
  name?: string;
  title: string;
  desc: string;
  thumbnail: string;
  hashtags?: any;
}

export default function Article(props: Props) {
  const { avatar, name, title, desc, thumbnail, hashtags } = props;

  return (
    <div className="relative group cursor-normal w-11/12">
      <div className="absolute -inset-1 bg-gradient-to-r from-neutral-600 to-stone-600 rounded-lg blur opacity-25 group-hover:opacity-100 transition duration-1000 group-hover:duration-200">
      </div>
      <div className="relative bg-white ring-1 ring-gray-900/5 rounded-lg leading-none flex items-top justify-start space-x-6">
        <div className="space-y-2">
          <div className="rounded-lg bg-gradient-to-tr from-pink-300 to-blue-300 shadow-lg p-[1px]">
            <div className="rounded-md">
              <Card className="p-4">
                <div className="flex items-center justify-between mb-6">
                  <div className="flex items-center">
                    <Avatar>
                      <AvatarImage
                        className="border rounded-full bg-white h-6 w-6 mr-2"
                        src={avatar}
                      />
                    </Avatar>
                    <span className="text-sm font-semibold">{name}</span>
                  </div>
                  <div className="text-white hover:text-yellow-400 cursor-pointer">
                    <Icons.bookmark />
                  </div>
                </div>
                <div className="flex">
                  <CardHeader className="p-0">
                    <CardTitle>{title}</CardTitle>
                    <CardDescription className="text-md w-2/3 pt-4">
                      {desc}
                    </CardDescription>
                  </CardHeader>
                  <CardContent className="p-0">
                    <img
                      className="h-[150px] w-[300px] bg-white rounded-2xl object-contain"
                      src={thumbnail}
                    />
                  </CardContent>
                </div>
                <div className="flex gap-2 w-full">
                  {hashtags?.map((hashtag: any) => (
                    <div className="px-3 py-0.5 rounded-3xl cursor-pointer transition ease-linear border border-slate-500 bg-slate-900 hover:bg-slate-800">
                      {hashtag}
                    </div>
                  ))}
                </div>
              </Card>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
