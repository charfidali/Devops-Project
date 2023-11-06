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

        stage('testing Maven') {
            steps {
                sh "mvn -version"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install sonar:sonar'
                }
            }
        }

        stage('Maven Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }
    }
}
