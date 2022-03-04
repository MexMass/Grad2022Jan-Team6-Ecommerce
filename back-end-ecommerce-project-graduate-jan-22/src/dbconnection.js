//creates a pool object that connects to database and export the connection
const Pool = require("pg").Pool;

const pool = new Pool({
  user: "postgres",
  host: "localhost",
  database: "toy_database",
  password: "root",
  port: 5432,
});

module.exports = pool;
