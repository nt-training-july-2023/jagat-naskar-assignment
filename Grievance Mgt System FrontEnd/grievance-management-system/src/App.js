import "./App.css";
import Login from "./Components/CommonComponents/Login";
import {
  Route,
  createBrowserRouter,
  createRoutesFromElements,
  RouterProvider,
  Routes,
  BrowserRouter,
} from "react-router-dom";
import AdminHome from "./Components/AdminHome";
import NewUser from "./Components/CommonComponents/NewUser";
import Ticket from "./Components/Ticket";
import AdminSidebar from "./Components/AdminSidebar";
import NewDepartment from "./Components/NewDepartment";
import MemberSidebar from "./Components/MemberSidebar";
import DeleteUser from "./Components/DeleteUser";
import AllDepartment from "./Components/AllDepartment";
import DeleteDepartment from "./Components/DeleteDepartment";
import AllUsers from "./Components/AllUsers";

const routtee = createBrowserRouter(
  createRoutesFromElements(
    // <Route path='/' element={<RootLayout/>}>
    //       <Route index element = {<Home/>}/>
    //       <Route path="home" element = {<Home/>}/>
    //       <Route path="about" element = {<About/>}/>
    //       <Route path="contact" element = {<Contact/>}>
    //             <Route path="help" element = {<Help/>}/>
    //             <Route path="call" element = {<Call/>}/>
    //       </Route>
    // </Route>
    <Route>
      <Route path="/" element={<Login />} />
      <Route path="/adminHome" element={<AdminSidebar />} />
    </Route>
  )
);
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/admin" element={<AdminSidebar />}>
          <Route path="adminHome" element={<AdminHome />}/>
          <Route path="addUser" element={<NewUser />} />
          <Route path="allUsers" element={<AllUsers />} />
          <Route path="deleteUser" element={<DeleteUser />} />
          <Route path="allUsers" element={<AllUsers />} />
          <Route path="deleteUser" element={<DeleteUser />} />
          <Route path="createDept" element={<NewDepartment />} />
          <Route path="viewDept" element={<AllDepartment />} />
          <Route path="deleteDept" element={<DeleteDepartment />} />
          <Route
            path="allFeedback"
            element={<div>All Feedback & Greviance Page</div>}
          />
        </Route>
        <Route path="/member" element={<MemberSidebar />}>
          <Route path="memberHome" element={<div>Member Home Page</div>} />
          <Route path="" element={<div></div>} />
          <Route path="" element={<div></div>} />
          <Route path="myTicket" element={<div>My Ticket Page</div>} />
          <Route path="myDeptTicket" element={<div>My Department Ticket Page</div>} />
          <Route path="" element={<div></div>}/>
          <Route path="createTicket" element={<div>Create Ticket Page</div>} />
          <Route path="" element={<div></div>} />
          <Route path="" element={<div></div>} />
        </Route>
      </Routes>

      {/* <RouterProvider router={routtee} /> */}
      {/* <Practise/> */}
      {/* <Ticket/> */}
      {/* <NewUser/> */}
      {/* <NewDepartment/> */}
      {/* <Login/> */}
      {/* <AdminSidebar/> */}
      {/* <MemberSidebar/> */}
    </div>
  );
}

export default App;
