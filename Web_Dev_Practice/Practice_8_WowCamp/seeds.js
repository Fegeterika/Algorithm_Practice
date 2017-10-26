var mongoose = require("mongoose");
var Campground = require("./models/campground.js");
var Comment = require("./models/comment.js");

var data = [
        {name: "Hall of Valor", image:"http://cdn.themis-media.com/media/global/images/library/deriv/953/953040.png", description: "Come hang out with Odin. Beware of wolves though..."},
        {name: "Eye of Azshara", image:"https://bnetcmsus-a.akamaihd.net/cms/content_entry_media/PSG701GCH37P1470802457392.jpg", description: "Fishes and scary serpents. Also some seagulls"},
        {name: "Darkheart Thicket", image:"http://wow.zamimg.com/uploads/screenshots/normal/497565-darkheart-thicket.jpg", description: "Friendly mushrooms and trees."},
        {name: "Maw of Souls", image:"https://bnetcmsus-a.akamaihd.net/cms/content_entry_media/5VPO99EBRSVC1471313537927.jpg", description: "Get ready for those tentacles play"}
    ];

function seedDB() {
    // Remove all campgrounds
    Comment.remove({}, function(err) {
        if (err) {
            console.log(err);
        }
    });
    Campground.remove({}, function(err) {
        if (err) {
            console.log(err);
        }
        console.log("Database Removed");
        // Add few campgrounds
/*        data.forEach(function(seed) {
        Campground.create(seed, function(err, campground) {
           if (err) {
               console.log(err);
           } else {
               console.log("added campgrounds from seed");
               Comment.create({text: "BLAH BLAH BLAH", author: "GORAE"}, function(err, comment) {
                   if (err) {
                       console.log(err);
                   } else {
                       campground.comments.push(comment);
                       campground.save();
                       console.log("created new comment");
                   }
                   
               });
           }
       }); 
    });*/
    }); 
    
    // Add Comments
}

module.exports = seedDB;