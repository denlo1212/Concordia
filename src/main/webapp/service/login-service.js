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
                // Login successful
                return response.json();
            } else {
                // Login failed
                throw new Error('Invalid username or password');
            }
        })
            .then(data => {
                const token = data.token; // Assuming the token is returned in the response data
                localStorage.setItem('token', token);
            })
            .catch(error => {
                // Handle any errors that occur during the login process
                return Promise.reject(error);
            });
    }

    getUser() {
        // TODO: Implement logic to fetch user information using a GET request
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
                    return response.json();
                }
                else {
                    return Promise.reject('Failed to retrieve user information');
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
