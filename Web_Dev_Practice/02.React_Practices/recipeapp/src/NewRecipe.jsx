import React, { Component } from 'react';
import './NewRecipe.css'

class NewRecipe extends Component {

  constructor(props) {
    super(props);
    this.state = {
      title: '',
      instructions: '',
      ingredients: [''],
      img: ''
    }
    this.handleFormChange = this.handleFormChange.bind(this);
    this.handleNewIngredient = this.handleNewIngredient.bind(this);
    this.handleChangeIngredient = this.handleChangeIngredient.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.hideNewForm = this.hideNewForm.bind(this);
  }

  static defaultProps = {
    onHide: () => {},
    onSave: () => {}
  }

  handleFormChange(event) {
    this.setState({[event.target.name]: event.target.value});
  }

  handleNewIngredient(event) {
    const {ingredients} = this.state;
    this.setState({ingredients: [...ingredients, '']});
  }

  handleChangeIngredient(event) {
    const targetIndex = Number(event.target.name.split('-')[1]);
    const ingredients = this.state.ingredients.map((ing, i) => (
      i === targetIndex ? event.target.value : ing
    ));
    this.setState({ingredients});
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.onSave({...this.state});
    this.setState({
      title: '',
      instructions: '',
      ingredients: [''],
      img: ''
    });
  }

  hideNewForm(event) {
    event.preventDefault();
    this.props.onHide(false);
  }

  render() {
    const {title, instructions, ingredients, img} = this.state;
    let inputIngs = ingredients.map((ing, i) => {
      return (
        <div key={`ingredient-${i}`} className="recipe-form-line">
          <label>{i + 1}
            <input
              type="text"
              name={`ingredient-${i}`}
              value={ing}
              size={45}
              autoComplete="off"
              placeholder="Ingredient"
              onChange={this.handleChangeIngredient}
            />
          </label>
        </div>
      )
    })

    return (
      <div className="recipe-form-container">
        <form className="recipe-form" onSubmit={this.handleSubmit}>
          <button
            type="button"
            className="close-button"
            onClick={this.hideNewForm}
          >
            X
          </button>
          <div className="recipe-form-line">
            <label htmlFor="recipe-title-input">Title</label>
            <input
              id="recipe-title-input"
              key="title"
              type="text"
              name="title"
              value={title}
              size={42}
              autoComplete="off"
              onChange={this.handleFormChange}
            />
          </div>
          <label
            htmlFor="recipe-instructions-input"
            style={{marginTop: '5px'}}
          >
            Instructions
          </label>
          <textarea
            id="recipe-instructions-input"
            key="instructions"
            type="Instructions"
            name="instructions"
            rows="8"
            cols="50"
            value={instructions}
            size={42}
            autoComplete="off"
            onChange={this.handleFormChange}
          />
          {inputIngs}
          <button
            type="button"
            className="buttons"
            onClick={this.handleNewIngredient}
          >
            +
          </button>
          <div className="recipe-form-line">
            <label htmlFor="recipe-img-input">Image Url</label>
            <input
              id="recipe-img-input"
              key="img"
              type="text"
              name="img"
              value={img}
              size={36}
              autoComplete="off"
              onChange={this.handleFormChange}
            />
          </div>
          <button
            type="submit"
            className="buttons"
            style={{alignSelf: 'flex-end', marginRight: 0}}
          >
            SAVE
          </button>
        </form>
      </div>
    );
  }
}

export default NewRecipe;
