import React, { Component } from 'react';
import "./Navbar.css"

import { NavLink } from "react-router-dom";

class Navbar extends Component {
    render() {
        return (
            <div className="topnav">
                <NavLink exact to="/">Movie Catalog</NavLink>
                <NavLink exact to="/uploadMovie">Movie Upload</NavLink>
                <NavLink exact to="/uploadRating">Rating Upload</NavLink>
                <div className='topnav-right'>
                    <NavLink exact to="/login">Login</NavLink>
                    <NavLink exact to="/signup">Signup</NavLink>
                    <NavLink exact to="/logout">Logout</NavLink>
                </div>
            </div>);
    }
}

export default Navbar;
