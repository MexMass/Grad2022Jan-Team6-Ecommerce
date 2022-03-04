const express = require("express");
const router = express.Router();
const pool = require("../dbconnection");

router.get("",(req,res)=>{
    res.send("Perform login first...");
})
router.post("/login",(req,res)=>{
    const {useremail,password} = req.body;
    pool.query(`SELECT id FROM login_detail
    WHERE id = (select id from users 
    where email = $1)
    AND password = crypt($2, password);`,[useremail,password], (err,result)=>{
        if(err){
            return res.status(500).send("Internal Error on server");
        }
        else{
            if(result.rowCount == 1){
                return res.status(200).send("Login successful")
            }
            else{
                return res.status(400).send("Authentication failed")
            }
        }
    })
})

module.exports = router;