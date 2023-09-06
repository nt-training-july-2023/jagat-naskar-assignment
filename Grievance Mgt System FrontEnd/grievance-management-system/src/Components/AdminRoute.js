import AdminHome from "./AdminHome";
import NewUser from "./CommonComponents/NewUser";
import Login from "./CommonComponents/Login";
import React from "react";
import { Route, Routes } from "react-router-dom";
import NewDepartment from "./NewDepartment";
import AllDepartment from "./AllDepartment";
import DeleteDepartment from "./DeleteDepartment";
import AllUsers from "./AllUsers";
import DeleteUser from "./DeleteUser";

function AdminRoute() {
    return (
      <>
        <Routes>
          <Route path="/" element={<AdminHome />} />
          <Route path="/addUser" element={<NewUser />} />
          <Route path="/logout" element={<Login />} />
  
          <Route path="/allUsers" element={<AllUsers/>} />
          <Route path="/deleteUser" element={<DeleteUser/>} />
          <Route
            path="/allFeedback"
            element={<div>All Feedback & Greviance Page</div>}
          />
          <Route path="/createDept" element={<NewDepartment/>} />
          <Route path="/viewDept" element={<AllDepartment/>} />
          <Route path="/deleteDept" element={<DeleteDepartment/>} />
        </Routes>
      </>
    );
  }

  export default AdminRoute;