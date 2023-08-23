import React, { useState } from "react";
import "../style/Login.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Login = (props) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [post, setPost] = useState({ userName: "", password: "" });
  let navigate = useNavigate();


  const handleLogin = async (e) => {
    e.preventDefault();

    if (username.trim() === "") {
      setError("Username is required");
    } else if (password.trim() === "") {
      setError("Password is required");
    } else {
      setError("");
      setIsSubmitted(true);
      post.userName = username;
      post.password = password;
      // Backend login logic here...
      setPost({ ...post });
      console.log("Login data:", username, password);
      console.log(post);
      try {
        const res = await axios.post(
          "http://localhost:8080/api/users/login",
          post
        );
        console.log(res.data);
        if (res.data === true) {
          navigate("/home");
        } else if(res.data === false) {
          //alert("UserName or Password Incorect");
          toast.warning("UserName or Password Incorect!!!");
          resetForm();
        }
      } catch (e) {
        alert(e);
      }
    }
  };

  const resetForm = () => {
    setUsername("");
    setPassword("");
    setIsSubmitted(false);
  };
  return (
    <div className="login-body">
      <div className="head">
        <h1>Feedback Management System</h1>
      </div>
      <div className="login-page">
        <h2>Login</h2>
        <div className="error1">
          {error && <p className="error-message">{error}</p>}
        </div>
        <form onSubmit={handleLogin}>
          <div className="form-group">
            <label htmlFor="username">Username</label>
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
            <label htmlFor="password">Password</label>
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

          <button type="submit">Login</button>
          <ToastContainer/>
        </form>
      </div>
    </div>
  );
};

export default Login;
