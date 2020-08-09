import axios from 'axios'

const API_URL = 'http://localhost:8762'

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

class AxiosService {

    signUpService(username: string, password: string) {
        return axios.post(`${API_URL}/api/auth/signup`, {
            username: username,
            password: password
        });
    }

    loginService(username: string, password: string) {
        return axios.post(`${API_URL}/api/auth/authenticate`, {
            username: username,
            password: password
        });
    }
    movieSchemaService() {
        return axios.get(`${API_URL}/movie-schema/schema/movie-upload`);
        // return axios.get(`http://localhost:8080/schema/movie-upload`, {
        //     headers: {
        //         'x-apikey': '59a7ad19f5a9fa0808f11931',
        //         'Access-Control-Allow-Origin': '*',
        //         'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        //     }
        // });
    }

    setupAxiosInterceptors(token: string) {
        console.log(token)
        axios.interceptors.request.use(
            (config) => {
                config.headers.authorization = token
                return config
            }
        )
        // axios.defaults.headers.common['Authorization'] = token;
    }
}

export default new AxiosService();