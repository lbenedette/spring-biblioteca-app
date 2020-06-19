import React from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import Navbar from '../Components/Navbar/Navbar';
import Home from './Home/Home';
import Books from './Books/Books';
import NotFound from "./NotFound/NotFound";

function App() {
  return (
    <div>
      <Navbar />
      <Switch>
        <Route path="/" exact={true} component={Home} />
        <Route path="/books" exact={false} component={Books} />
        <Route path="*" exact={false} component={NotFound} />
      </Switch>
    </div>
  );
}

export default App;
