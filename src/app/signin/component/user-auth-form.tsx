"use client";

import React from "react";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";

import { Button } from "@/components/ui/button";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { toast } from "sonner";
import Link from "next/link";
import { Icons } from "@/components/icons/icons";
import { useGoogleOneTapLogin } from "react-google-one-tap-login";

const formSchema = z
  .object({
    email: z
      .string()
      .min(1, {
        message: "This field has to be filled.",
      })
      .email("This is not a valid email"),
    password: z
      .string()
      .min(6, { message: "Password has to be at least 6 characters long." })
      .max(300, {
        message: "Password can't be longer than 32 characters.",
      }),
  });

const SignInForm = () => {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {},
  });
  
  useGoogleOneTapLogin({
    onSuccess: (res) => console.log(res),
    onError: (err) => console.log(err),
    googleAccountConfigs: {
      client_id: process.env.GOOGLE_CLIENT_ID as string
    }
  });

  async function onSubmit(values: z.infer<typeof formSchema>) {
    const response = await fetch(`/api/auth/register`, {
      method: "POST",
      body: JSON.stringify(values),
    });

    const data = await response.json();

    if (data.error) {
      toast.error(data.error);
    }

    toast.success("Account created!");
  }

  return (
    <div className="border lg:p-4 md:p-2 rounded-2xl mx-auto flex w-full flex-col justify-center sm:w-[350px]">
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
          <h1 className="text-2xl text-center font-semibold">Sign In</h1>
          <FormField
            control={form.control}
            name="email"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Email</FormLabel>
                <FormControl>
                  <Input placeholder="johndoe@whatever.com" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="password"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Password</FormLabel>
                <FormControl>
                  <Input type="password" {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <Link className="block hover:underline text-sm" href={"/login"}>
            Not have an account?
          </Link>
          <Button type="submit" className="w-full">
            Sign In with
            <Icons.logo className="pl-1 pr-0.5 w-[28px] font-extrabold" />
            account
          </Button>
        </form>
      </Form>
    </div>
  );
};

export default SignInForm;
