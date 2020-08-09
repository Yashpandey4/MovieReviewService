import React, { Component } from "react";
import axios from 'axios';

class Catalog extends Component {
    state = {
        isLoading: true,
        movies: []
    };

    async componentDidMount() {
        axios.get('https://dog.ceo/api/breeds/image/random')
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        const { movies, isLoading } = this.state

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <h1>Jainam</h1>
        );

    }



}