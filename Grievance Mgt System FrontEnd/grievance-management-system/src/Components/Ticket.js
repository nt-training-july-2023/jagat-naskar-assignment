import React, { useState } from "react";
import "../Components/style/Ticket.css";

const handleSubmit=()=>{
  console.log("OK");
};

function Ticket() {
  const [ticketType, setTicketType] = useState('');
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [assignTo, setAssignTo] = useState('Dept1');
  const [status, setStatus] = useState('option1');

  const [ticketTypeError, setTicketTypeError] = useState('');
  const [titleError, setTitleError] = useState('');
  const [descriptionError, setDescriptionError] = useState('');

  //reset all the fields
  const resetAllFields = () => {
    setTicketType('');
    setTitle('');
    setDescription('');
    setAssignTo('Dept1');
    setStatus('option1');
  };

  //reset all error
  const clearAllErrors = () => {
    setTicketTypeError('');
    setTitleError('');
    setDescriptionError('');
  };

  //handle submit form
  const handleSubmit = (e) => {
    e.preventDefault();

    let isValid = true;

    if (!ticketType) {
      setTicketTypeError('Please enter a ticket type.');
      isValid = false;
    } else {
      setTicketTypeError('');
    }

    if (!title) {
      setTitleError('Please enter a title.');
      isValid = false;
    } else {
      setTitleError('');
    }

    if (!description) {
      setDescriptionError('Please enter a description.');
      isValid = false;
    } else {
      setDescriptionError('');
    }

    if (isValid) {
      console.log("Ticket Data = "+ticketType, title, description, assignTo, status )
      // Proceed with submitting the form
      // Your logic here
      //Integration code
      
    }
  };

  return (
    <div className="tickets-container">
      <h2>Add Ticket</h2>
      <form className="ticket-form" onSubmit={handleSubmit}>
        <label className="ticketType">Ticket Type</label>
        <input
          type="text"
          id="ticketType"
          name="ticketType"
          value={ticketType}
          onChange={(e) => setTicketType(e.target.value)}
        />
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
          <option value="Dept1">Dept1</option>
          <option value="Dept2">Dept2</option>
        </select>

        <label className="status">Status</label>
        <select
          id="status"
          name="status"
          value={status}
          disabled
          onChange={(e) => setStatus(e.target.value)}
        >
          <option value="option1">Option 1</option>
          <option value="option2">Option 2</option>
          <option value="option3">Option 3</option>
        </select>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Ticket;