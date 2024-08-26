"use client";

import Autoplay from "embla-carousel-autoplay";
import { useRef } from "react";
import clsx from "clsx";

import {
  Carousel,
  CarouselContent,
  CarouselItem,
  CarouselNext,
  CarouselPrevious,
} from "@/components/ui/carousel";
import { CourseCard } from "./course-card";

export function ListCourses(props: any) {
  const { type } = props;

  const plugin = useRef(
    Autoplay({ delay: 3000, stopOnInteraction: true }),
  );

  return (
    <div className="flex justify-center items-center">
      <Carousel
        plugins={type === "banner" ? [plugin.current] : []}
        className="max-w-7xl"
        onMouseEnter={plugin.current.stop}
        onMouseLeave={plugin.current.reset}
      >
        <CarouselContent className="-ml-1">
          {Array.from({ length: 10 }).map((_, index) => (
            <CarouselItem
              key={index}
              className={clsx("pl-1 md:basis-1/2", {
                "lg:basis-11/12": type === "banner",
                "lg:basis-1/5": type === "card",
              })}
            >
              <div className="p-1">
                <CourseCard
                  header={`Card ${index + 1}`}
                  description={`This is card ${index + 1}`}
                  content={`${index + 1}`}
                  type={type as string}
                />
              </div>
            </CarouselItem>
          ))}
        </CarouselContent>
        {type === "banner" ? <></> : (
          <>
            <CarouselPrevious />
            <CarouselNext />
          </>
        )}
      </Carousel>
    </div>
  );
}
