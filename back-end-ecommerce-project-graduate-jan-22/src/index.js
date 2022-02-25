const express = require("express");
const app = express();
const getProductRouter = require("./routes/getProducts");
const body_parser = require("body-parser");

let port = 3000;
app.listen(port, () => {
  console.log("Server started started successfully");
});

app.use(body_parser.json());
app.use("/products", getProductRouter);
