pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {

                checkout scm
            }
        }

        stage('Compilation') {
            steps {

                sh 'mvn compile'
            }
        }

        stage('SonarQube Analysis') {
            environment {
                sonar_credentials = credentials('jenkins-user-sonar-laforge')
                sonar_host = 'http://192.168.109.2:9000'
                sonar_project_key = 'Devops_Project'
            }
            steps {
                // Run SonarQube analysis
                sh 'mvn sonar:sonar \
                    -Dsonar.projectKey=$sonar_project_key \
                    -Dsonar.projectName=$sonar_project_key \
                    -Dsonar.host.url=$sonar_host \
                    -Dsonar.login=$sonar_credentials'
            }
        }

        stage('JUnit Tests') {
            steps {

                sh 'mvn test'
            }
        }
    }
}
