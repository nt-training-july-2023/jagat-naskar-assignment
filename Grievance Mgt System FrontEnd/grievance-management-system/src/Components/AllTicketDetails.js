import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "../Components/style/AllTicketDetails.css";
import FullTicketModel from "./FullTicketModel";
import axios from "axios";
import UpdateTicket from "./UpdateTicket";

const AllTicketDetails = () => {
  const statusList = ["Open", "Being_Addressed", "Resolved"];
  const [showFullDetails, setShowFullDetails] = useState(false);
  const [showEditTicket, setShowEditTicket] = useState(false);
  const [selectedTicket, setSelectedTicket] = useState(null);
  // const [deptFilter, setDeptFilter] = useState("");
  const [totalItem, setTotalItem] = useState(0);
  const [editButtonsDisabled, setEditButtonsDisabled] = useState(false); //-->

  const [ticketList, setTicketList] = useState([]); // list of ticket
  const navigate = useNavigate();
  const [selectedStatus, setSelectedStatus] = useState("");
  const [deptWise, setDeptWise] = useState("true");
  const [OwnWise, setOwnWise] = useState("false");

  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage] = useState(3); // Number of items per page

  const handleNextPage = () => {
    setCurrentPage(currentPage + 1);
  };

  const handlePreviousPage = () => {
    if (currentPage > 0) {
      setCurrentPage(currentPage - 1);
    }
  };

  const fetchData = async () => {
    try {
      const dataToSend = {
        email: btoa(sessionStorage.getItem("session_user_name")),
        departmentBased: deptWise,
        assignByOwn: OwnWise,
        filterStatus: selectedStatus,
        pageNumber: currentPage,
      };

      console.log(dataToSend);
      const response = await axios.post(
        "http://localhost:8080/api/tickets/getAllTicket",
        dataToSend
      );

      if (response.status !== 200) {
        throw new Error("Network response was not ok");
      }

      const data = response.data;
      setTicketList(data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const openEditModel = (ticket) => {
    setSelectedTicket(ticket);
    setShowEditTicket(true);
  };
  const openModal = (ticket) => {
    setSelectedTicket(ticket);
    setShowFullDetails(true);
  };

  const closeModal = () => {
    setShowFullDetails(false);
  };
  const closeEditModel = () => {
    setShowEditTicket(false);
  };

  const handleEdit = (ticket) => {
    setSelectedTicket(ticket);
    openEditModel(ticket);
  };

  useEffect(() => {
    fetchData();
  }, [OwnWise, deptWise, selectedStatus, currentPage]);

  const handleFilterChange = (e) => {
    setCurrentPage(0);
    setSelectedStatus(e.target.value);
  };

  return (
    <div className="full-details">
      <div className="all-button">
        <button
          className="allTickets"
          onClick={() => {
            setCurrentPage(0);
            setOwnWise("false");
            setDeptWise("false");
            setSelectedStatus("Select status");
            setEditButtonsDisabled(true);
          }}
        >
          All Tickets
        </button>
        <button
          className="deptTickets"
          onClick={() => {
            setCurrentPage(0);
            setDeptWise("true");
            setOwnWise("false");
            setSelectedStatus("Select status");
            setEditButtonsDisabled(false);
          }}
        >
          Dept Based
        </button>

        <button
          className="myTickets"
          onClick={() => {
            setCurrentPage(0);
            setDeptWise("false");
            setOwnWise("true");
            setSelectedStatus("Select status");
            setEditButtonsDisabled(false);
          }}
        >
          My Tickets
        </button>

        <select
          id="statusFilter"
          className="statusFilter"
          name="filter"
          value={selectedStatus}
          onChange={handleFilterChange}
        >
          <option value="">Select status</option>
          {statusList.map((e) => (
            <option key={e} value={e}>
              {e}
            </option>
          ))}
        </select>
      </div>
      <table>
        <thead>
          <tr>
            {/* <th>Ticket ID</th> */}
            <th>Department</th>
            <th>Ticket Status</th>
            <th>Created By</th>
            <th>Last Updated</th>
            <th>Action</th>
            <th>Expand</th>
          </tr>
        </thead>
        <tbody>
          {ticketList.map((ticket) => (
            <tr key={ticket.ticketId}>
              <td>{ticket.departmentName}</td>
              <td>{ticket.ticketStatus}</td>
              <td>{ticket.createdBy}</td>
              <td>{ticket.updationTime}</td>

              <td>
                <button className="edit-btn" onClick={() => handleEdit(ticket)}>
                  Edit
                </button>
              </td>
              <td>
                <button
                  className="expand-btn"
                  onClick={() => openModal(ticket)}
                >
                  View Details
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <div>
        <button onClick={handlePreviousPage} disabled={currentPage === 0}>
          Previous
        </button>
        {currentPage + 1}
        <button
          onClick={handleNextPage}
          disabled={currentPage > ticketList.length / 5}
        >
          Next
        </button>
      </div>

      {showEditTicket && (
        <UpdateTicket
          id={selectedTicket.ticketId}
          onClose={closeEditModel}
          editButtonsDisabled={editButtonsDisabled} //passing it to child
        />
      )}

      {showFullDetails && (
        <FullTicketModel ticket={selectedTicket} onClose={closeModal} />
      )}
    </div>
  );
};

export default AllTicketDetails;

// import React, { useState, useEffect } from "react";
// import { useNavigate } from "react-router-dom";
// import "../Components/style/AllTicketDetails.css";
// import FullTicketModel from "./FullTicketModel";
// import axios from "axios";
// import UpdateTicket from "./UpdateTicket";

// const AllTicketDetails = () => {
//   const statusList = ["Select status", "Open", "Being_Addressed", "Resolved"];
//   const [showFullDetails, setShowFullDetails] = useState(false);
//   const [showEditTicket, setShowEditTicket] = useState(false);
//   const [selectedTicket, setSelectedTicket] = useState(null);
//   const [deptFilter, setDeptFilter] = useState("");
//   const [statusValue, setStatusValue] = useState("");

//   const [ticketList, setTicketList] = useState([]); // Initialize as an empty array
//   const navigate = useNavigate();

//   // const dataToSend = {
//   //   email: btoa(sessionStorage.getItem('session_user_name')), // Replace with your dummy email
//   //   departmentBased: "true",
//   //   assignByOwn: "false",
//   // };

//   const fetchData = async () => {
//     try {
//       const dataToSend = {
//         email: btoa(sessionStorage.getItem("session_user_name")),
//         departmentBased: "true",
//         assignByOwn: "false",
//       };

//       console.log(dataToSend);
//       const response = await axios.post(
//         "http://localhost:8080/api/tickets/getAllTicket",
//         dataToSend
//       );

//       if (response.status !== 200) {
//         throw new Error("Network response was not ok");
//       }

//       const data = response.data;
//       setTicketList(data);
//     } catch (error) {
//       console.error("Error fetching data:", error);
//     }
//   };
//   useEffect(() => {
//     fetchData();
//   }, []);

//   const handleAllTickets =async (deptWise, OwnWise) => {
//     try {
//       const dataToSend = {
//         email: btoa(sessionStorage.getItem("session_user_name")),
//         departmentBased: deptWise,
//         assignByOwn: OwnWise,
//       };

//       console.log(dataToSend);
//       const response = await axios.post(
//         "http://localhost:8080/api/tickets/getAllTicket",
//         dataToSend
//       );

//       if (response.status !== 200) {
//         throw new Error("Network response was not ok");
//       }

//       const data = response.data;
//       setTicketList(data);
//       console.log("Jagat1", data);
//       console.log("jagat2", ticketList);
//     } catch (error) {
//       console.error("Error fetching data:", error);
//     }
//   };

//   const openEditModel = (ticket) => {
//     setSelectedTicket(ticket);
//     setShowEditTicket(true);
//   };
//   const openModal = (ticket) => {
//     setSelectedTicket(ticket);
//     setShowFullDetails(true);
//   };

//   const closeModal = () => {
//     setShowFullDetails(false);
//   };
//   const closeEditModel = () => {
//     setShowEditTicket(false);
//   };

//   const handleEdit = (ticket) => {
//     setSelectedTicket(ticket);
//     openEditModel(ticket);

//     // Redirect to UpdateTicket component with ticketId
//     // navigate(`update-ticket`);
//   };
//   return (
//     <div>
//       <button className="allTickets" onClick={() => handleAllTickets("false", "false")}>All Tickets</button>
//       <button className="deptTickets" onClick={() => handleAllTickets("true", "false")}>Dept Based</button>
//       <button className="myTickets" onClick={() => handleAllTickets("false", "true")}>My Tickets</button>
//       <select
//           id="statusFilter"
//           className="statusFilter"
//           name="filter"
//           value={statusValue}
//           onChange={(e) => setStatusValue(e.target.value)}
//         >
//           <option value="" >
//             Select status
//           </option>
//           {statusList.map((e) => (
//             <option key={e} value={e}>
//               {e}
//             </option>
//           ))}
//         </select>

//       <table>
//         <thead>
//           <tr>
//             {/* <th>Ticket ID</th> */}
//             <th>Department</th>
//             <th>Ticket Status</th>
//             <th>Created By</th>
//             <th>Last Updated</th>
//             <th>Action</th>
//             <th>Expand</th>
//           </tr>
//         </thead>
//         <tbody>
//           {ticketList.map((ticket) => (
//             <tr key={ticket.ticketId}>
//               <td>{ticket.departmentName}</td>
//               <td>{ticket.ticketStatus}</td>
//               <td>{ticket.createdBy}</td>
//               <td>{ticket.updationTime}</td>

//               <td>
//                 <button onClick={() => handleEdit(ticket)}>
//                   Edit
//                 </button>
//               </td>
//               <td>
//                 <button onClick={() => openModal(ticket)}>View Details</button>
//               </td>
//             </tr>
//           ))}
//         </tbody>
//       </table>

//       {showEditTicket && (
//         <UpdateTicket id={selectedTicket.ticketId} onClose={closeEditModel} />
//       )}
//       {showFullDetails && (
//         <FullTicketModel ticket={selectedTicket} onClose={closeModal} />
//       )}
//     </div>
//   );
// };

// export default AllTicketDetails;
