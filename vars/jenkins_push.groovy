def call(String app, String tag, String username) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCredential',
        usernameVariable: 'DOCKER_USERNAME',
        passwordVariable: 'DOCKER_PASSWORD'
    )]) {
        sh """
        echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
        docker tag ${app}:${tag} ${username}/${app}:${tag}
        docker push ${username}/${app}:${tag}
        """
    }
}
