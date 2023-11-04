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
                    def scannerHome = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    def scannerCmd = "${scannerHome}/bin/sonar-scanner"
                    
                    // Run the SonarQube analysis
                    sh "${scannerCmd}"
                }
            }
        }


    }
}
