const express = require("express");
const pool = require("../dbconnection");
const router = express.Router();

router.post("/addOrder", createOrder); // endpoint - http://localhost:3000/orders/addOrder

function createOrder(req, res) { // inserts data in orders & order_details table. Updates products units_in_stock based on quantity of product ordered
    const { user_id, products} = req.body; // get details from req.body

    const currentDate = new Date().toISOString().slice(0, 10) // get current date
  
    let ordersquery = // query for insert
    `
    INSERT INTO orders(user_id, order_date)
    VALUES ('${user_id}', '${currentDate}') RETURNING id;
    `;
  
    pool.query(ordersquery, (error, result) => { // run query
      
      if (error) {
          console.error(error);
          res.json({response: error.message}); // if error then send response
          return;
      } else {
        let createdOrderId = result.rows[0].id; // get id of newly created order 

        for (let i = 0; i < products.length; i++) { // for loop for 

            let order_detailsquery = // query for insert
            `
            INSERT INTO order_details(order_id, product_id, quantity)
            VALUES ('${createdOrderId}', '${products[i].id}', '${products[i].quantity}');
            `;

            pool.query(order_detailsquery, (error, result) => { // run query
                
                let updateproductsquery = // query for reducing the units_in_stock value in the products table
                `
                UPDATE products
                SET units_in_stock = units_in_stock - ${products[i].quantity}
                WHERE id = ${products[i].id};
                `;

                pool.query(updateproductsquery, (error, result) => { // run query

                    if (error) {
                        console.error(error);
                        res.json({response: error.message}); // if error then send response
                        return;
                    } else {
                      console.log('Data modified in products table');
                    }
                  });

                if (error) {
                    console.error(error);
                    res.json({response: error.message}); // if error then send response
                    return;
                } else {
                  console.log('Data inserted into order_details table');
                }
              });
          }

        console.log('Data inserted into orders table');
        res.json({response: "Order created with id = " + createdOrderId});
      }
    });
}

module.exports = router;