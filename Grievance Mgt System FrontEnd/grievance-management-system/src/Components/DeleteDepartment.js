import React, { useState } from 'react';
import '../Components/style/AllDepartment.css';

function DeleteDepartment() {
  const [departments, setDepartments] = useState([
    { id: 1, deptTitle: 'Department 1', deptName: 'Engineering' },
    { id: 2, deptTitle: 'Department 2', deptName: 'Marketing' },
    { id: 3, deptTitle: 'Department 3', deptName: 'Finance' },
    { id: 4, deptTitle: 'Department 4', deptName: 'HR' },
    { id: 5, deptTitle: 'Department 5', deptName: 'Sales' },
    { id: 6, deptTitle: 'Department 6', deptName: 'IT' },
  ]);

  const handleDelete = (id) => {
    const updatedDepartments = departments.filter((dept) => dept.id !== id);
    setDepartments(updatedDepartments);
  };

  const departmentCards = departments.map((department) => (
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

export default DeleteDepartment;






































// import React, { useState, useEffect } from 'react';
// import '../Components/style/AllDepartment.css'; 

// function AllDepartment() {

//   const [departments, setDepartments] = useState([]);
//   const backendUrl = 'http://your-backend-api-url.com/departments';

//   useEffect(() => {
//     // Fetch department data from the backend when the component mounts
//     fetch(backendUrl)
//       .then((response) => response.json())
//       .then((data) => setDepartments(data))
//       .catch((error) => console.error('Error fetching data:', error));
//   }, [backendUrl]);

//   const handleDelete = (id) => {
//     // Send a DELETE request to the backend to remove the department
//     fetch(`${backendUrl}/${id}`, {
//       method: 'DELETE',
//     })
//       .then((response) => {
//         if (response.ok) {
//           // If the deletion was successful, remove the department from the frontend state
//           setDepartments((prevDepartments) =>
//             prevDepartments.filter((dept) => dept.id !== id)
//           );
//         } else {
//           console.error('Error deleting department:', response.statusText);
//         }
//       })
//       .catch((error) => console.error('Error deleting department:', error));
//   };

//   const departmentCards = departments.map((department) => (
//     <div key={department.id} className="department-card">
//       <h2 className="department-title">{department.deptTitle}</h2>
//       <p className="department-body">{department.deptName}</p>
//       <button onClick={() => handleDelete(department.id)} className="delete-button">
//         Delete
//       </button>
//     </div>
//   ));

//   return (
//     <div className="department-list">
//       {departmentCards}
//     </div>
//   );
// }

// export default AllDepartment;