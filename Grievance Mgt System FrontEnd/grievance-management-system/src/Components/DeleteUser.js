import React, { useState, useEffect } from "react";
import "../Components/style/DeleteUser.css";

function DeleteUser() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/users/allUsers")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => setUsers(data))
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const handleDelete = (id) => {
    // Step 3: Send a DELETE request to the backend API to delete the user

    fetch(`http://localhost:8080/api/users/deleteUser/${id}`, {
      method: "DELETE",
    })
      .then((response) => {
        if (response.ok) {
          // Step 4: Update the frontend state to remove the deleted user
          setUsers((prevUsers) => prevUsers.filter((user) => user.id !== id));
        } else {
          console.error("Error deleting user:", response.statusText);
        }
      })
      .catch((error) => console.error("Error deleting user:", error));
  };

  const userCards = users.map((user) => (
    <div key={user.id} className="user-card">
      <h2 className="user-title">{user.name}</h2>
      {/* <h2 className="user-title">{user.}</h2> */}
      <div className="user-body">
        <p>
          <strong>UserId:</strong> {user.id}
        </p>
        <p>
          <strong>Username:</strong> {user.userName}
        </p>
        <p>
          <strong>User Type:</strong> {user.userType}
        </p>
        <p>
          <strong>Department:</strong> {user.departmentName}
        </p>
      </div>
      <button className="delete-button" onClick={() => handleDelete(user.id)}>
        Delete
      </button>
    </div>
  ));

  return (
    <div className="DUmain-div">
      {" "}
      <div className="user-list">{userCards}</div>
    </div>
  );
}

export default DeleteUser;
