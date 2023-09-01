import React, { useState } from "react";
import CustomAlert from "./CustomAlert";
import axios from "axios";
import "../style/NewUser.css";

export default function NewUser() {
  const [name, setName] = useState("");
  const [nameError, setNameError] = useState("");
  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState("");
  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [userType, setUserType] = useState("");
  const [userTypeError, setUserTypeError] = useState("");
  const [department, setDepartment] = useState({"deptName": ""});
  const [deptNameError, setDeptNameError] = useState("");
  const [showAlert, setShowAlert] = useState(false);
  const [message, setMessage] = useState("");
  const [post, setPost] = useState({
    name: "",
    userName: "",
    password: "",
    userType: "",
    department: null,
  });

    const handleShowAlert = () => {
      setShowAlert(true);
    };
    const handleCloseAlert = () => {
      setShowAlert(false);
    };

    const resetForm = () => {
      setName("");
      setUsername("");
      setPassword("");
      setUserType("");
      setDepartment({"deptName": ""});
    };

    const validateName = () => {
      if (name.trim() === "") {
        setNameError("required fields*");
      } else if (name.length < 3) {
        setNameError("Min len is 3");
      } else if (name.length > 25) {
        setNameError("Max len is 25");
      } else {
        setNameError("");
      }
    };

    const validateUsername = () => {
      if (username.trim() === "") {
        setUsernameError("required filed*");
      } else if (!/^[A-Za-z0-9_.-]+@nucleusteq\.com$/i.test(username)) {
        setUsernameError("Your email pattern is incorrect");
      } else {
        setUsernameError("");
      }
    };

    const validatePassword = () => {
      if (password === "") {
        setPasswordError("Password is required");
      } else if (password.length < 8) {
        setPasswordError("min len should be 8 char");
      } else if (!/[A-Z]/.test(password)) {
        setPasswordError("min Uppercase should be 1");
      } else if (!/[a-z]/.test(password)) {
        setPasswordError("Min lowercase should be 1");
      } else if (!/[0-9]/.test(password)) {
        setPassword("min number should be 1");
      } else if (!/[!@#$%^&*]/.test(password)) {
        setPasswordError("min symbol should be 1");
      } else {
        setPasswordError("");
      }
    };

    const validateUserType = () => {
      if (userType === "") {
        setUserTypeError("Please select a user type");
      } else if (userType === "Select User Type") {
        setUserTypeError("Select user");
      } else {
        setUserTypeError("");
      }
    };

    const validateDeptName = () => {
      if (department.deptName === "") {
        setDeptNameError("Please select a department");
      } else if (department.deptName === "Select Department") {
        setUserTypeError("Select Department");
      } else {
        setDeptNameError("");
      }
    };
    const departmrnt = ["Select Department", "HR", "Finance", "Sales"];
    const UserTypeList = ["Select User Type", "admin", "member"];

    const handleSubmit = async (e) => {
      e.preventDefault();
      
      validateName();
      validateUsername();
      validatePassword();
      validateUserType();
      validateDeptName();

      if (!(
        nameError &&
        usernameError &&
        passwordError &&
        userTypeError &&
        deptNameError)
      ) {
        // Validation successful, proceed with form submission and backend interactions
        console.log(
          "Registration data:",
          name,
          username,
          password,
          userType,
          department.deptName
        );




        //creating object to send
        post.name = name;
        post.department = department;
        post.password = password;
        post.userType = userType;
        post.userName = username;
        setPost({ ...post });
        console.log("POST="+post);
        console.log("POS usernameT="+post.userName);
        console.log("POST deptname="+post.department.deptName);
        console.log("POST password="+post.password);
        console.log("POst tpye="+post.userType);
        console.log("post name"+post.name)
        try {
          const res = await axios.post(
            "http://localhost:8080/api/users/addUser",
            post);
          //resetForm();
          
          if(res.data === "User saved!!!")
          {
             resetForm();//-->not working
          }console.log("RES = "+res.data);
          handleShowAlert();
          setMessage(res.data);
          
        } catch (e) {
          handleShowAlert(e.message);
          setMessage(e.message);
        }











        // Reset the form after successful submission
        // resetForm();
        
      } else {
        // Displaying validation errors
        console.log("Form has validation errors.");
        setMessage("Form has validation errors.");
        handleShowAlert();
      }
    };

    return (
      <div className="newUser-parent">
        <form className="reg-form" onSubmit={handleSubmit}>
          <h2 className="reg-heading">Fill Details of New Users</h2>
          <label className="label-user">
            Name <p className="error1">{nameError}</p>{" "}
          </label>
          <input
            className="input-user"
            type="text"
            id="name"
            placeholder="Enter your name"
            name="name"
            onChange={(e) => {
              setName(e.target.value);
            }}
          />
          <label className="label-user">
            Username <p className="error1">{usernameError}</p>{" "}
          </label>

          <input
            className="input-user"
            type="text"
            id="username"
            placeholder="Enter your Username"
            name="username"
            onChange={(e) => {
              setUsername(e.target.value);
            }}
          />
          <label className="label-user">
            Initial Password <p className="error1">{passwordError}</p>{" "}
          </label>
          <input
            className="input-user"
            type="password"
            id="password"
            placeholder="Enter your Password"
            name="password"
            style={{
              width: "94%",
              padding: "6px",
              marginRight: "6%",
            }}
            onChange={(e) => {
              setPassword(e.target.value);
            }}
          />
          <label className="label-user">
            User Type <p className="error1">{userTypeError}</p>{" "}
          </label>
          <select
            className="input-user"
            id="userType"
            name="user_type"
            onChange={(e) => {
              setUserType(e.target.value);
            }}
          >
            {UserTypeList.map((e) => (
              <option value={e}>{e}</option>
            ))
            }
          </select>

          <label className="label-user">
            Department <p className="error1">{deptNameError}</p>{" "}
          </label>
          <select
            className="input-user"
            id="deptName"
            name="dept_type"
            onChange={(e) => {
              setDepartment({ ...department, deptName: e.target.value});
            }}
          >
            {departmrnt.map((e) => (
              <option value={e}>{e}</option>

            ))}
          </select>

          <button type="submit">Add User</button>
        </form>
        {showAlert && (
          <CustomAlert message={message} handleCloseAlert={handleCloseAlert} />
        )}
      </div>
    );
  
}
