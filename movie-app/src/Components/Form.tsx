import React from 'react';
import AuthenticationService from '../Service/AuthenticationService';
import AxiosService from '../Service/AxiosService';

class Form extends React.Component {
    componentDidMount() {
        AxiosService.movieSchemaService()
            .then(res => {
                console.log(res);
            })
            .catch(e => console.log(e))
    }
    render() {
        return <h1>{AuthenticationService.getLoggedInUserName()}</h1>
    }
}

export default Form;