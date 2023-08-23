import React from 'react';
import { Link } from 'react-router-dom';

function HomePage() {
  return (
    <div>
      <h1>Welcome to Greviance/Feedback Management System</h1>
      <p>This is the home page of the feedback management system.</p>
      <Link to="/feedback">Go to Feedback</Link>
    </div>
  );
}
export default HomePage;