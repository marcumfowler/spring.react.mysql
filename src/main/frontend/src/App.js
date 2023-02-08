import React, { Component } from "react";
import { Route, BrowserRouter as Router } from "react-router-dom";
import Table from "./Components/Table";
import User from "./Components/User";

class App extends Component {
  render() {
    return (
      <Router>
        <Route exact path="/user" component={User} />
        <Route exact path="/users"component={Table} />
      </Router>
    );
  }
}

export default App;