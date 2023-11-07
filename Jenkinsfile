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
        stage("build & SonarQube analysis") {
            agent any
                steps {
                    withSonarQubeEnv('http://192.168.56.2:9000') {
            sh 'mvn clean package sonar:sonar'
        }
    }
}
       
    }
}
