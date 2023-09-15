import React from "react";
import { Link, Outlet, useNavigate } from "react-router-dom";
import { Menu } from "antd";
import "../Components/style/AdminSidebar.css";
import Header from "../Components/Header";

import {
  HomeFilled,
  DeleteFilled,
  EyeFilled,
  UserOutlined,
  PoweroffOutlined,
  MessageFilled,
  PlusCircleFilled,
  UserAddOutlined,
  SecurityScanOutlined,
  UsergroupDeleteOutlined,
} from "@ant-design/icons";




function AdminSidebar() {
  let navigatee = useNavigate();

  const handleLogout = () => {
      // localStorage.clear();
      sessionStorage.clear();
      navigatee("/");
  };
  return (
    <>
    <Header name={sessionStorage.getItem("session_user_name")} role="admin" />
      <div className="sidebar-parent">
        <div className="menu">
          <Menu
            items={[
              { label: <Link to="adminHome">Home</Link>, icon: <HomeFilled /> },
              {
                label: <Link to="allUsers">All Users</Link>,
                icon: <UserOutlined />,
              },
              {
                label: <Link to="addUser">Add User</Link>,
                icon: <UserAddOutlined />,
              },
              {
                label: <Link to="deleteUser">Delete User</Link>,
                icon: <UsergroupDeleteOutlined />,
              },
              {
                label: <Link to="allFeedback">All Feedback/Grevience</Link>,
                icon: <MessageFilled />,
              },
              {
                label: <Link to="createTicket">Create Ticket</Link>,
                icon: <PlusCircleFilled />,
              },
              {
                label: <Link to="createDept">Create Department</Link>,
                icon: <PlusCircleFilled />,
              },
              {
                label: <Link to="viewDept">View Departments</Link>,
                icon: <EyeFilled />,
              },
              {
                label: <Link to="deleteDept">Delete Department</Link>,
                icon: <DeleteFilled />,
              },
              {
                label: <Link to="changePassword">Change Password</Link>,
                icon: <SecurityScanOutlined />,
              },
              {
                label: <span onClick={handleLogout}>LogOut</span>,
                icon: <PoweroffOutlined />,
                danger: true,
              },
            ]}
          />
        </div>
        <div className="admin-content">
          <Outlet/>
        </div>
      </div>
    </>
  );
}


export default AdminSidebar;
