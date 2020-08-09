import React, { Component } from 'react'
import AuthenticationService from '../Service/AuthenticationService';
import AxiosService from '../Service/AxiosService';

interface AppProps {
    type: string
}

interface AppState {
    username: string,
    password: string,
    hasLoginFailed: boolean,
    showSuccessMessage: boolean
}


class Auth extends Component<AppProps, AppState | any> {

    constructor(props: any) {
        super(props)

        this.state = {
            username: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    handleChange(event: any) {
        this.setState(
            {
                [(event.target as any).name]
                    : (event.target as any).value
            }
        )
    }

    handleSubmit() {

        if (this.props.type === 'Login') {
            AxiosService
                .loginService(this.state.username, this.state.password)
                .then((response) => {
                    console.log(response)
                    this.setState({ showSuccessMessage: true })
                    AuthenticationService.registerSuccessfulLoginForJwt(this.state.username, response.data.jwt)
                }).catch(() => {
                    this.setState({ showSuccessMessage: false })
                    this.setState({ hasLoginFailed: true })
                })
        }
        else if (this.props.type === 'Sign Up') {
            AxiosService
                .signUpService(this.state.username, this.state.password)
                .then(response => {
                    console.log(response)
                    this.setState({ showSuccessMessage: true })
                }).catch(() => {
                    this.setState({ showSuccessMessage: false })
                    this.setState({ hasLoginFailed: true })
                })
        }

    }

    render() {
        return (
            <div>
                <h1>{this.props.type}</h1>
                <div className="container">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage && <div>{this.props.type + ' '}Sucessful</div>}

                    UserName: <input type="text"
                        name="username"
                        value={this.state.username}
                        onChange={this.handleChange} />
                    <br />

                    Password: <input type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange} />
                    <br />
                    <button className="btn btn-success" onClick={this.handleSubmit}>Submit</button>
                </div>
            </div>
        )
    }
}

export default Auth;