import { authOptions } from "@/lib/auth/authOptions";
import { getServerSession } from "next-auth";
import { NextResponse } from "next/server";

export const GET = async () => {
  const session = await getServerSession(authOptions);

  return !session
    ? NextResponse.json({ error: "Not authorized" }, { status: 400 })
    : NextResponse.json({ success: session }, { status: 200 });
};
