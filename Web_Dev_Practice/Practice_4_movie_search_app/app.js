// Import Dependencies ------------------------------------------------
var express = require("express");
var app = express();

var request = require("request");

// Node App Settings --------------------------------------------------
app.set("view engine", "ejs");
app.use(express.static("public"));

// Routing ------------------------------------------------------------

// Front Page with no result shown
app.get("/", function(req, res) {
   res.render("search"); 
});

// Result Page Shown
app.get("/results", function(req, res) {
    var query = req.query.search;
    var url = "http://www.omdbapi.com/?s=" + query;
    
    request(url, function(err, resp, body) {
        if (!err && resp.statusCode == 200) {
            var data = JSON.parse(body);
            res.render("results", {data: data, resNum: req.query.resNum});
        }
    });
});

// Initiate Node.js Server [Using C9 Cloud Server Settings] -----------
app.listen(process.env.PORT, process.env.IP, function(req, res) {
    console.log("Movie App Server Started");
});