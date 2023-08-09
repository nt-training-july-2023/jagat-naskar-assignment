
import { Button, Row } from "react-bootstrap"; 
import React from "react";

function Footer(props) {
  return (
      <div className="row fixed-bottom">
        <Button className="btn btn-danger col-4" onClick={props.resetBtn}>reset</Button>
        <div className="col-6 bg-dark text-white text-center">{props.totalAmount}</div>
        <Button className="btn btn-warning col-4">Pay and empty your pocket</Button>
      </div>
  );
}

export default Footer;
