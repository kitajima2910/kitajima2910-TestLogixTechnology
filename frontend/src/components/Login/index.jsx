import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { Link, useNavigate } from "react-router-dom";
import "./style.css";
import axios from "axios";

function Login() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const navigate = useNavigate();
  const [message, setMessage] = useState("");
  const auth = JSON.parse(localStorage.getItem("user")) ?? null;

  const onSubmit = (data) => {
    axios
      .post("http://localhost:8080/api/auth/login", data)
      .then((res) => {
        if (res.data === "Fail") {
          setMessage("Incorrect account or password");
        } else {
          localStorage.setItem("user", JSON.stringify(res.data));
          navigate("/");
        }
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    if(auth !== null) {
      navigate("/");
    }
  })

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div>
        {message && (
          <span style={{ textAlign: "center", marginTop: "5px", color: "red" }}>
            {message}
          </span>
        )}
        <input
          name="email"
          placeholder="Email"
          ref={register({
            required: {
              value: true,
              message: "Email cannot be blank",
            },
            pattern: {
              value: /^[\w.]+@\w{2,}(\.\w{2,}){1,2}$/,
              message: "Email is not in the correct format",
            },
          })}
        />
        <span style={{ color: "red", paddingLeft: "20px", fontSize: "12px" }}>
          {errors.email?.message}
        </span>
        <input
          type="password"
          name="password"
          placeholder="Password"
          ref={register({
            required: {
              value: true,
              message: "Password can not be blank",
            },
            minLength: {
              value: 6,
              message: "Password must not be less than 6 characters",
            },
            pattern: {
              value: /^[^\s]+$/,
              message: "Password must not have spaces",
            },
          })}
        />
        <span style={{ color: "red", paddingLeft: "20px", fontSize: "12px" }}>
          {errors.password?.message}
        </span>
      </div>
      <div>
        <input type="submit" value="SUBMIT" />
        <Link to="/register">Register</Link>
      </div>
    </form>
  );
}

export default Login;
