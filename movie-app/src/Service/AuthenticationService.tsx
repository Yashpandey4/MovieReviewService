import AxiosService from './AxiosService'

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

class AuthenticationService {

    createBasicAuthToken(username: string, password: string) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }

    registerSuccessfulLoginForJwt(username: string, token: string) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username)
        AxiosService.setupAxiosInterceptors(this.createJWTToken(token))
    }

    createJWTToken(token: string) {
        return 'Bearer ' + token
    }


    logout() {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (user === null) return false
        return true
    }

    getLoggedInUserName() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (user === null) return ''
        return user
    }
}

export default new AuthenticationService();