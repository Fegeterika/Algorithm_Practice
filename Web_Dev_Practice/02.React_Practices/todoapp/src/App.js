import React, { Component } from 'react';
import './App.css';

const TodoItem = ({task}) => {
  return <li>{task}</li>;
}

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      newTodo: '',
      tasks: ['feed gom']
    }
    this.appendTodo = this.appendTodo.bind(this);
  }

  appendTodo(event) {
    event.preventDefault();
    let tasks = [...this.state.tasks, this.state.newTodo];
    this.setState({newTodo: '', tasks});
  }

  render() {
    return (
      <div className="todoapp">
        <h1>Simple Todo App</h1>
        <form onSubmit={this.appendTodo}>
          <input 
            className="todo-input"
            type="text"
            name="newTodo"
            placeholder="Enter a new task"
            value={this.state.inputText}
            onChange={(event) => {
              this.setState({[event.target.name]: event.target.value})
            }}
          />
          <button 
            type="submit">
            Submit
          </button>
        </form>
        <div className="todolist">
          <ol>
            {this.state.tasks.map((task, i) => {
              return <TodoItem key={i} task={task}/>;
            })}
          </ol>
        </div>
      </div>
    );
  }
}

export default App;
