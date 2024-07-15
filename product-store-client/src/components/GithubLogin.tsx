const GitHubLogin = () => {
    const loginWithGitHub = () => {
        window.location.href = `http://localhost:8081/oauth2/authorization/github`;
    };

    return (
        <button onClick={loginWithGitHub}>Login with GitHub</button>
    );
};

export default GitHubLogin;