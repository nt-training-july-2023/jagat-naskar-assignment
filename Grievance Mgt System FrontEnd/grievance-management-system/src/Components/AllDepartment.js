import React, { useState } from 'react';
import '../Components/style/AllDepartment.css';

function AllDepartment() {
  const [departments, setDepartments] = useState([
    { id: 1, deptTitle: 'Department 1', deptName: 'Engineering' },
    { id: 2, deptTitle: 'Department 2', deptName: 'Marketing' },
    { id: 3, deptTitle: 'Department 3', deptName: 'Finance' },
    { id: 4, deptTitle: 'Department 4', deptName: 'HR' },
    { id: 5, deptTitle: 'Department 5', deptName: 'Sales' },
    { id: 6, deptTitle: 'Department 6', deptName: 'IT' },
  ]);


  const departmentCards = departments.map((department) => (
    <div key={department.id} className="department-card">
      <h2 className="department-title">{department.deptTitle}</h2>
      <p className="department-body">{department.deptName}</p>
    </div>
  ));

  return (
    <div className="department-list">
      {departmentCards}
    </div>
  );
}

export default AllDepartment;































// import React, { useState, useEffect } from 'react';
// import '../Components/style/AllDepartment.css';

// function AllDepartment() {
//   const [departments, setDepartments] = useState([]);

//   useEffect(() => {
//     // Fetch department data from the backend API when the component mounts
//     fetch('http://your-backend-api-url.com/departments') // Replace with your actual backend API URL
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error('Network response was not ok');
//         }
//         return response.json();
//       })
//       .then((data) => setDepartments(data))
//       .catch((error) => console.error('Error fetching data:', error));
//   }, []);

//   const departmentCards = departments.map((department) => (
//     <div key={department.id} className="department-card">
//       <h2 className="department-title">{department.deptTitle}</h2>
//       <p className="department-body">{department.deptName}</p>
//     </div>
//   ));

//   return (
//     <div className="department-list">
//       {departmentCards}
//     </div>
//   );
// }

// export default AllDepartment;