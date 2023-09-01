import AdminHome from "./AdminHome";
import NewUser from "./CommonComponents/NewUser";
import Login from "./CommonComponents/Login";
import React from "react";
import { Route, Routes } from "react-router-dom";

function AdminRoute() {
    return (
      <>
        <Routes>
          <Route path="/" element={<AdminHome />} />
          <Route path="/addUser" element={<NewUser />} />
          <Route path="/logout" element={<Login />} />
  
          <Route path="/allUsers" element={<div>All Users Page</div>} />
          <Route path="/deleteUser" element={<div>Delete Users Page</div>} />
          <Route
            path="/allFeedback"
            element={<div>All Feedback & Greviance Page</div>}
          />
          <Route path="/createDept" element={<div>Create Department Page</div>} />
          <Route path="/viewDept" element={<div>View Department Page</div>} />
          <Route path="/deleteDept" element={<div>Delete Department Page</div>} />
        </Routes>
      </>
    );
  }

  export default AdminRoute;