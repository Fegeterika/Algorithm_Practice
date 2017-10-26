// Require packages
var express                 = require("express"),
    mongoose                = require("mongoose"),
    passport                = require("passport"),
    bodyParser               = require("body-parser"),
    expressSession          = require("express-session"),
    User                    = require("./models/user"),
    localStrategy           = require("passport-local"),
    passportLocalMongoose   = require("passport-local-mongoose");
    
// Initial Configuration
var app = express();
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(__dirname + "/public"));

app.use(expressSession({
   secret: "Gom is Cute",
   resave: false,
   saveUninitialized: false
}));

app.use(passport.initialize());
app.use(passport.session());

passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());
passport.use(new localStrategy(User.authenticate()));

mongoose.connect("mongodb://localhost/auth_demo)app");

// ==============================
// Routes
// ==============================

// INDEX Routing
app.get("/", function(req, res) {
   res.render("home"); 
});

// Register Routing
app.get("/register", function(req, res) {
   // show sign up form
   res.render("register"); 
});

app.post("/register", function(req, res) {
    User.register(new User({username: req.body.username}), req.body.password, function(err, user) {
       if (err) {
           console.log(err);
           return res.render("register");
       }
       passport.authenticate("local")(req, res, function() {
           res.redirect("/secret");
       });
    });
});

// Log In Routing
app.get("/login", function(req, res) {
    res.render("login");
});

// Middleware
app.post("/login", passport.authenticate("local", {
    successRedirect: "/secret",
    failureRedirect: "/login"
    }), function(req, res) {
    
});

// Log Out Routing
app.get("/logout", function(req, res) {
    req.logout();
    res.redirect("/");
});

app.get("/secret",isLoggedIn, function(req, res) {
    res.render("secret");
});

function isLoggedIn(req, res, next) {
    if (req.isAuthenticated()) {
        return next();
    } else {
        res.redirect("/login");
        console.log("eeerr");
    }
}

// Initialize Server
app.listen(process.env.PORT, process.env.IP, function() {
    console.log("Server Started");
});