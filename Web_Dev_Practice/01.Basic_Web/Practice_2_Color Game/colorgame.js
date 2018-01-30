/* Color Game Javascript Sheet */

var numSquares = 6;
var colors = [];
var pickedColor;

var squares = document.querySelectorAll(".square");
var colorDisplay = document.getElementById("colorDisplay");
var messageDisplay = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetBtn = document.querySelector("#reset");
var modeButtons = document.querySelectorAll(".mode");

init();

function init() {
	setupModeButtons();
	setupSquares();
	reset();
}

function setupSquares() {
	for (var i = 0; i < squares.length; i++) {
		//add click listeners to squares
		squares[i].addEventListener("click", function(){
			//grab color of clicked square
			var clickedColor = this.style.background;
			//compare clickedColor to pickedColor
			if (clickedColor === pickedColor) {
				messageDisplay.textContent = "Correct!";
				resetBtn.textContent = "Play Again?";
				changeColors(clickedColor);
			} else {
				//change color to background color if wrong
				this.style.background = "#232323";
				messageDisplay.textContent = "Try Again";
			}
		})
	}
}

function setupModeButtons() {
	//modeButtons Event Listener
	for (var i = 0; i < modeButtons.length; i++) {
		modeButtons[i].addEventListener("click", function() {
			//control selected class
			modeButtons[0].classList.remove("selected");
			modeButtons[1].classList.remove("selected");
			this.classList.add("selected");

			this.textContent === "Easy" ? numSquares = 3 : numSquares = 6;
			reset();
		});
	}
	resetBtn.addEventListener("click", function() {
		reset();
	})
}

function generateRandomColors(num) {
	//Make temporary array
	var arr = [];
	//Loop to add random colors
	for (var i = 0; i < num; i++) {
		arr.push(randomColor());
	}
	//return finished array
	return arr;
}

function randomColor() {
	//pick "R" from 0 - 255
	var red = Math.floor(Math.random() * 256);
	//pick "G' from 0 - 255
	var green = Math.floor(Math.random() * 256);
	//pick "B" from 0 - 255
	var blue = Math.floor(Math.random() * 256);
	//return string equivalent of RGB code
	return 'rgb(' + red + ', ' + green + ', ' + blue + ')';
}

function pickColor() {
	var random = Math.floor(Math.random() * colors.length);
	return colors[random];
}

function changeColors(color) {
	//loop through all squares and change colors
	for (var i = 0; i < squares.length; i++) {
		squares[i].style.background = color;
	}
	h1.style.background = color;
}

function reset() {
	//generate new color sets
	colors = generateRandomColors(numSquares);
	//change button text
	resetBtn.textContent = "New Colors";
	messageDisplay.textContent = "";
	//pick new random color
	pickedColor = pickColor();
	//change colorDisplay to match picked Color
	colorDisplay.textContent = pickedColor;
	//change square colors
	for (var i = 0; i < squares.length; i++) {
		if(colors[i]) {
			squares[i].style.display = "block";
			squares[i].style.background = colors[i];
		} else {
			squares[i].style.display = "none";
		}
	}
	//change h1 background
	h1.style.background = "steelblue";
}