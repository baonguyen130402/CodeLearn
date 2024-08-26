import { useState } from "react";

const useForm = (initialValue: { [key: string]: any }) => {
  const [formValues, setFormValues] = useState(initialValue);

  return [
    formValues,
    (event: any) =>
      setFormValues({
        ...formValues,
        [event.currentTarget.name]: event.currentTarget.value,
      }),
  ] as const;
};

export default useForm;
