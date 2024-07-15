import { useEffect, useState } from "react";
import axios from 'axios';
import GitHubLogin from "./GithubLogin";

interface User {
    login: String
}


const LoginPage = () => {
    const [user, setUser] = useState<User>();

    useEffect(() => {
        axios.get('http://localhost:8081/api/user', { withCredentials: true })
            .then(response => {
                setUser(response.data);
            })
            .catch(error => {
                console.error('Error fetching user', error);
            });
    }, []);

    return (
        <div className="Login Page">
            <h1>GitHub OAuth Login</h1>
            {!user ? (
                <GitHubLogin />
            ) : (
                <div>Logged in as: {user.login}</div>
            )}
        </div>
    );
};

export default LoginPage;
