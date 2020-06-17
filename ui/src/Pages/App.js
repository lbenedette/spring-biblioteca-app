import React from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import Navbar from "../Components/Navbar/Navbar";
import Home from "./Home/Home";

function App() {
  return (
    <div>
      <Navbar />
      <Switch>
        <Route path="/" exact={true} component={Home} />
      </Switch>
    </div>
  );
}

export default App;
