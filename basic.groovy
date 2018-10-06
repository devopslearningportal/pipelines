pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'TODO: Build code here'
            }
        }
        stage('Test') {
            steps {
                echo 'TODO: Test code here'
            }
        }
        stage('Deploy') {
            steps {
                echo 'TODO: Deployment code here'
            }
        }
    }
}
