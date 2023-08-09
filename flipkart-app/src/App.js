import { useState } from "react";
import "./App.css";
import Footer from "./components/Footer";
import Navbar from "./components/Navbar";
import ProductList from "./components/ProductList";

function App() {
  const ProdList = [
    {
      price: 25,
      name: "choclate",
      quantity: 0,
    },
    {
      price: 20,
      name: "chips",
      quantity: 0,
    },
    {
      price: 50,
      name: "Cold Drinks",
      quantity: 0,
    },
  ];

  const [ListS, setListS] = useState(ProdList);
  const [Total, setTotal] = useState(0);

  const IncrementQuantity = (index) => {
    let newList = [...ListS];
    let newTotal = Total;
    newList[index].quantity++;
    newTotal += newList[index].price;
    setListS(newList);
    setTotal(newTotal);
  };

  const DecrementQuantity = (index) => {
    let newList = [...ListS];
    let newTotal = Total;
    if (newList[index].quantity > 0) {
      newList[index].quantity--;
      newTotal -= newList[index].price;
    }
    setListS(newList);
    setTotal(newTotal);
  };

  const resetBtn = () => {
    setListS(ProdList)
    setTotal(0)
  }
 


  return (
    <>
      <Navbar />
      <div className="container">
        <p>data</p>
        <ProductList
          FlipList={ListS}
          IncrementQuantity={IncrementQuantity}
          DecrementQuantity={DecrementQuantity}
        />
      </div>
      <Footer totalAmount={Total} resetBtn={resetBtn} />
    </>
  );
}

export default App;
