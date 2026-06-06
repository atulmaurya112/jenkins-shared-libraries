def call() {
  sh '''
  docker build -t web-app:latest .
  '''
}
