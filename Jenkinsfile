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
            environment {
               scannerHome = tool name: 'sonarqubeScanner'
    }
            steps {
               script {
                  def scannerCmd = "${scannerHome}/bin/sonar-scanner"
                  def sonarParams = "-Dsonar.projectName=Devops -Dsonar.sources=src"
            
                  // Run the SonarQube analysis
                  sh "${scannerCmd} ${sonarParams}"
        }
    }
}



    }
}
