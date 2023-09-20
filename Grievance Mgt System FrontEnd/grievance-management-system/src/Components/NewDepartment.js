import React, { useState } from 'react';
import '../Components/style/NewDepartment.css';
import axios from 'axios';
import CustomAlert from './CommonComponents/CustomAlert';

function NewDepartment() {
  // const [departmentName, setDepartmentName] = useState('');
  const [showAlert, setShowAlert] = useState(false);
  const [message, setMessage] = useState("");
  const [formData, setFormData] = useState({"deptName":""});
  const addNewDeptUrl = "http://localhost:8080/api/dept/addDept";

  const [departmentNameError, setDepartmentNameError] = useState("");

  const handleShowAlert = () => {
    setShowAlert(true);
  };

  const handleCloseAlert = () => {
    setShowAlert(false);
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    if(formData.deptName === "") {
      setDepartmentNameError("required*");
    }else{
    try {
      
      const response = await axios.post(addNewDeptUrl, formData);
      console.log(response.data);
      setFormData({...formData, deptName:""});
      setDepartmentNameError("");
      setMessage(response.data)
      handleShowAlert();
      } catch (error) {
      console.error(error);
      }
    }
    console.log('Department Name:', formData);
    setFormData({...formData, deptName:""});
  };

  return (
    <div className='new-department-card'>
      <h1 className="new-department-title">Add a New Department</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Department Name: <p className="error">{departmentNameError}</p>{" "}
        </label>
          <input className="ND-input"
            type="text"
            value={formData.deptName}
            onChange={(e) => setFormData({...formData, deptName:e.target.value})}
            // required
          />
          {/* {departmentNameError && <p className="error">{departmentNameError}</p>} */}

          {
            showAlert &&
            <CustomAlert message={message} handleCloseAlert={handleCloseAlert} />
          }
        <button className='NDsubmit' type="submit">Add Department</button>
      </form>
    </div>
  );
}

export default NewDepartment;
