import React, { Component } from 'react';
import Navbar from './Navbar.jsx';
import Card from './Card.jsx';

const cardStates = {
  unturned: 0,
  showing: 1,
  matched: 2
}

class MemoryGame extends Component {

  constructor(props) {
    super(props);
    let cards = this.initialize(10);
    this.state = {
      cards: cards,
      totalAns: 10,
      curAns: new Set(),
      firstChosen: null,
      firstId: null,
      enable: true,
      message: ''
    }
    this.handleClick = this.handleClick.bind(this);
    this.handleNewGame = this.handleNewGame.bind(this);
  }

  initialize(numPairs) {
    let cards = Array(numPairs).fill().map(() => {
      return {
        color: this.getRandomColor(),
        cardState: cardStates.unturned
      };
    });
    cards = cards.concat(cards);
    this.shuffleArray(cards);
    cards = cards.map((card, i) => {
      return {...card, id: i};
    });
    return cards;
  }

  // Assign random color to each card
  getRandomColor() {
    let red = Math.floor(Math.random() * 255);
    let green = Math.floor(Math.random() * 255);
    let blue = Math.floor(Math.random() * 255);
    return `rgb(${red},${green},${blue})`;
  }

  // Shuffle array in place
  shuffleArray(arr) {
    for (let i = 0; i < arr.length; i++) {
      let target = Math.floor(Math.random() * arr.length);
      let temp = arr[target];
      arr[target] = arr[i];
      arr[i] = temp;
    }
  }

  handleClick(id, color) {
    let {firstChosen, firstId, message} = this.state;
    let curAns = new Set(this.state.curAns);
    if (this.state.enable && !curAns.has(color)) {
      if (firstChosen === null) {
        firstChosen = color;
        firstId = id;
        let cards = this.state.cards.map((card) => {
          if (card.id === id && card.cardState === cardStates.unturned) {
            return {...card, cardState: cardStates.showing};
          } else {
            return {...card};
          }
        });
        message = 'Choose a second color now!';
        this.setState({cards, curAns, firstChosen, firstId, message});
      } else {
        if (id !== firstId) {
          if (firstChosen === color) {
            curAns.add(color);
            if (curAns.size === this.state.totalAns) {
              message = 'Game Finished!';
            } else {
              message = `Match found! ${curAns.size} out of ${this.state.totalAns}`
            }
          } else {
            message = 'Wrong guess! try again'
          }
          firstChosen = null;
          firstId = null;
          let cards = this.state.cards.map((card) => {
            if (curAns.size > this.state.curAns.size && card.color === color) {
              return {...card, cardState: cardStates.matched};
            } else if (card.id === id) {
              return {...card, cardState: cardStates.showing};
            } else {
              return {...card};
            }
          });

          this.setState({cards, curAns, firstChosen, firstId, message, enable: false}, () => {
            setTimeout(() => {
              let cards = this.state.cards.map((card) => {
                if (card.cardState !== cardStates.matched) {
                  return {...card, cardState: cardStates.unturned};
                } else {
                  return {...card};
                }
              });
              this.setState({cards, curAns, firstChosen, firstId, enable: true});
            }, 2000)
          });
        }
      }
    }
  }

  handleNewGame() {
    let cards = this.initialize(10);
    let initStates =  {
      cards: cards,
      totalAns: 10,
      curAns: new Set(),
      firstChosen: null,
      firstId: null,
      enable: true,
      message: ''
    }
    this.setState({...initStates});
  }

  render() {

    const cards = this.state.cards.map((card) => {
      return <Card key={card.id} {...card} onReveal={this.handleClick} />;
    })

    return (
      <div className="memory-game">
        <Navbar onNew={this.handleNewGame} />
        <h1>{this.state.message}</h1>
        {cards}
      </div>
    );
  }
}

export default MemoryGame;
