import React, { useState, useEffect } from 'react';
import '../Components/style/AllDepartment.css';

function AllDepartment() {
  const [departmentList, setDepartmentList] = useState([{deptId:'', deptName:''}]);
  

  useEffect(() => {
    fetch('http://localhost:8080/api/dept/allDepartment')
      .then(response => response.json())
      .then(data => setDepartmentList(data))
      .catch(error => console.error('Error:', error));
  }, []);





  const departmentCards = departmentList.map((department) => (
    <div key={department.id} className="department-card">
      <p className="department-title">{department.deptId}</p>
      <h2 className="department-body">{department.deptName}</h2>
    </div>
  ));

  return (
    <div className="department-list">
      {console.log(departmentList)}
      {departmentCards}
    </div>
  );
}

export default AllDepartment;
