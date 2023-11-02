pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'stockTetst']],  // Replace with your branch name
                    userRemoteConfigs: [[
                        url: 'https://github.com/yossrb/Devops-Project23-24.git',
                    ]]
                ])
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean test'
                }
            }
        }
    }
}
