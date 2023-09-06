import React from 'react';
import '../Components/style/AllUsers.css';

function AllUsers() {
  // Step 1: Create a list of user objects
  const users = [
    {
      id: 1,
      name: 'User 1',
      userName: 'user1',
      password: 'password1',
      userType: 'Admin',
      department: { deptName: 'Engineering' },
    },
    {
      id: 2,
      name: 'User 2',
      userName: 'user2',
      password: 'password2',
      userType: 'Regular',
      department: { deptName: 'Marketing' },
    },
    // Add more user objects as needed
  ];

  // Step 2: Map over the user list to render each user's information in cards
  const userCards = users.map((user) => (
    <div key={user.id} className="user-card">
      <h2 className="user-title">{user.name}</h2>
      <div className="user-body">
        <p><strong>Username:</strong> {user.userName}</p>
        <p><strong>User Type:</strong> {user.userType}</p>
        <p><strong>Department:</strong> {user.department.deptName}</p>
        {/* Password is not displayed in the card */}
      </div>
    </div>
  ));

  return (
    <div className="user-list">
      {userCards}
    </div>
  );
}

export default AllUsers;











// import React from 'react';
// import '../Components/style/AllUsers.css';

// function AllUsers() {

// // Step 1: Initialize the state for user data
// const [users, setUsers] = useState([]);

// useEffect(() => {
//   // Step 2: Fetch user data from the backend API when the component mounts
//   fetch('http://your-backend-api-url.com/users') // Replace with your actual backend API URL
//     .then((response) => {
//       if (!response.ok) {
//         throw new Error('Network response was not ok');
//       }
//       return response.json();
//     })
//     .then((data) => setUsers(data))
//     .catch((error) => console.error('Error fetching data:', error));
// }, []);

// // Step 3: Map over the user data to render each user's information in cards
// const userCards = users.map((user) => (
//   <div key={user.id} className="user-card">
//     <h2 className="user-title">{user.name}</h2>
//     <div className="user-body">
//       <p><strong>Username:</strong> {user.userName}</p>
//       <p><strong>User Type:</strong> {user.userType}</p>
//       <p><strong>Department:</strong> {user.department.deptName}</p>
//       {/* Password is not displayed in the card */}
//     </div>
//   </div>
// ));

// return (
//   <div className="user-list">
//     {userCards}
//   </div>
// );
// }

// export default AllUsers;