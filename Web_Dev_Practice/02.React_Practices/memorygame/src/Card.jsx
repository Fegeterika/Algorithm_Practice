import React, { Component } from 'react';
import './Card.css';

class Card extends Component {

  render() {
    const {id, color, cardState} = this.props;
    const style = {backgroundColor: cardState === 0 ? 'grey' : color};
    return (
      <div
        className="card-container"
        style={style}
        onClick={() => {this.props.onReveal(id, color);}}
      />
    );
  }
}

export default Card;
