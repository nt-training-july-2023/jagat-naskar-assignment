import React from "react";

function Product(props) {
  return (
    <div>
      <p>------------------Product----------------------</p>
      <div className="row">
        <div className="col-5">
          <h2>{props.product.name}</h2>
          <h3>
            <span className="badge bg-secondary">₹{props.product.price}</span>
          </h3>
          <div className="col-3">
            <div
              className="btn-group"
              role="group"
              aria-label="Basic mixed styles example"
            >
              <button
                type="button"
                className="btn btn-danger"
                onClick={() => {
                  props.DecrementQuantity(props.index);
                }}
              >
                -
              </button>
              <button type="button" className="btn btn-warning">
                {props.product.quantity}
              </button>
              <button
                type="button"
                className="btn btn-success"
                onClick={() => {
                  props.IncrementQuantity(props.index);
                }}
              >
                +
              </button>
            </div>
          </div>
        </div>
        <p>
          __________________________________________________________________
        </p>
        <div className="col-4">
          {props.product.quantity * props.product.price}
        </div>
        <p>
          __________________________________________________________________
        </p>
      </div>
    </div>
  );
}

export default Product;

{
  /* 
import React from "react";

export default function Product(props) {
  return (
    <div>
      <p>------------------Product----------------------</p>
      <div className="row">
        <div className="col-5">
          <h2>{props.product.name}</h2>
          <h3>
            <span className="badge bg-secondary">₹{props.product.price}</span>
          </h3>
          <div className="col-3">
            <div
              class="btn-group"
              role="group"
              aria-label="Basic mixed styles example"
            >
              <button type="button" className="btn btn-danger">
                -
              </button>
              <button type="button" className="btn btn-warning">
                {props.product.quantity}
              </button>
              <button
                type="button"
                className="btn btn-success"
                onClick={() => {
                  props.IncrementQuantity(props.index);
                }}
              >
                +
              </button>
            </div>
          </div>
        </div>
        <p>
          __________________________________________________________________
        </p>
        <div className="col-4">
          {props.product.quantity * props.product.price}
        </div>
        <p>
          __________________________________________________________________
        </p>
      </div>
    </div>
  );
}
*/
}
