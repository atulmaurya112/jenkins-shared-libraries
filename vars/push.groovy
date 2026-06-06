def call() {
    withCredentials([usernamePassword(
            credentialsId: 'dockerHubCredential',
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )]) {
        sh '''
        echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
        docker tag web-app:latest atulmaurya112/web-app:latest
        docker push atulmaurya112/web-app:latest
        '''   
    }
}
