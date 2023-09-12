// import React, { useState } from "react";
// import CustomAlert from "./CustomAlert";
// import axios from "axios";
// import "../style/NewUser.css";

// export default function NewUser() {
//   const [name, setName] = useState("");
//   const [nameError, setNameError] = useState("");
//   const [username, setUsername] = useState("");
//   const [usernameError, setUsernameError] = useState("");
//   const [password, setPassword] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const [userType, setUserType] = useState("");
//   const [userTypeError, setUserTypeError] = useState("");
//   const [departmentName, setDepartmentName] = useState("");
//   const [deptNameError, setDeptNameError] = useState("");
//   const [showAlert, setShowAlert] = useState(false);
//   const [message, setMessage] = useState("");

//   const handleShowAlert = () => {
//     setShowAlert(true);
//   };
  
//   const handleCloseAlert = () => {
//     setShowAlert(false);
//   };

//   const resetForm = () => {
//     setName("");
//     setUsername("");
//     setPassword("");
//     setUserType("Select User Type"); 
//     setDepartmentName("Select Department");
//   };

//   const validateName = () => {
//     setName(name.trim());
//     if (name === "") {
//       setNameError("Required field*");
//     } else if (name.length < 3) {
//       setNameError("Min length is 3");
//     } else if (name.length > 25) {
//       setNameError("Max length is 25");
//     } else {
//       setNameError("");
//     }
//   };

//   const validateUsername = () => {
//     setUsername(username.trim());
//     if (username === "") {
//       setUsernameError("Required field*");
//     } else if (!/^[A-Za-z0-9_.-]+@nucleusteq\.com$/i.test(username)) {
//       setUsernameError("Invalid email format");
//     } else {
//       setUsernameError("");
//     }
//   };

//   const validatePassword = () => {
//     setPassword(password.trim());
//     console.log("poa = "+password)
//     if (password === "") {
//       setPasswordError("Password is required");
//     } else if (password.length < 8) {
//       console.log("perror"+passwordError);
//       setPasswordError("Min length should be 8 characters");
//     } else if (!/[A-Z]/.test(password)) {
//       setPasswordError("At least one uppercase letter required");
//     } else if (!/[a-z]/.test(password)) {
//       setPasswordError("At least one lowercase letter required");
//     } else if (!/[0-9]/.test(password)) {
//       setPasswordError("At least one digit required");
//     } else if (!/[!@#$%^&*]/.test(password)) {
//       setPasswordError("At least one special character required");
//     } else {
//       setPasswordError("");
//     }

//     console.log("passerr"+passwordError);

//   };

//   const validateUserType = () => {
//     if (userType === "") {
//       setUserTypeError("Please select a user type");
//     } else if (userType === "Select User Type") {
//       setUserTypeError("Select user");
//     } else {
//       setUserTypeError("");
//     }
//   };

//   const validateDeptName = () => {
//     if (departmentName === "") {
//       setDeptNameError("Please select a department");
//     } else if (departmentName === "Select Department") {
//       setDeptNameError("Select Department");
//     } else {
//       setDeptNameError("");
//     }
//   };
  
//   const departmrntList = ["Select Department", "HR", "Finance", "Sales"];
//   const UserTypeList = ["Select User Type", "admin", "member"];

//   const handleSubmit = async (e) => {

//     e.preventDefault();
//     validateName();
//     validateUsername();
//     validatePassword();
//     validateUserType();
//     validateDeptName();
    

//     console.log("nameError="+passwordError);
//     console.log("usernameError="+usernameError);
//     console.log("passwordError="+passwordError);
//     console.log("userTypeError="+userTypeError);
//     console.log("deptNameError="+deptNameError);

//     if (nameError === "" && usernameError === "" && passwordError === "" && userTypeError === "" &&  deptNameError === "") {
//       const encodedPassword = btoa(password);
//       const postObject = {
//         name: name,
//         departmentName: departmentName,
//         password: encodedPassword,
//         userType: userType,
//         userName: username,
        
//       };


//       console.log("ifcondition1");
//       try {
//         const res = await axios.post(
//           "http://localhost:8080/api/users/addUser",
//           postObject
//         );
//         console.log("AfterTry2");
//         setMessage(res.data);
//         handleShowAlert();
//         resetForm();
//       } catch (e) {
//         setMessage(e.message);
//         handleShowAlert();
//         console.log("catch3");
//       }
//     } else {
//       console.log("else4");
//       setMessage("Form has validation errors.");
//       handleShowAlert();
//     }
//   };

//   return (
//     <div className="newUser-parent">
//       <form className="reg-form" onSubmit={handleSubmit} method="post">
//         <h2 className="reg-heading">Fill Details of New Users</h2>
//         <label className="label-user">
//           Name <p className="error1">{nameError}</p>{" "}
//         </label>
//         <input
//           className="input-user"
//           type="text"
//           id="name"
//           placeholder="Enter your name"
//           name="name"
//           value={name}
//           onChange={(e) => {
//             setName(e.target.value);
//           }}
//         />
//         <label className="label-user">
//           Username <p className="error1">{usernameError}</p>{" "}
//         </label>

//         <input
//           className="input-user"
//           type="text"
//           id="username"
//           placeholder="Enter your Username"
//           name="username"
//           value={username}
//           onChange={(e) => {
//             setUsername(e.target.value);
//           }}
//         />
//         <label className="label-user">
//           Initial Password <p className="error1">{passwordError}</p>{" "}
//         </label>
//         <input
//           className="input-user"
//           type="password"
//           id="password"
//           placeholder="Enter your Password"
//           name="password"
//           value={password}
//           style={{
//             width: "94%",
//             padding: "6px",
//             marginRight: "6%",
//           }}
//           onChange={(e) => {
//             setPassword(e.target.value);
//           }}
//         />
//         <label className="label-user">
//           User Type <p className="error1">{userTypeError}</p>{" "}
//         </label>
//         <select
//           className="input-user"
//           id="userType"
//           name="user_type"
//           value={userType}
//           onChange={(e) => {
//             setUserType(e.target.value);
//           }}
//         >
//           {UserTypeList.map((e) => (
//             <option key={e} value={e}>
//               {e}
//             </option>
//           ))}
//         </select>

//         <label className="label-user">
//           Department <p className="error1">{deptNameError}</p>{" "}
//         </label>
//         <select
//           className="input-user"
//           id="deptName"
//           name="dept_type"
//           value={departmentName}
//           onChange={(e) => {
//             setDepartmentName(e.target.value);
//           }}
//         >
//           {departmrntList.map((e) => (
//             <option key={e} value={e}>
//               {e}
//             </option>
//           ))}
//         </select>

//         <button type="submit"> Add User </button>
//       </form>
//       {showAlert && (
//         <CustomAlert message={message} handleCloseAlert={handleCloseAlert} />
//       )}
//     </div>
//   );
// }











import React, { useState, useEffect } from "react";
import CustomAlert from "./CommonComponents/CustomAlert";
import axios from "axios";
import "../Components/style/NewUser.css";
import {
  validateName,
  validateUsername,
  validatePassword,
  validateUserType,
  validateDeptName
} from './UserValidation';

export default function NewUser() {
  const [name, setName] = useState("");
  const [nameError, setNameError] = useState("");
  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState("");
  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [userType, setUserType] = useState("");
  const [userTypeError, setUserTypeError] = useState("");
  const [departmentName, setDepartmentName] = useState("");
  const [departmentList, setDepartmentList] = useState([{deptId:'', deptName:''}]);
  const [deptNameError, setDeptNameError] = useState("");
  const [showAlert, setShowAlert] = useState(false);
  const [message, setMessage] = useState("");

  const handleShowAlert = () => {
    setShowAlert(true);
  };
  
  const handleCloseAlert = () => {
    setShowAlert(false);
  };

  // //setting deptList from backend
  // useEffect(() => {
  //   fetch('http://localhost:8080/api/dept/allDepartment')
  //     .then(response => response.json())
  //     .then(data => setDepartmentList(data))
  //     .catch(error => console.error('Error:', error));
      
  // }, []);

  useEffect(() => {
    // Start by setting "SELECT" as the initial value
  
    fetch('http://localhost:8080/api/dept/allDepartment')
      .then(response => response.json())
      .then(data => setDepartmentList(prevList => [...prevList, ...data])) // Add "SELECT" before the fetched data
      .catch(error => console.error('deptList Error:', error));
  }, []);

  const resetForm = () => {
    //resetting field
    setName("");
    setUsername("");
    setPassword("");
    setUserType("Select User Type"); 
    setDepartmentName("Select Department");
    //resetting error
    setUsernameError("");
    setNameError("");
    setDeptNameError("");
    setPasswordError("");
    setUserTypeError("");

  };

  // const departmentList = ["Select Department", "HR", "Finance", "Sales"];
  const UserTypeList = ["Select User Type", "admin", "member"];



  //handling form after submission
  const handleSubmit = async (e) => {
    e.preventDefault();
  
    const nameError = validateName(name);
    const usernameError = validateUsername(username);
    const passwordError = validatePassword(password);
    const userTypeError = validateUserType(userType);
    const deptNameError = validateDeptName(departmentName);
  
    if (!nameError && !usernameError && !passwordError && !userTypeError && !deptNameError) {
      // Form is valid, proceed with submission
      const encodedPassword = btoa(password);
      const postObject = {
        name: name,
        departmentName: departmentName,
        password: encodedPassword,
        userType: userType,
        userName: username,
        
      };
      try {
        const res = await axios.post(
          "http://localhost:8080/api/users/addUser",
          postObject
        );
        console.log("AfterTry2");
        setMessage(res.data);
        handleShowAlert();

        resetForm();
      } catch (e) {
        setMessage(e.message);
        handleShowAlert();
        console.log("catch3");
      }
      // submitted
    } else {
      // Display errors
      setNameError(nameError);
      setUsernameError(usernameError);
      setPasswordError(passwordError);
      setUserTypeError(userTypeError);
      setDeptNameError(deptNameError);
    }
  };

  return (
    <div className="newUser-parent">
      <form className="reg-form" onSubmit={handleSubmit} method="post">
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
          value={name}
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
          value={username}
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
          value={password}
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
          value={userType}
          onChange={(e) => {
            setUserType(e.target.value);
          }}
        >
          {UserTypeList.map((e) => (
            <option key={e} value={e}>
              {e}
            </option>
          ))}
        </select>

        <label className="label-user">
          Department <p className="error1">{deptNameError}</p>{" "}
        </label>
        <select
          className="input-user"
          id="deptName"
          name="dept_type"
          value={departmentName}
          onChange={(e) => {
            setDepartmentName(e.target.value);
          }}
        >
           <option value="" disabled >
            Select a Department
            </option>
          {departmentList.map((e) => (
            <option key={e.id} value={e.deptName}>{e.deptName}</option> 
          ))}
        </select>

        <button type="submit"> Add User </button>
      </form>
      {showAlert && (
        <CustomAlert message={message} handleCloseAlert={handleCloseAlert} />
      )}
    </div>
  );
}
