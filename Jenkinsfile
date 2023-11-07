pipeline {
    agent any

stage('Testing Maven Version') {
    steps {
        sh "${MAVEN_HOME}/bin/mvn -version"
    }
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
                sh "mvn clean"
            }
        }
        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }
stage('Testing Maven Version') {
    steps {
        sh "${MAVEN_HOME}/bin/mvn -version"
    }
}
 stage('Build and Analyze') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean compile"
                withSonarQubeEnv(installationName: 'sonarserver') {
                    sh "${MAVEN_HOME}/bin/mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar"
                }
            }
        }
    }
}
