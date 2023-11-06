pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub_id')
        // Declare dockerImage here
        dockerImage = docker.build("charfidali/devopsProject:latest", ".")
    }
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
        stage('JUnit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool name: 'sonarqubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    def scannerCmd = "${scannerHome}/bin/sonar-scanner"
                    def sonarParams = "-Dsonar.projectKey=Devops -Dsonar.projectName=Devops -Dsonar.sources=src -Dsonar.java.binaries=target/test-classes/tn/esprit/devops_project/services"
                    // Run the SonarQube analysis with SonarQube environment
                    withSonarQubeEnv(credentialsId: 'sonarqubetoken') {
                        sh "${scannerCmd} ${sonarParams}"
                    }
                }
            }
        }
        stage('MAVEN package') {
            steps {
                script {
                    sh 'mvn clean -Dmaven.test.skip package'
                }
                stash includes: '**', name: 'workspace'
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    // Access dockerImage from the environment block
                    dockerImage.withRegistry('https://registry.hub.docker.com', DOCKERHUB_CREDENTIALS) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}

