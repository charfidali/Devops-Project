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
                 scannerHome = tool name: 'SonarQubeScanner'
                
            }
            steps {
                    def scannerCmd = "${scannerHome}/bin/sonar-scanner"
                    -Dsonar.projectName=Devops \
                    -Dsonarsources=src/ \
                    
                    
                    // Run the SonarQube analysis
                    sh "${scannerCmd}"
                
            }
        }


    }
}
