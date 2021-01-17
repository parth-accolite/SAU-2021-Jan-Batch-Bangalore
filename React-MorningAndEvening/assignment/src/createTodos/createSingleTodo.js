import { Component, React } from "react";

class CreateSingleTodo extends Component {
    constructor() {
        super();
        this.state = {
            title: '',
            content: '',
            date: ''
        };
        this.styles = { padding: 15, margin: 20 };

    }

    setTitle = (event) => {
        console.log(event.target.value);
        this.setState({
            title: event.target.value,
        })
    }

    setContent = (event) => {
        console.log(event.target.value);
        this.setState({
            content: event.target.value,
        })
    }

    setDate = (event) => {
        console.log(event.target.value)
        this.setState({
            date: event.target.value,

        })
    }

    handleSubmit = (event) => {
        let todoList = JSON.parse(localStorage.getItem("todoList"));
        if (todoList === null) {
            todoList = [{
                id: 1,
                todo: this.state,
            }]
        }
        else {
            todoList.push({
                id: todoList.length + 1,
                todo: this.state,
            })
        }

        localStorage.setItem("todoList", JSON.stringify(todoList));
        this.props.history.goBack();
        event.preventDefault();
    }

    render() {
        return (
            <>
                <div style={this.styles}>
                    <h1> Add new Todo</h1>
                    <form id="addTodoForm" onSubmit={this.handleSubmit}>

                        <label>
                            <input style={this.styles} type="text" placeholder="enter Todo Title" onChange={this.setTitle} />
                        </label>
                        <br />
                        <label>
                            <input style={this.styles} type="text" placeholder="enter Todo Details" onChange={this.setContent} />
                        </label>
                        <br />
                        <label>
                            <input style={this.styles} type="date" placeholder="enter Date" onChange={this.setDate} />
                        </label>
                        <br />
                        <input style={this.styles} type="submit" />
                    </form>
                </div>
            </>

        );
    }
}

export default CreateSingleTodo;