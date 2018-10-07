pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                build 'build-pipeline'
            }
        }
        stage('Test') {
            steps {
                parallel (
                   'Unit Test' : {
                        build 'unit-test-pipeline'
                    },
                    'Integration Test' : {
                        build 'integration-test-pipeline'
                    }
                )
            }
        }
        stage('Deploy') {
            steps {
                build 'deployment-pipeline'
            }
        }
    }
}
