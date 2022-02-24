const Pool = require("pg").Pool;
const pool = new Pool({
  user: "postgres",
  host: "localhost",
  database: "toy_database",
  password: "root@123",
  port: 5432,
});

module.exports = pool;
