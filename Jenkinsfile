pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'pulling...'
                git branch: 'product',
                url: 'https://github.com/yossrb/Devops-Project23-24.git'
            }
        }
        stage('Clean') {
            steps {
                sh "mvn clean"
            }
        }
        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Testing Maven') {
            steps {
                sh "mvn -version"
            }
        }
        stage('SonarQube Analysis') {
            steps {
                def mvn = tool 'Default Maven';
                withSonarQubeEnv('Local SonarQube') {
                    sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Devops -Dsonar.projectName='Devops'"
                }
            }
        }
    }
}
