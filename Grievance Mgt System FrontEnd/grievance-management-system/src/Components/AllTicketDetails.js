import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../Components/style/AllTicketDetails.css";
import FullTicketModel from "./FullTicketModel";

const AllTicketDetails = () => {
  const [showFullDetails, setShowFullDetails] = useState(false);
  const [selectedTicket, setSelectedTicket] = useState(null);
  const navigate = useNavigate();

  const ticketList = [
    {
      ticketId: 1,
      creationTime: "2023-09-12T10:30:00",
      updationTime: "2023-09-12T11:45:00",
      ticketDesc: "Sample Description",
      ticketStatus: "Open",
      ticketTitle: "Sample Ticket",
      ticketType: "Bug",
      createBy: "Jagat Naskar",
      commitList: ["Commit 1", "Commit 2"],
      departmentName: "Development",
    },
    {
      ticketId: 2,
      creationTime: "2023-09-12T10:30:00",
      updationTime: "2023-09-12T11:45:00",
      ticketDesc: "Sample Description",
      ticketStatus: "Open",
      ticketTitle: "Sample Ticket",
      ticketType: "Bug",
      createBy: "Jagat Naskar",
      commitList: ["Commit 1", "Commit 2"],
      departmentName: "Development",
    },
    {
      ticketId: 3,
      creationTime: "2023-09-12T10:30:00",
      updationTime: "2023-09-12T11:45:00",
      ticketDesc: "Sample Description",
      ticketStatus: "Open",
      ticketTitle: "Sample Ticket",
      ticketType: "Bug",
      createBy: "Jagat Naskar",
      commitList: ["Commit 1", "Commit 2"],
      departmentName: "Development",
    },
  ];

  const ticketTO =  {
    ticketId: 3,
    creationTime: "2023-09-12T10:30:00",
    updationTime: "2023-09-12T11:45:00",
    ticketDesc: "Sample Description",
    ticketStatus: "Open",
    ticketTitle: "Sample Ticket",
    ticketType: "Bug",
    createBy: "Jagat Naskar",
    commitList: ["Commit 1", "Commit 2"],
    departmentName: "Development",
  }

  const openModal = (ticket) => {
    setSelectedTicket(ticket);
    setShowFullDetails(true);
  };

  const closeModal = () => {
    setShowFullDetails(false);
  };

  const handleEdit = (ticketId) => {
    // Redirect to UpdateTicket component with ticketId
    navigate(`/update-ticket/${ticketId}`);
  };



  return (
    <div>
         {/* <FullTicketModel ticket={ticketTO} onClose={closeModal} /> */}
      <table>
        <thead>
          <tr>
            <th>Ticket ID</th>
            <th>Ticket Title</th>
            <th>Ticket Status</th>
            <th>Created By</th>
            <th>Commit List</th>
            <th>Action</th>
            <th>Expand</th>
          </tr>
        </thead>
        <tbody>
          {ticketList.map((ticket) => (
            <tr key={ticket.ticketId}>
              <td>{ticket.ticketId}</td>
              <td>{ticket.ticketTitle}</td>
              <td>{ticket.ticketStatus}</td>
              <td>{ticket.createBy}</td>
              <td>{ticket.commitList.join(", ")}</td>
              <td>
                <button onClick={() => handleEdit(ticket.ticketId)}>
                  Edit
                </button>
              </td>
              <td>
                <button onClick={() => openModal(ticket)}>
                  View Details
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {showFullDetails  && 
        <FullTicketModel ticket={selectedTicket} onClose={closeModal} />
      }
      
    </div>
  );
};

export default AllTicketDetails;
