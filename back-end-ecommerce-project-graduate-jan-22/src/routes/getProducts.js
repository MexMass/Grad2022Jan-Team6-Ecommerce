const express = require("express");
const router = express.Router();
const pool = require("../dbconnection"); //import database connection

//default url - Returns array of all products
router.get("", getProducts);

//id url - Returns product by ID
router.get("/:id", getProductById);

//tag url - returns all products matching the tag
router.get("/tag/:tag", getProductByTag);

function getProducts(req, res) {
  pool.query(
    `SELECT *
    FROM products 
    WHERE discontinued = false`,
    (error, result) => {
      if (error) {
        return res.status(500).send(error);
      } else {
        return res.json(result.rows);
      }
    }
  );
}

function getProductById(req, res) {
  const id = parseInt(req.params.id);
  pool.query(
    `SELECT *
    FROM products 
    WHERE id=${id} AND discontinued = false `,
    (error, result) => {
      if (error) {
        return res.status(500).send(error);
      } else {
        let x = res.json(result.rows);
        console.log(x);
        return res.json(result.rows);

      }
    }
  );
}

function getProductByTag(req, res) {
  const tag = req.params.tag;
  pool.query(
    `SELECT DISTINCT(products.id), products.name, products.supplier_name, units_in_stock, total_price, discontinued, image_url
    FROM product_tags
    INNER JOIN products on (product_tags.product_id = products.id)
    INNER JOIN tags on (product_tags.tag_id = tags.id)
    WHERE tags.name ='${tag}' AND products.discontinued =false`,
    (error, result) => {
      if (error) {
        return res.status(500).send(error);
      } else {
        return res.json(result.rows);
      }
    }
  );
}

module.exports = router;
