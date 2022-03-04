const express = require("express");
const pool = require("../dbconnection");
const router = express.Router();

router.post("/create", newProduct); // endpoint - http://localhost:3000/products/create
router.put("/discontinue/:id", discontinueProduct); // endpoint - http://localhost:3000/products/discontinue/id

function newProduct(req, res) {
  const { name, supplier_name, units_in_stock, total_price, image_url, tags} = req.body; // get details from req.body
  let productsquery = // query for insert
  `
  INSERT INTO products(name, supplier_name, units_in_stock, total_price, discontinued, image_url)
  VALUES ('${name}', '${supplier_name}', ${units_in_stock}, ${total_price}, false, '${image_url}') RETURNING id;
  `;

  pool.query(productsquery, (error, result) => { // run query for products table
    
    if (error) {
        console.error(error);
        res.json({response: error.message}); // if error then send response
        return;
    }else {
      let createdProductId = result.rows[0].id; // get id of newly created product 
      for (let i = 0; i < tags.length; i++) { // for loop iterates through the tags array

        let product_tagsquery = // query for insert into product_tags table
        `
        INSERT INTO product_tags(product_id, tag_id)
        VALUES ('${createdProductId}', '${tags[i]}');
        `;

        pool.query(product_tagsquery, (error, result) => { // run query for product_tags table
            
            if (error) {
                console.error(error);
                res.json({response: error.message}); // if error then send response
                return;
            } else {
              console.log('Data inserted into product_tags table');
            }
          });

      }
      console.log('Data inserted into products table');
      res.json({response: "Product with name '" + name + "' created."});
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
