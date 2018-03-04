import React, { Component } from 'react';
import RecipeList from './RecipeList.jsx';
import Navbar from './Navbar.jsx';
import NewRecipe from './NewRecipe.jsx';
import './RecipeApp.css';

class RecipeApp extends Component {

  constructor(props) {
    super(props);
    this.state = {
      recipes: [
  			{
          id: 0,
  				title: 'Pasta',
  				instructions: 'This is an ordinary pasta. What other instructions do you need?',
  				ingredients: ['pasta', 'veges', 'spices?'],
  				img: 'https://food.fnr.sndimg.com/content/dam/images/food/fullset/2011/3/1/0/FNM_040111-WN-Dinners-030_s4x3.jpg.rend.hgtvcom.616.462.suffix/1371595164628.jpeg'
  			},
  			{
          id: 1,
  				title: 'Coffee',
  				instructions: 'starbucks',
  				ingredients: ['coffee beans', 'water', 'electricity'],
  				img: 'https://cdn.cnn.com/cnnnext/dam/assets/150929101049-black-coffee-stock-exlarge-169.jpg'
  			}
  		],
      nextRecipeId: 2,
      showForm: false
    }
    this.handleSave = this.handleSave.bind(this);
    this.handleShowForm = this.handleShowForm.bind(this);
    this.handleDelete = this.handleDelete.bind(this);
  }

  handleSave(recipe) {
    this.setState((prevState, props) => {
      const newRecipe = {...recipe, id: this.state.nextRecipeId};
      return {
        nextRecipeId: prevState.nextRecipeId + 1,
        recipes: [...prevState.recipes, newRecipe],
        showForm: false
      }
    });
  }

  handleShowForm(showForm) {
    this.setState({showForm});
  }

  handleDelete(id) {
    const recipes = this.state.recipes.filter((recipe) => (recipe.id !== id));
    this.setState({recipes});
  }

  render() {
    const {showForm} = this.state;
    return (
      <div className="App">
        <Navbar onNewRecipe={this.handleShowForm}/>
        {showForm ? <NewRecipe onSave={this.handleSave} onHide={this.handleShowForm}/> : null }
        <RecipeList recipes={this.state.recipes} onDelete={this.handleDelete}/>
      </div>
    );
  }
}

export default RecipeApp;
