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
            def sonarParams = "-Dsonar.projectKey=Devops -Dsonar.projectName=Devops -Dsonar.sources=src"

            // Run the SonarQube analysis with SonarQube environment
            withSonarQubeEnv(credentialsId: 'sonarqubetoken') {
                sh "${scannerCmd} ${sonarParams}"
            }
        }
    }
}




    }
}
