import React, { useState } from 'react';
import '../Components/style/NewDepartment.css';

function NewDepartment() {
  const [departmentName, setDepartmentName] = useState('');

  const [departmentNameError, setDepartmentNameError] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if(!departmentName) {
      setDepartmentNameError("Enter your name");
    }
    // You can perform any action here with the departmentName, such as sending it to a server.
    console.log('Department Name:', departmentName);
    setDepartmentName('');
  };

  return (
    <div className='new-department-card'>
      <h1 className="new-department-title">Add a New Department</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Department Name:
        </label>
          <input
            type="text"
            value={departmentName}
            onChange={(e) => setDepartmentName(e.target.value)}
            required
          />
          {departmentNameError && <p className="error">{departmentNameError}</p>}
        
        <button type="submit">Add Department</button>
      </form>
    </div>
  );
}

export default NewDepartment;
