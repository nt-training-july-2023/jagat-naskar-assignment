import React, { useState, useEffect } from "react";
import "../Components/style/UpdateTicket.css";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

const handleSubmit = () => {
  console.log("OK");
};

function UpdateTicket() {
  const [ticketType, setTicketType] = useState("");
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [assignTo, setAssignTo] = useState("");
  const [status, setStatus] = useState("select");
  const [comment, setComment] = useState("select");

  const [ticketTypeError, setTicketTypeError] = useState("");
  const [titleError, setTitleError] = useState("");
  const [descriptionError, setDescriptionError] = useState("");
  const [assignToError, setAssignToError] = useState("");
  const [statusError, setStatusError] = useState("");
  const [senderEmail, setSenderEmail] = useState("");

  const [departmentList, setDepartmentList] = useState([
    { deptId: "", deptName: "" },
  ]);
  const ticketTypeList = ["Select Ticket Type", "Feedback", "Grievance"];
  const statusList = ["Select Status", "Open", "Being Addressed", "Resolved"];
  //reset all the fields
  const resetAllFields = () => {
    setTicketType("");
    setTitle("");
    setDescription("");
    setAssignTo("Select Detartment");
    setStatus("Select status");
  };
  //onclosing, navigating to previous page
  const navigate = useNavigate();
  const nevigatePreviousPage = () =>{
    navigate(-1);
  }
  //reset all error
  const resetFormError = () => {
    setTicketTypeError("");
    setTitleError("");
    setDescriptionError("");
    setStatusError("");
  };

  //setting deptList from backend
  useEffect(() => {
    fetch("http://localhost:8080/api/dept/allDepartment")
      .then((response) => response.json())
      .then((data) => setDepartmentList((previous) => [...previous, ...data]))
      .catch((error) => console.error("Error:", error));
  }, []);

  //handle submit form
  const handleSubmit = (e) => {
    e.preventDefault();
    let isValid = true;

    if (!ticketType || ticketType === "Select Ticket Type") {
      setTicketTypeError("Please enter a ticket type.");
      isValid = false;
    } else {
      setTicketTypeError("");
    }

    if (!title) {
      setTitleError("Please enter a title.");
      isValid = false;
    } else {
      setTitleError("");
    }

    if (!description) {
      setDescriptionError("Please enter a description.");
      isValid = false;
    } else {
      setDescriptionError("");
    }

    if (!assignTo || assignTo === "Select Department" || assignTo === "") {
      setAssignToError("Select your department");
      isValid = false;
    }

    if (!status || status === "Select Status" || assignTo === "") {
      setStatusError("Select Status");
      isValid = false;
    }

    if (isValid) {
      console.log(
        "Ticket Data = " + ticketType,
        title,
        description,
        assignTo,
        status
      );
      // Proceed with submitting the form
      // Your logic here
      //Integrat
      axios
        .post("http://localhost:8080/api/tickets/addTicket", {
          ticketTitle: title,
          ticketType: ticketType,
          ticketStatus: status,
          ticketDescription: description,
          deptName: assignTo,
          ticketStatus: status,
          // senderEmail: btoa(sessionStorage.getItem("session_user_name")) -->later change it
          senderEmail: btoa("jme@nucleusteq.com"),
        })
        .then((res) => {
          console.log(res.data);
          resetFormError();
          resetAllFields();
        });
    }
  };

  return (
    <div className="tickets-container">
      <form className="ticket-form" onSubmit={handleSubmit}>
        <h2>Update Ticket Details</h2>
        <label className="ticketType">Ticket Type</label>

        <select
          id="ticketType"
          name="ticketType"
          value={ticketType}
          onChange={(e) => setTicketType(e.target.value)}
        >
          {ticketTypeList.map((e) => (
            <option value={e}>{e}</option>
          ))}
        </select>

        {ticketTypeError && <p className="error">{ticketTypeError}</p>}

        <label className="title">Title</label>
        <input
          type="text"
          id="title"
          name="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        {titleError && <p className="error">{titleError}</p>}

        <label className="description">Description</label>
        <textarea
          id="description"
          name="description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        ></textarea>
        {descriptionError && <p className="error">{descriptionError}</p>}

        <label className="assignTo">Assign To</label>
        <select
          id="assignTo"
          name="assignTo"
          value={assignTo}
          onChange={(e) => setAssignTo(e.target.value)}
        >
          <option value="" disabled>
            Select a Department
          </option>
          {departmentList.map((e) => (
            <option key={e.id} value={e.deptName}>
              {e.deptName}
            </option>
          ))}
        </select>
        {assignToError && <p className="error">{assignToError}</p>}

        <label className="status">Status</label>
        <select
          id="status"
          name="status"
          value={status}
          onChange={(e) => setStatus(e.target.value)}
        >
          {statusList.map((e) => (
            <option value={e}>{e}</option>
          ))}
        </select>
        {statusError && <p className="error">{statusError}</p>}

        <label className="comment">Comment</label>
        <select
          id="comment"
          name="comment"
          value={comment}
          disabled
          onChange={(e) => setComment(e.target.value)}
        ></select>
        <button type="submit">Submit</button>
        {/* <Link to="/"> */}
          <button className="nevigate-back" onClick={nevigatePreviousPage}>Close</button>
        {/* </Link> */}
        {/* need to update the link, later, Your UpdateTicket component */}
      </form>
    </div>
  );
}

export default UpdateTicket;

// theese should be visibe in the ticket

// Title
// Ticket Type
// Department
// Description
// Comments (Can be a tabular representation)
// Status
// Assigned By
// Creation time
// Last updated time
