// =========================
// Comment Routes
// =========================

var express = require("express"),
    router = express.Router({mergeParams: true}),
    Campground = require("../models/campground.js"),
    Comment = require("../models/comment.js");

var middleware = require("../middleware");

// Comments New
router.get("/new", middleware.isLoggedIn, function(req, res) {
    Campground.findById(req.params.id, function(err, foundCampground) {
        if (err) {
            req.flash("error", "Oops, something went wrong");
            console.log(err);
        } else {
            res.render("comments/new", {campground: foundCampground});
        }
    });
});

// Comments Create
router.post("/", middleware.isLoggedIn, function(req, res) {
    // look up campground using ID
    Campground.findById(req.params.id, function(err, foundCampground) {
       if (err) {
           console.log(err);
           res.redirect("/campgrounds");
       } else {
            // create new comment
            Comment.create(req.body.comment, function(err, comment) {
               if (err) {
                   req.flash("error", "Oops, something went wrong");
                   console.log(err);
               } else {
                   // add username and id to comment
                   comment.author.id = req.user._id;
                   comment.author.username = req.user.username;
                   // save comment
                   comment.save();
                   // connect new comment to campground
                   foundCampground.comments.push(comment);
                   foundCampground.save();
                   req.flash("success", "Successfully added comment");
                   res.redirect("/campgrounds/" + foundCampground._id);
               }
            });
       }
    });
});

// Comments Edit
router.get("/:comment_id/edit", middleware.checkCommentOwnership, function(req, res) {
    Comment.findById(req.params.comment_id, function(err, foundComment) {
       if (err) {
           req.flash("error", "Oops, something went wrong");
           res.redirect("back");
       } else {
            res.render("comments/edit", {campground_id: req.params.id, comment: foundComment });
       }
    });
});

// Comments Update
router.put("/:comment_id", middleware.checkCommentOwnership, function(req, res) {
    Comment.findByIdAndUpdate(req.params.comment_id, req.body.comment, function(err, updatedComment) {
       if (err) {
           req.flash("error", "Oops, something went wrong");
           res.redirect("back");
       } else {
           res.redirect("/campgrounds/" + req.params.id);
       }
    });
});

// Comments Destroy
router.delete("/:comment_id", middleware.checkCommentOwnership, function(req, res) {
    Comment.findByIdAndRemove(req.params.comment_id, function(err) {
        if (err) {
            req.flash("error", "Oops, something went wrong");
            res.redirect("back");
        } else {
            req.flash("success", "Comment Deleted");
            res.redirect("/campgrounds/" + req.params.id);
        }
    });
});

module.exports = router;