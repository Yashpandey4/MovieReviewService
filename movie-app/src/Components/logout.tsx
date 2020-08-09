import React from 'react';
import AuthenticationService from '../Service/AuthenticationService';
import { Redirect } from 'react-router-dom';

const LogOut = () => {
    if (AuthenticationService.isUserLoggedIn()) {
        AuthenticationService.logout();
    }
    return <Redirect to="/login" />;
}

export default LogOut;