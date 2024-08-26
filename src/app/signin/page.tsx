import { authOptions } from "@/lib/auth/authOptions";

import { getServerSession } from "next-auth";
import { redirect } from "next/navigation";
import SignInForm from "./component/user-auth-form";

const Home = async () => {
  const session = await getServerSession(authOptions);

  if (session) {
    redirect("/");
  }

  return (
    <div className="w-f">
      <SignInForm />
    </div>
  );
};

export default Home;
