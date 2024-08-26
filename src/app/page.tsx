import { ListCourses } from "@/components/list-of-courses";

export default function Home() {
  function Course({ courseName }: { courseName: string }) {
    return (
      <div className="mb-2">
        <h1 className="text-2xl my-2">{courseName}</h1>
        <ListCourses type="card" />
      </div>
    );
  }

  return (
    <div className="flex flex-col justify-center items-center">
      <div className="w-1/5">
        <ListCourses type="banner" />
      </div>
      <div className="w-2/3 flex flex-col">
        <Course courseName="Front-end" />
        <Course courseName="Back-end" />
        <Course courseName="Springboot" />
      </div>
    </div>
  );
}
