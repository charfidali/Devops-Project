pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'product',
                url: 'https://github.com/yossrb/Devops-Project23-24.git'
            }
        }
        stage('Clean') {
            steps {
                script {
                    def mavenHome = tool name: 'Maven', type: 'maven'
                    sh "${mavenHome}/bin/mvn clean"
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    def mavenHome = tool name: 'Maven', type: 'maven'
                    sh "${mavenHome}/bin/mvn compile"
                }
            }
        }
        stage('Testing Maven') {
            steps {
                script {
                    def mavenHome = tool name: 'Maven', type: 'maven'
                    sh "${mavenHome}/bin/mvn -version"
                }
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
