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
    def mvn = tool 'M2_HOME';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=devops1 -Dsonar.projectName='devops1'"
    }
  }
    }
}
