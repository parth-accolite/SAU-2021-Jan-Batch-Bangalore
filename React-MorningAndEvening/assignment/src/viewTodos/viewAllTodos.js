import React, { Component } from 'react';
import ViewSingleTodo from "./viewSingleTodo";

class ViewAllTodos extends Component {
    constructor() {
        super();
        this.state = {
            todos: JSON.parse(localStorage.getItem("todoList"))
        }
        var byDate = this.state.todos.slice(0);
        byDate.sort(function (a, b) {
            var x = a.todo.date.toLowerCase();
            var y = b.todo.date.toLowerCase();
            return x < y ? -1 : x > y ? 1 : 0;
        })
        this.state.todos = byDate;
    }
    addNewTodo = () => {
        this.props.history.push('/add-single-todo');

    }
    deleteTodo = (id) => {
        let lists = this.state.todos;
        var byDate = lists.slice(0);
        byDate.sort(function (a, b) {
            var x = a.todo.date.toLowerCase();
            var y = b.todo.date.toLowerCase();
            return x < y ? -1 : x > y ? 1 : 0;
        })

        lists = byDate.slice(0);
        lists.splice(id, 1);
        localStorage.setItem("todoList", JSON.stringify(lists));
        this.setState({ todos: lists });
    }

    componentDidUpdate() { }
    render() {
        return (
            <>
                {

                    this.state.todos === null || this.state.todos.length === 0
                        ?
                        <h1> No todos added</h1>
                        :
                        this.state.todos.map((el, idx) => {
                            return (
                                <ViewSingleTodo el={el} idx={idx} deleteTodo={this.deleteTodo} />
                            )
                        })
                }
                <button onClick={this.addNewTodo} > Add new Todo</button>
            </>
        )
    }
}

export default ViewAllTodos;