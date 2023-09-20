import { useNavigate } from 'react-router-dom';
import "../style/Login.css";
import axios from "axios";
import React, { useState } from 'react';
import CustomAlert from "./CustomAlert";
import { doLogin, setLoggedIn } from '../..';


const Login = (props) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [showAlert, setShowAlert] = useState(false);
  const[message, setMessage] = useState("");
  const [post, setPost] = useState({ email: "", password: "" });
  let navigatee = useNavigate();

  const handleShowAlert = () => {
    setShowAlert(true);
  };
  const handleCloseAlert=()=>{
    setShowAlert(false);
  }
  const resetForm = () => {
    setUsername("");
    setPassword("");
    setIsSubmitted(false);
  };
  const handleLogin = async (e) => {
    e.preventDefault();
    //validating
    if (username.trim() === "") {
      setError("Username is required");
    } else if (password.trim() === "") {
      setError("Password is required");
    } else {
      setError("");
      setIsSubmitted(true);
      const encodedUsername = btoa(username); // Encode username
      const encodedPassword = btoa(password); // Encode password
      post.email = encodedUsername;
      post.password = encodedPassword;
      // Backend
      setPost({ ...post });
      console.log("Login data:", username, password);
      console.log(post);
      try {
        const res = await axios.post(
          "http://localhost:8080/api/users/login", 
          post,
          {
            headers: {
              email: encodedUsername,
              password: encodedPassword
            }
          }
        );
        console.log(res.data);
        const decodedEmail = atob(post.email);
        if(res.data === "true_admin_cp"){
          sessionStorage.setItem("session_user_name", decodedEmail);
          navigatee("/changePassword");
        }
        else if (res.data === "true_admin") {
          sessionStorage.setItem("session_user_name", decodedEmail);
          setLoggedIn("true");//for private route
          navigatee("/admin");
        }
        else if(res.data === "true_member_cp"){
            sessionStorage.setItem("session_user_name", decodedEmail);
            navigatee("/changePassword");
        }else if (res.data === "true_member") {
          sessionStorage.setItem("session_user_name", decodedEmail);
          navigatee("/member");
        }
        else {
            //showing User is not valid
            setMessage("Invalid Credentials!!!")
            handleShowAlert();
            resetForm();
        }
      } catch (e) {
         //showing Backend is not connected through CustomAlert Box
        setMessage(e.message); //setting message for not having connection
        handleShowAlert(); //ShowAlert == true
      }
    }
  };

  
  return (
    <div className="login-body">
      <div className="head">
        <h1>Greviance Management System</h1>
      </div>
      <div className="login-page">
        <h2>Login</h2>
        <div className="error1">
          {error && <p className="error-message">{error}</p>}
        </div>
        <form onSubmit={handleLogin} method='post'>
          <div className="form-group">
            <label id="label-username">Username</label>
            <input
              type="text"
              id="username"
              placeholder="Enter your username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            {isSubmitted && username.trim() === "" && (
              <p className="error-message">Username is required</p>
            )}
          </div>
          <div className="form-group">
            <label id="label-password">Password</label>
            <input
              type="password"
              id="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            {isSubmitted && password.trim() === "" && (
              <p className="error-message">Password is required</p>
            )}
          </div>
          {
            showAlert &&
              <CustomAlert message = {message} handleCloseAlert={handleCloseAlert}/>
          }
          
          <button type="submit" >Login</button>
        </form>
      </div>
    </div>
  );
};

export default Login;






   //using headers sending data
// import { useNavigate } from 'react-router-dom';
// import "../style/Login.css";
// import axios from "axios";
// import React, { useState } from 'react';
// import CustomAlert from "./CustomAlert";
// import { doLogin, setLoggedIn } from '../..';

// const Login = (props) => {
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [error, setError] = useState("");
//   const [isSubmitted, setIsSubmitted] = useState(false);
//   const [showAlert, setShowAlert] = useState(false);
//   const [message, setMessage] = useState("");
//   let navigatee = useNavigate();

//   const handleShowAlert = () => {
//     setShowAlert(true);
//   };

//   const handleCloseAlert = () => {
//     setShowAlert(false);
//   }

//   const handleLogin = async (e) => {
//     e.preventDefault();
//     // validating
//     if (username.trim() === "") {
//       setError("Username is required");
//     } else if (password.trim() === "") {
//       setError("Password is required");
//     } else {
//       setError("");
//       setIsSubmitted(true);
//       const encodedUsername = btoa(username); // Encode username
//       const encodedPassword = btoa(password); // Encode password
//       // Backend
//       console.log("Login data:", encodedUsername, encodedPassword);

//       try {
//         const res = await axios.post(
//           "http://localhost:8080/api/users/login",{
//             headers:{
//               // 'Content-Type': 'application/json',
//                email: encodedUsername, password: encodedPassword },
//           }          
//         );
//           // console.log("HEader = "+headers)
//         console.log("--"+res.data);

//         if (res.data === "true_admin") {
//           sessionStorage.setItem("session_user_name", username);
//           setLoggedIn("true");//for private route
//           resetForm();
//           navigatee("/admin");
//         } else if (res.data === "true_member") {
//           sessionStorage.setItem("session_user_name", username);
//           setLoggedIn("true");//for private route
//           resetForm();
//           navigatee("/member");
//         } else {
//           // showing User is not valid
//           setMessage("User not exist!!!")
//           handleShowAlert();
//           resetForm();
//         }
//       } catch (e) {
//         // showing Backend is not connected through CustomAlert Box
//         setMessage(e.message); // setting message for not having connection
//         handleShowAlert(); // ShowAlert == true
//       }
//     }
//   };

//   const resetForm = () => {
//     setUsername("");
//     setPassword("");
//     setIsSubmitted(false);
//   };

//   return (
//     <div className="login-body">
//       <div className="head">
//         <h1>Greviance Management System</h1>
//       </div>
//       <div className="login-page">
//         <h2>Login</h2>
//         <div className="error1">
//           {error && <p className="error-message">{error}</p>}
//         </div>
//         <form onSubmit={handleLogin} method='post'>
//           <div className="form-group">
//             <label id="label-username">Username</label>
//             <input
//               type="text"
//               id="username"
//               placeholder="Enter your username"
//               value={username}
//               onChange={(e) => setUsername(e.target.value)}
//             />
//             {isSubmitted && username.trim() === "" && (
//               <p className="error-message">Username is required</p>
//             )}
//           </div>
//           <div className="form-group">
//             <label id="label-password">Password</label>
//             <input
//               type="password"
//               id="password"
//               placeholder="Enter your password"
//               value={password}
//               onChange={(e) => setPassword(e.target.value)}
//             />
//             {isSubmitted && password.trim() === "" && (
//               <p className="error-message">Password is required</p>
//             )}
//           </div>
//           {
//             showAlert &&
//             <CustomAlert message={message} handleCloseAlert={handleCloseAlert} />
//           }
//           <button type="submit">Login</button>
//         </form>
//       </div>
//     </div>
//   );
// };

// export default Login;