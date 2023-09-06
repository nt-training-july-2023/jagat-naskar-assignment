import React, { useState } from 'react';
import '../Components/style/DeleteUser.css';

function DeleteUser() {
  // Step 1: Create a list of user objects as local state
  const [users, setUsers] = useState([
    {
      id: 1,
      name: 'User 1',
      userName: 'user1@nucleusteq.com',
      userType: 'Admin',
      department: { deptName: 'Engineering' },
    },
    {
      id: 2,
      name: 'User 2',
      userName: 'user2@nucleusteq.com',
      userType: 'Regular',
      department: { deptName: 'Marketing' },
    },
    // Add more user objects as needed
  ]);

  // Step 2: Implement a function to handle user deletion
  const handleDelete = (id) => {
    // Step 3: Use the filter method to remove the deleted user
    const updatedUsers = users.filter((user) => user.id !== id);
    // Step 4: Update the component's state to reflect the changes
    setUsers(updatedUsers);
  };

  const userCards = users.map((user) => (
    <div key={user.id} className="user-card">
      <h2 className="user-title">{user.name}</h2>
      <div className="user-body">
        <p><strong>Username:</strong> {user.userName}</p>
        <p><strong>User Type:</strong> {user.userType}</p>
        <p><strong>Department:</strong> {user.department.deptName}</p>
        {/* Password is not displayed in the card */}
      </div>
      <button
        className="delete-button"
        onClick={() => handleDelete(user.id)}
      >
        Delete
      </button>
    </div>
  ));

  return (
    <div className="user-list">
      {userCards}
    </div>
  );
}

export default DeleteUser;




































// import React, { useState, useEffect } from 'react';
// import './ViewAllUsers.css';

// function DeleteUser() {
//   const [users, setUsers] = useState([]);

//   useEffect(() => {
//     fetch('http://your-backend-api-url.com/users')
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error('Network response was not ok');
//         }
//         return response.json();
//       })
//       .then((data) => setUsers(data))
//       .catch((error) => console.error('Error fetching data:', error));
//   }, []);

//   const handleDelete = (id) => {
//     // Step 3: Send a DELETE request to the backend API to delete the user
//     fetch(`http://your-backend-api-url.com/users/${id}`, {
//       method: 'DELETE',
//     })
//       .then((response) => {
//         if (response.ok) {
//           // Step 4: Update the frontend state to remove the deleted user
//           setUsers((prevUsers) => prevUsers.filter((user) => user.id !== id));
//         } else {
//           console.error('Error deleting user:', response.statusText);
//         }
//       })
//       .catch((error) => console.error('Error deleting user:', error));
//   };

//   const userCards = users.map((user) => (
//     <div key={user.id} className="user-card">
//       <h2 className="user-title">{user.name}</h2>
//       <div className="user-body">
//         <p><strong>Username:</strong> {user.userName}</p>
//         <p><strong>User Type:</strong> {user.userType}</p>
//         <p><strong>Department:</strong> {user.department.deptName}</p>
//         {/* Password is not displayed in the card */}
//       </div>
//       <button
//         className="delete-button"
//         onClick={() => handleDelete(user.id)}
//       >
//         Delete
//       </button>
//     </div>
//   ));

//   return (
//     <div className="user-list">
//       {userCards}
//     </div>
//   );
// }

// export default DeleteUser;