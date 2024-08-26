import { Skeleton } from "@/components/ui/skeleton";

export function SkeletonPostCard() {
  return (
    <div className="relative group cursor-normal w-[989.44px] mr-24">
      <div className="relative border ring-1 ring-gray-900/5 rounded-lg leading-none flex items-top justify-start space-x-6">
        <div className="space-y-2 w-full">
          <div className="rounded-lg shadow-lg p-[0.5px]">
            <div className="rounded-md">
              <div className="p-4">
                <div className="flex items-center justify-between mb-6">
                  <div className="flex items-center">
                    <Skeleton className="border rounded-full h-6 w-6 mr-2" />
                    <Skeleton className="w-[110px] h-3" />
                  </div>
                  <Skeleton className="text-white hover:text-yellow-400 h-6 w-6 cursor-pointer" />
                </div>
                <div className="flex justify-between">
                  <div className="p-0 space-y-6">
                    <Skeleton className="w-[400px] h-6" />
                    <div className="space-y-2">
                      <Skeleton className="w-11/12 pt-4" />
                      <Skeleton className="w-2/3 pt-4" />
                    </div>
                  </div>
                  <div className="p-0">
                    <Skeleton className="h-[150px] w-[300px] rounded-2xl object-contain" />
                  </div>
                </div>
                <div className="flex gap-2 w-full">
                  {Array(2).fill(0).map((hashtag: any) => (
                    <Skeleton className="px-3 py-0.5 rounded-3xl cursor-pointer transition ease-linear" />
                  ))}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
