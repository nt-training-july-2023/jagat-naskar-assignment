import React from "react";
import { Link, Outlet, useNavigate } from "react-router-dom";
import { Menu } from "antd";
import "../Components/style/AdminSidebar.css";
import Header from "../Components/Header";

import {
  HomeFilled,
  DeleteFilled,
  EyeFilled,
  MehFilled,
  PoweroffOutlined,
  MessageFilled,
  PlusCircleFilled,
  FileAddFilled,
  UnorderedListOutlined,
} from "@ant-design/icons";
import { doLogout } from "..";



function MemberSidebar() {
  let navigatee = useNavigate();

  const handleLogout = () => {
    // localStorage.clear();
    sessionStorage.clear();
    navigatee("/");
  };
  return (
    <>
    <Header name={sessionStorage.getItem("session_user_name")} role="member" />
      <div className="sidebar-parent">
        <div className="menu">
          <Menu
            items={[
              { label: <Link to="memberHome">Member Home</Link>, icon: <HomeFilled /> },
              {
                label: <Link to="">ABC1</Link>,
                icon: <MehFilled />,
              },
              {
                label: <Link to="">ABC2</Link>,
                icon: <FileAddFilled />,
              },
              {
                label: <Link to="myTickets">My Tickets</Link>,
                icon: <DeleteFilled />,
              },
              {
                label: <Link to="myDeptTicket">My Department Ticket</Link>,
                icon: <MessageFilled />,
              },
              {
                label: <Link to="createTicket">Create Ticket</Link>,
                icon: <PlusCircleFilled />,
              },
              {
                label: <Link to="">ABC3</Link>,
                icon: <EyeFilled />,
              },
              {
                label: <Link to="">ABC4</Link>,
                icon: <DeleteFilled />,
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
          <Outlet />
        </div>
      </div>
    </>
  );
}


export default MemberSidebar;
