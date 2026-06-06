def call() {
  git url:'https://github.com/atulmaurya112/test-web-app', branch: 'main'
  sh '''pwd'''
}
