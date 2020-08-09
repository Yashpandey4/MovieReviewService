import React, { Component } from 'react';
import './App.css';

import { Route, Switch } from "react-router-dom";
import Navbar from './Components/Navbar/Navbar';
import Auth from './Components/Auth';
import LogOut from './Components/logout';
import Form from './Components/Form';

class App extends Component {
  render() {
    return (
      <div className="App container">
        <Navbar />
        <Switch>
          <Route path='/' exact render={() => <Form />} />
          <Route path='/uploadMovie' exact render={() => (<h1>Upload Movie</h1>)} />
          <Route path='/uploadRating' exact render={() => (<h1>Upload Rating</h1>)} />
          <Route path='/login' render={() => <Auth type='Login' />} />
          <Route path='/signup' exact render={() => <Auth type='Sign Up' />} />
          <Route path='/logout' exact render={() => LogOut()} />
        </Switch>
      </div>);
  }
}

export default App;
