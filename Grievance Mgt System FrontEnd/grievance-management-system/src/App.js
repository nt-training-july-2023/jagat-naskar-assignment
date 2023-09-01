import './App.css';
import Login from './Components/CommonComponents/Login';
import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom';
import AdminHome from './Components/AdminHome';
import NewUser from './Components/CommonComponents/NewUser';
import Ticket from './Components/Ticket';
import AdminSidebar from './Components/AdminSidebar';

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
    <Route path='/' element={<Login/>}/>
    <Route path='/adminHome' element={<AdminSidebar/>}/>
    </Route>
  )
)
function App() {
  return (
    <div className="App">
      {/* <RouterProvider router={routtee} /> */}
      {/* <Practise/> */}
      {/* <Ticket/> */}
      <NewUser/>
      {/* <AdminSidebar/> */}
      {/* <Login/> */}
    </div>
  );
}

export default App;



