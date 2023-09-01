import React from 'react';
import '../Components/style/Header.css'; 
function Header(props) {
  const { name, role } = props;

  return (
    <div className="admin-header">
      <h1>Greviance Management System</h1>
      <p>{role}</p>
      <h3>{name}</h3>
    </div>
  );
}

export default Header;
