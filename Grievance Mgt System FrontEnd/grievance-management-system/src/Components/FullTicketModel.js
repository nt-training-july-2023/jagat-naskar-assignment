import React from "react";
import "../Components/style/FullTicketModel.css";

const FullTicketModel = (props) => {
  return (
    <div className="ticket-modal">
      <div className="modal-content">
        <h3>Full Ticket Details</h3>
        <table>
          <tbody>
            <tr>
              <td>Ticket ID</td>
              <td>{props.ticket.ticketId}</td>
            </tr>
            <tr>
              <td>Title</td>
              <td>{props.ticket.title}</td>
            </tr>
            <tr>
              <td>Creation Time</td>
              <td>{props.ticket.creationTime}</td>
            </tr>
            <tr>
              <td>Updation Time</td>
              <td>{props.ticket.updationTime}</td>
            </tr>
            <tr>
              <td>Ticket Status</td>
              <td>{props.ticket.ticketStatus}</td>
            </tr>
            <tr>
              <td>Ticket Type</td>
              <td>{props.ticket.ticketType}</td>
            </tr>
            <tr>
              <td>Created by</td>
              <td>{props.ticket.createdBy}</td>
            </tr>
            <tr>
              <td>Department Name</td>
              <td>{props.ticket.departmentName}</td>
            </tr>
          </tbody>
        </table>
        <button className="close-button" onClick={props.onClose}>
          Close
        </button>
      </div>
    </div>
  );
};

export default FullTicketModel;
