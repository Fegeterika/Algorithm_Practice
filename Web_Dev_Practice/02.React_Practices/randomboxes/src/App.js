import React, { Component } from 'react';
import './App.css';

const NUM_BOXES = 32;

const Box = ({color}) => {
  const style = {
    width: '75px',
    height: '75px',
    display: 'inline-block',
    backgroundColor: color
  };
  return <div style={style} />;
}

class App extends Component {
  constructor(props) {
    super(props);
    let boxes = Array(NUM_BOXES).fill().map(this.randomColor, this);
    console.log(boxes);
    this.state = {boxes: boxes};

    setInterval(() => {
      let rBoxIndex = Math.floor(Math.random() * NUM_BOXES);
      boxes = boxes.slice();
      boxes[rBoxIndex] = this.randomColor();
      this.setState({boxes: boxes});
    }, 100);
  }

  randomColor() {
    let red = Math.floor(Math.random() * 255);
    let green = Math.floor(Math.random() * 255);
    let blue = Math.floor(Math.random() * 255);
    return `rgb(${red},${green},${blue})`;
  }

  render() {
    const rBoxes = this.state.boxes.map((color, i) => {
      return <Box key={i} color={color} />
    });
    return (
      <div className="App">
        {rBoxes}
      </div>
    );
  }
}

export default App;
