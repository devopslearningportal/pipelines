pipeline {
    agent any
    stages {
        stage('checkout') {
          steps {
            //TODO: Change this to your python project in git
            git 'https://github.com/TheAlgorithms/Python.git'
          }
        }
        stage('pylint') {
            steps {
                bat 'pylint -f parseable maths'
            }
        }
    }
    post {
        always {
          //Uses the Warnings Next Gen Plugin https://wiki.jenkins.io/display/JENKINS/Warnings+Next+Generation+Plugin
          script {
            def python = scanForIssues tool: pyLint()
            publishIssues issues: [python]
          }
        }
      }
}
