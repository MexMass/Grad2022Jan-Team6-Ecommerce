const express = require("express");
const bodyParser = require("body-parser");
// import route in index.js
const postProductRoute = require("./routes/createProduct");
const getProductRouter = require("./routes/getProducts");
const discountRouter = require("./routes/discount");

// creating Web server
const app = express();

// for every incoming request, bodyParser will parse data from bytes into JSON object &
// vice-versa for every reponse JSON into bytes. Works with POST and PUT/PATCH
app.use(bodyParser.json());

// custom middleware2
app.use((req, res, next) => {
  console.log("Incoming Request Middleware" + req.body);
  next();
});

// middleware - use()
app.use("/products", postProductRoute);
app.use("/products", getProductRouter);
app.use("/discounts", discountRouter);

app.listen(3000, () => {
  console.log("server started...");
});
