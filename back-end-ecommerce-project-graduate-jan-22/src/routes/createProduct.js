const express = require("express");
const pool = require("../dbconnection");
const router = express.Router();

router.post("/create", newProduct); // endpoint - http://localhost:3000/db/create
router.post("/addDiscount", newDiscount); // endpoint - http://localhost:3000/db/addDiscount

function newProduct(req, res) {
  const { name, supplier_name, units_in_stock, total_price, discontinued, image_url } = req.body; // get details from req.body

  let myquery = // query for insert
  `
  INSERT INTO products(name, supplier_name, units_in_stock, total_price, discontinued, image_url)
  VALUES ('${name}', '${supplier_name}', ${units_in_stock}, ${total_price}, ${discontinued}, '${image_url}');
  `;

  pool.query(myquery, (error, response) => { // run query
    
    if (error) {
        console.error(error);
        res.json({response: error.message}); // if error then send response
        return;
    }

    console.log('Data insert successful');
    res.json({response: "Product " + name + " created."});
  });
}

function newDiscount(req, res) {
  const { product_id, percent } = req.body; // get details from req.body

  let myquery = // query for insert
  `
  INSERT INTO discounts(product_id, percent)
  VALUES ('${product_id}', '${percent}');
  `;

  pool.query(myquery, (error, response) => {
    
    if (error) {
        console.error(error);
        res.json({response: error.message}); // if error then send response
        return;
    }

    console.log('Data insert successful');
    res.json({response: "Discount created."}); // if successfull then send response
  });
}

module.exports = router;
