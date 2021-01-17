import React from 'react';
import DeleteRoundedIcon from '@material-ui/icons/DeleteRounded';
import "./viewSingleTodo.css";

const ViewSingleTodo = ({ el, idx, deleteTodo }) => {
    const styles = {
        margin: 15,
        padding: 15
    };
    return (
        < div style={styles} key={idx}>
            {/* { console.log(el)} */}
            <h3> {el.todo.title}</h3>
            <div class="singleTodoContent">
                <span> {el.todo.date}</span>
                <span class="deleteButtonSpan" style={{ color: "red" }} onClick={() => { deleteTodo(idx) }}> <DeleteRoundedIcon /> </span>
            </div>
            <p>{el.todo.content}</p>
        </ div>
    );
}

export default ViewSingleTodo;