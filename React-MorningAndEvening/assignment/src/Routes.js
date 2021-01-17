import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import React from 'react';
import ViewAllTodos from './viewTodos/viewAllTodos';
import CreateSingleTodo from './createTodos/createSingleTodo';
const Routes = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={ViewAllTodos} />
                <Route exact path="/add-single-todo" component={CreateSingleTodo} />
            </Switch>
        </Router>
    );
}

export default Routes;