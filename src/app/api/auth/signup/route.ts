const POST = async (request: Request) => {
  try {
    const { email, password } = await request.json();

    console.log({email, password})
  } catch (error: any) {
    console.log(error);
  }
};
