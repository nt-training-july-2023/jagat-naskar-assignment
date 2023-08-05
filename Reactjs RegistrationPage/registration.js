import React from 'react';
import './style.css';
const RegistrationPage = () => {
  return (
    <div>
      <meta charSet="utf-8" />
      <title>Register_Form</title>
      <link rel="stylesheet" href="style.css" />
      <form id="signup-form" action="/register" method="post">
        <div className="form-header">
          Registration
          <hr />
        </div>
        {/*Body start*/}
        <div className="form-body">
          <div className="Parent">
            <div className="child">
              <label> Full Name </label><br />
              <input type="text" name="fullname" id="f1" placeholder="Enter Your name" />
            </div>
            <div className="child">
              <label> Username </label><br />
              <input type="text" name="username" id="f1" placeholder="Enter your username" /> <br /> <br />
            </div>
          </div>
          <div className="Parent">
            <div className="child">
              <label> Email </label><br />
              <input type="email" name="email" id="f1" placeholder="Enter Your email" />
            </div>
            <div className="child">
              <label> Phone number </label><br />
              <input type="number" name="Phone" id="f1" placeholder="Enter your number" /> <br /> <br />
            </div>
          </div>
          <div className="Parent">
            <div className="child">
              <label> Password </label><br />
              <input type="password" name="password" id="f1" placeholder="Enter Your password" />
            </div>
            <div className="child">
              <label> Confirm Password </label><br />
              <input type="password" name="conPassword" id="f1" s placeholder="Confirm your password" /> <br /> <br />
            </div>
          </div>
          <div className="Parent">
            <div className="child1">
              <label> Gender </label><br /><br />
              <input type="radio" name="radio-group" id="male" defaultValue="Male" defaultChecked />
              <label htmlFor="male">Male</label>
              <input type="radio" name="radio-group" id="female" defaultValue="Female" defaultChecked />
              <label htmlFor="female">Female</label>
              <input type="radio" name="radio-group" id="other" defaultValue="other" defaultChecked />
              <label htmlFor="other">Prefer not to say</label><br /><br />
            </div>
          </div>
          <button type="button" id="register">Register</button>
        </div> {/*Body end*/}
      </form>
    </div>
  );
};

export default RegistrationPage;