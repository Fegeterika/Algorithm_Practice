import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import RecipeApp from './RecipeApp.jsx';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<RecipeApp />, document.getElementById('root'));
registerServiceWorker();
