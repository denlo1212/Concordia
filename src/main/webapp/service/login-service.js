// import Link from 'Link';

export default class LoginService {

    link = "/concordia"

    isLoggedIn() {
        const token = localStorage.getItem("token")
        return !!token;
    }

    login(username, password) {
        return fetch(`${this.link}/login`, {
            method: 'POST',
            body: JSON.stringify({ username, password }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
        }).then(response => {
            if (response.ok) {
                return response.json();
            } else {

                throw new Error('Invalid username or password');
            }
        })

    }

    getUser() {
        // TODO: Implement logic to fetch user information using a GET request
        const token = localStorage.getItem("token");
        return fetch(`${this.link}/login`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
        })
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
                else {

                    return response;
                }
            })
            .catch(error => {
                return Promise.reject(error);
            });
    }

    logout() {
        localStorage.removeItem("token");
        return Promise.resolve();
    }
}
