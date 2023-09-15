import React from "react";
import "../Components/style/FullTicketModel.css";

const FullTicketModel = ({ ticket, onClose }) => {
  return (
    <div className="ticket-modal">
      <div className="modal-content">
        <h3>Full Ticket Details</h3>
        <table>
          <tbody>
            <tr>
              <td>Ticket ID</td>
              <td>{ticket.ticketId}</td>
            </tr>
            <tr>
              <td>Title</td>
              <td>{ticket.ticketTitle}</td>
            </tr>
            <tr>
              <td>Creation Time</td>
              <td>{ticket.creationTime}</td>
            </tr>
            <tr>
              <td>Updation Time</td>
              <td>{ticket.updationTime}</td>
            </tr>
            <tr>
              <td>Ticket Description</td>
              <td>{ticket.ticketDesc}</td>
            </tr>
            <tr>
              <td>Ticket Status</td>
              <td>{ticket.ticketStatus}</td>
            </tr>
            <tr>
              <td>Ticket Type</td>
              <td>{ticket.ticketType}</td>
            </tr>
            <tr>
              <td>Created by</td>
              <td>{ticket.createBy}</td>
            </tr>
            <tr>
              <td>Department Name</td>
              <td>{ticket.createBy}</td>
            </tr>
            <tr>
              <td>{ticket.commitList.join(", ")}</td>
            </tr>
          </tbody>
        </table>
        <button className="close-button" onClick={onClose}>
          Close
        </button>
      </div>
    </div>
  );
};

export default FullTicketModel;
