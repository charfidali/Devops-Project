pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dali-dockerhub')
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
        stage('MAVEN build') {
            steps {
                script {
                    sh 'mvn clean install -Dmaven.test.skip package'
                }
                stash includes: '**', name: 'workspace'
            }
        }

        stage('upload to nexus'){
            steps{
                script{
                    nexusArtifactUploader artifacts: 
                        [
                            [
                                artifactId: 'DevOps_Project',
                                classifier: '',
                                file: 'target/DevOps_Project-2.1.jar', 
                                type: 'jar'
                            ]
                        ], 
                        
                        credentialsId: 'nexus-auth',
                        groupId: 'tn.esprit',
                        nexusUrl: '192.168.33.10:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'devops-release', 
                        version: '2.1'
                }
            }
            
        }
          stage('Download jar from Nexus') {
            steps {
                script {
                    def projectVersion = '2.1' // Update this version as needed
                    def nexusUrl = 'http://192.168.33.10:8081'
                    def groupId = 'tn.esprit'
                    def artifactId = 'DevOps_Project'
                    def repository = 'devops-release'
                    def artifactPath = "${groupId.replace('.', '/')}/${artifactId}/${projectVersion}/${artifactId}-${projectVersion}.jar"
                    
                    // Download the artifact from Nexus
                    sh "curl -O ${nexusUrl}/repository/${repository}/${artifactPath}"
                }
            }
        }
   stage('Build') {
    steps {
        script {
           docker.build("charfidali/devopsproject:latest", "-f Dockerfile-nexus .")
        }
    }
}

   stage('login') {
    steps {
           sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin https://index.docker.io/v1/'
    }
}

    stage('push'){
        steps {
            sh 'docker push charfidali/devopsproject:latest'
        }
    }
    stage('Email Notification'){
        steps{
        mail bcc: '', body: 'your build is successfully done', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'mohamedali.charfi@esprit.tn'
    }  }  
   
    }
}
