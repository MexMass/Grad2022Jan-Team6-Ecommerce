const express = require("express");
const pool = require("../dbconnection");
const router = express.Router();

router.post("/addDiscount", newDiscount); // endpoint - http://localhost:3000/discounts/addDiscount
router.delete("/deleteDiscount/:id", deleteDiscount); // endpoint - http://localhost:3000/discounts/deleteDiscount/id

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
  
      console.log('Data inserted into discounts table');
      res.json({response: "Discount created."}); // if successfull then send response
    });
  }
  
  function deleteDiscount(req, res) {
    const id = parseInt(req.params.id); // get id from parameters
  
    let myquery = // query for insert
    `
    DELETE FROM discounts
    WHERE id = ${id};
    `;
  
    pool.query(myquery, (error, response) => {
      
      if (error) {
          console.error(error);
          res.json({response: error.message}); // if error then send response
          return;
      }
  
      console.log('Data deleted from discounts table');
      res.json({response: "Discount deleted."}); // if successfull then send response
    });
  }

  module.exports = router;