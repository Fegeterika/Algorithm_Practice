import React, { Component } from 'react'
import PropTypes from 'prop-types';
import './Navbar.css'

class Navbar extends Component {

	constructor(props) {
		super(props);
		this.showNewForm = this.showNewForm.bind(this);
	}

	static defaultProps = {
		onNewRecipe: () => {}
	}

	static propTypes = {
		onNewRecipe: PropTypes.func
	}

	showNewForm(event) {
		event.preventDefault();
		this.props.onNewRecipe(true);
	}

	render() {
		return (
			<header>
				<h2><a>Recipe App Exercise</a></h2>
				<nav>
					<li><a onClick={this.showNewForm}>New Recipe</a></li>
					<li><a>Home</a></li>
					<li><a>About</a></li>
					<li><a>Contact Us</a></li>
				</nav>
			</header>
		);
	}
}

export default Navbar;
