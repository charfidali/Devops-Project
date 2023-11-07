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
        stage('SonarQube Analysis'){
            steps{
                script {
                    withSonarQubeEnv(installationName: 'sonarserver') {
                        def mavenHome = tool name: 'Maven', type: 'maven'
                        sh "${mavenHome}/bin/mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar"
                    }
                }
            }
        }
       
    }
}
