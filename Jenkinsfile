pipeline {
    agent any
    
    stages {
        stage('Cleaning the project') {
            steps {
                sh "mvn -B -DskipTests clean"
            }
        }
        
        stage('Unit Tests') {
            steps {
                sh "mvn test"
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t yb20/spring-app .'
                }
            }
        }
    }
}
