import React, { useState, useEffect } from 'react';
import '../Components/style/AllDepartment.css'; 

function AllDepartment() {

  const [departmentList, setDepartmentList] = useState([{deptId:'', deptName:''}]);
  const backendUrl = 'http://localhost:8080/api/dept/allDepartment';

  useEffect(() => {
    // Fetch department data from the backend when the component mounts
    fetch(backendUrl)
      .then((response) => response.json())
      .then((data) => setDepartmentList(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, [backendUrl]);

  const handleDelete = (id) => {
    // Send a DELETE request to the backend to remove the department
    fetch(`${backendUrl}/${id}`, {
      method: 'DELETE',
    })
      .then((response) => {
        if (response.ok) {
          // If the deletion was successful, remove the department from the frontend state
          setDepartmentList((prevDepartments) =>
            prevDepartments.filter((dept) => dept.id !== id)
          );
        } else {
          console.error('Error deleting department:', response.statusText);
        }
      })
      .catch((error) => console.error('Error deleting department:', error));
  };

  const departmentCards = departmentList.map((department) => (
    <div key={department.id} className="department-card">
      <h2 className="department-title">{department.deptTitle}</h2>
      <p className="department-body">{department.deptName}</p>
      <button onClick={() => handleDelete(department.id)} className="delete-button">
        Delete
      </button>
    </div>
  ));

  return (
    <div className="department-list">
      {departmentCards}
    </div>
  );
}

export default AllDepartment;