
import React from "react";
import { Navigate, Outlet } from "react-router-dom";

const PrivateRoute = () => {
  const auth = JSON.parse(localStorage.getItem("user")) ?? null;


  if (!auth?.email) {
    return <Navigate to="/login"/>;
  }

  return <Outlet />;;
};

export default PrivateRoute;