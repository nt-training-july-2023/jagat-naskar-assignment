import React from 'react';
import { Navigate, Outlet, Route, Routes } from 'react-router-dom';
import { isLoggedIn, setLoggedIn } from '..';

const PrivateRoute = () => {
const isLoggedInn = sessionStorage.getItem("isLoggedIn") ;

if(isLoggedInn == "true"){
    return <Outlet/>
}else{
    return <Navigate to = {"/"}/>
}
//    return (<>
//    <p> Private Proute Page</p>
//    <Routes>
//         <Route
//         element={isLoggedIn ? <Outlet /> : <Navigate to="/" />}
//         /> 
//         </Routes>
//         {console.log(isLoggedIn)}
//     </>
//    );
};

export default PrivateRoute;