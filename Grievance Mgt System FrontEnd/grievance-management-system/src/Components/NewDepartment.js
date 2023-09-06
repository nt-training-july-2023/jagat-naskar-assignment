import React, { useState } from 'react';
import '../Components/style/NewDepartment.css';
import axios from 'axios';

function NewDepartment() {
  // const [departmentName, setDepartmentName] = useState('');
  const [formData, setFormData] = useState({"deptName":""});
  const addNewDeptUrl = "http://localhost:8080/api/dept/addDept";

  const [departmentNameError, setDepartmentNameError] = useState("");
  const inputChange=()=>{
   // setFormData({...formData, deptName:departmentName});
  }
  const handleSubmit = async (e) => {
    e.preventDefault();
    if(!formData.deptName) {
      setDepartmentNameError("Enter new Department");
    }
    try {
      
      const response = await axios.post(addNewDeptUrl, formData);
      console.log(response.data);
      // Handle success, show a success message, or redirect the user
      } catch (error) {
      console.error(error);
      // Handle errors
      }
    // You can perform any action here with the departmentName, such as sending it to a server.
    console.log('Department Name:', formData);
    setFormData('');
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
            value={formData.deptName}
            onChange={(e) => setFormData({...formData, deptName:e.target.value})}
            required
          />
          {departmentNameError && <p className="error">{departmentNameError}</p>}
        
        <button type="submit">Add Department</button>
      </form>
    </div>
  );
}

export default NewDepartment;
