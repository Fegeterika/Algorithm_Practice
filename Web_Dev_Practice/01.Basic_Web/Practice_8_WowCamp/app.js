// Import Dependencies --------------------------------------------------------
var express             = require("express"),
    app                 = express(),
    mongoose            = require("mongoose"),
    flash               = require("connect-flash"),
    passport            = require("passport"),
    localStrategy       = require("passport-local"),
    bodyParser          = require("body-parser"),
    methodOverride      = require("method-override"),
    Campground          = require("./models/campground.js"),
    Comment             = require("./models/comment.js"),
    User                = require("./models/user.js"),
    seedDB              = require("./seeds.js");

// Import Routes --------------------------------------------------------------
var commentRoutes       = require("./routes/comments.js"),
    campgroundRoutes    = require("./routes/campgrounds.js"),
    indexRoutes         = require("./routes/index.js");

// Initial Set Up -------------------------------------------------------------
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(__dirname + "/public"));
app.use(methodOverride("_method"));
app.use(flash());

mongoose.connect(process.env.DATABASEURL || "mongodb://localhost/wow_camp");

// Passport Config ------------------------------------------------------------
app.use(require("express-session")({
    secret: "CoE",
    resave: false,
    saveUninitialized: false
}));

app.use(passport.initialize());
app.use(passport.session());

passport.use(new localStrategy(User.authenticate()));
passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());

// Pass req.user to all pages -------------------------------------------------
app.use(function(req, res, next){
   res.locals.currentUser = req.user; 
   res.locals.error = req.flash("error");
   res.locals.success = req.flash("success");
   return next();
});

// Route Config ---------------------------------------------------------------
app.use("/", indexRoutes);
app.use("/campgrounds", campgroundRoutes);
app.use("/campgrounds/:id/comments", commentRoutes);

// Seed Database
//seedDB();

// Initialize Server ----------------------------------------------------------
app.listen(process.env.PORT, process.env.IP, function() {
    console.log("Node.js Server Initialized");
});