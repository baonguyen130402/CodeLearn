import CardRoadMap from "./component/Card";

export default function RoadMapPage() {
  const Cards = [
    {
      title: "Front-end",
      content:
        "Lorem ipsum dolor sit amet, qui minim labore adipisicing minim sint cillum sint consectetur cupidatat.",
      image: "/favicon/fe.png",
    },
    {
      title: "Back-end",
      content:
        "Lorem ipsum dolor sit amet, qui minim labore adipisicing minim sint cillum sint consectetur cupidatat.",
      image: "/favicon/be.png",
    },
    {
      title: "DevOps",
      content:
        "Lorem ipsum dolor sit amet, qui minim labore adipisicing minim sint cillum sint consectetur cupidatat.",
      image: "/favicon/devops.png",
    },
    {
      title: "Game Developers",
      content:
        "Lorem ipsum dolor sit amet, qui minim labore adipisicing minim sint cillum sint consectetur cupidatat.",
      image: "/favicon/gamedev.png",
    },
  ];
  
  return (
    <div className="pl-16 py-2 flex flex-col justify-center items-start container">
      <span className="text-3xl font-extrabold mb-10">
        Roadmap
      </span>
      <p className="w-3/5 text-gray-400 font-light">
        Lorem ipsum dolor sit amet, officia excepteur ex fugiat reprehenderit
        enim labore culpa sint ad nisi Lorem pariatur mollit ex esse
        exercitation amet. Nisi anim cupidatat excepteur officia. Reprehenderit
        nostrud nostrud ipsum Lorem est aliquip amet voluptate voluptate dolor
        minim nulla est proident.
      </p>
      <div className="grid grid-cols-2 gap-16 mt-16">
        {Cards.map((card) => (
          <div>
            <CardRoadMap
              title={card.title}
              content={card.content}
              image={card.image}
            />
          </div>
        ))}
      </div>
    </div>
  );
}
