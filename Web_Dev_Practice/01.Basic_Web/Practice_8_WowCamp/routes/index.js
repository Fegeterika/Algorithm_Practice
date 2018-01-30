// =========================
// Auth. Routes
// =========================

var express = require("express"),
    router = express.Router(),
    passport = require("passport"),
    Campground = require("../models/campground.js"),
    User = require("../models/user.js");

// Root Route
router.get("/", function(req, res) {
    res.render("landing");
});

// Register form
router.get("/register", function(req, res) {
   res.render("register"); 
});

// Handle Registration
router.post("/register", function(req, res) {
   
   var newUser = new User({username: req.body.username});
   
   User.register(newUser, req.body.password, function(err, user) {
       if (err) {
           req.flash("error", err.message);
           return res.redirect("register");
       }
       passport.authenticate("local")(req, res, function() {
          req.flash("success", "Welcome to WoWCamp " + user.username);
          res.redirect("/campgrounds"); 
       });
   });
});

// show login form
router.get("/login", function(req, res) {
   res.render("login"); 
});

// Handle login
router.post("/login", passport.authenticate("local", 
    {
        successRedirect: "/campgrounds", 
        failureRedirect: "/login"
    }), function(req, res) {
});

// Log out
router.get("/logout", function(req, res) {
   req.logout(); 
   req.flash("success", "Logged you out");
   res.redirect("/campgrounds");
});

module.exports = router;