import clsx from "clsx";
import { Button } from "./ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "./ui/card";

interface Props {
  header: string;
  description: string;
  thumbnail?: string;
  content: string;
  type: string;
}

export function CourseCard(props: Props) {
  const { header, description, thumbnail, content, type } = props;

  return (
    <Card className="flex flex-col space-y-3">
      <img
        src={thumbnail}
        className={clsx("rounded-xl", {
          "h-[250px] w-full ": type === "banner",
          "h-[125px] w-[250px]": type === "card",
        })}
      />
      <CardHeader>
        <CardTitle>
          {header}
        </CardTitle>
        <CardDescription>
          {description}
        </CardDescription>
      </CardHeader>
      <CardContent>
        <span className="text-md font-semibold">{content}</span>
      </CardContent>
      <CardFooter>
        <Button className="w-full">Registry</Button>
      </CardFooter>
    </Card>
  );
}
