const express = require("express");
const router = express.Router();
const pool = require("../dbconnection");

//default url
router.get("", getProducts);

router.get("/:id", getProductById);
router.get("/tag/:tag", getProductByTag);

function getProducts(req, res) {
  pool.query(
    "SELECT * FROM products WHERE discontinued = 'false'",
    (error, result) => {
      if (error) {
        return res.status(500).send("Internal Error");
      } else {
        return res.send(result.rows);
      }
    }
  );
}

function getProductById(req, res) {
  const id = parseInt(req.params.id);
  pool.query(
    `SELECT * FROM products WHERE id=${id} AND discontinued = 'false' `,
    (error, result) => {
      if (error) {
        return res.status(500).send("internal Error");
      } else {
        return res.send(result.rows);
      }
    }
  );
}

function getProductByTag(req, res) {
  const tag = parseInt(req.params.tag);
  pool.query(
    `SELECT DISTINCT(products.id), products.name, units_in_stock, total_price, image_url
    FROM products_tags
    INNER JOIN products on (product_tags.product_id = products.id)
    INNER JOIN tags on (product_tags.tag_id = tags.id)
    WHERE tag.name ='${tag}' AND products.discontinued ='false'`,
    (error, result) => {
      if (error) {
        return res.status(500).send("internal Error");
      } else {
        return res.send(result.rows);
      }
    }
  );
}

module.exports = router;
