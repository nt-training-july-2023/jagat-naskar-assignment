import React from "react";

class Navbar extends React.Component {
  render() {
    return (
      <>
        {" "}
        <p>------------------Navbar----------------------</p>
        <nav className="navbar navbar-expand-lg bg-dark navbar-dark">
          <div className="container-fluid">
            <a className="navbar-brand" href="http://localhost:3000/">
              Flipkart
            </a>
          </div>
        </nav>
      </>
    );
  }
}

export default Navbar;
