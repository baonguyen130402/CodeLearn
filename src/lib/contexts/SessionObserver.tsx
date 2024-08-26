"use client";

import { SessionProvider } from "next-auth/react";

const SessionObserver = ({ children }: { children: React.ReactNode }) => {
  return <SessionProvider>{children}</SessionProvider>;
};

export default SessionObserver;
