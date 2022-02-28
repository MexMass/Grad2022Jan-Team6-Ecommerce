const express = require("express");
const pool = require("../dbconnection");
const router = express.Router();

router.post("/create", newProduct); // endpoint - http://localhost:3000/products/create
router.put("/discontinue/:id", discontinueProduct); // endpoint - http://localhost:3000/products/discontinue/id

function newProduct(req, res) {
  const { name, supplier_name, units_in_stock, total_price, discontinued, image_url } = req.body; // get details from req.body

  let myquery = // query for insert
  `
  INSERT INTO products(name, supplier_name, units_in_stock, total_price, discontinued, image_url)
  VALUES ('${name}', '${supplier_name}', ${units_in_stock}, ${total_price}, ${discontinued}, '${image_url}');
  `;

  pool.query(myquery, (error, result) => { // run query
    
    if (error) {
        console.error(error);
        res.json({response: error.message}); // if error then send response
        return;
    }else {
      console.log('Data inserted into products table');
      res.json({response: "Product " + name + " created."});
    }
  });
}

function discontinueProduct(req, res) {
  const id = parseInt(req.params.id); // get id from parameters

  let myquery = // query for insert
  `
  UPDATE products
  SET discontinued = true 
  WHERE id = ${id};
  `;

  pool.query(myquery, (error, result) => {
    
    if (error) {
        console.error(error);
        res.json({response: error.message}); // if error then send response
        return;
    } else {
      console.log('Data changed in products table');
      res.json({response: "Product with id " + id + " discontinued."})
    }
  });
}

module.exports = router;
