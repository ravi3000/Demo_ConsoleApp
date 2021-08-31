pipeline {
agent any
    stages {
        stage('CheckOut') {
            steps {
                echo 'Hello World'
            }
        }
    }
}