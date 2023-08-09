import React, { Fragment } from "react";
import Product from "./Product";

// const ProductList = ({FlipList, IncrementQuantity}) => {
//   return (
//     <>
//       {
//         FlipList.map((product , index) => {
//           return(
//           <Fragment key={index}>
//             <Product product={product} IncrementQuantity={IncrementQuantity}/>
//            </Fragment>
//           )
//         })
//       }
//     </>
//   )
//   }

const ProductList = (props) => {
  return (
    <>
      {props.FlipList.map((product1, index) => {
        return (
          <Fragment key={index}>
            <Product
              product={product1}
              IncrementQuantity={props.IncrementQuantity}
              DecrementQuantity={props.DecrementQuantity}
              index={index}
            />
          </Fragment>
        );
      })}
    </>
  );
};

export default ProductList;
