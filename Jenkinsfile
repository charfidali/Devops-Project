pipeline {
    agent any

    tools {
        maven 'M2_HOME' // Utilise l'outil Maven configuré dans Jenkins
    }

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
                sh "${M2_HOME}/bin/mvn clean"
            }
        }
        stage('Compile') {
            steps {
                sh "${M2_HOME}/bin/mvn compile"
            }
        }
        stage('Testing Maven') {
            steps {
                sh "${M2_HOME}/bin/mvn -version"
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv(installationName: 'sonarserver') {
                    sh "${M2_HOME}/bin/mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar"
                }
            }
        }
    }
}
