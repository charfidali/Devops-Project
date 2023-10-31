pipeline {

    agent any



    environment {
      sonar_credentials =''
      sonar_host = 'http://192.168.109.2:9000'
      sonar_project_key = 'Devops_Project'
   }
      stages {

        stage('MAVEN build') {

            steps {
              script {
                sh 'mvn compile '
              }

                stash includes: '**', name: 'workspace'
            }
          }
        stage('MAVEN test') {

          steps {
            script {
              sh 'mvn test '
            }

              stash includes: '**', name: 'workspace'
          }
        }
        stage('Sonar Tests') {

          steps {
            script {
              sh 'mvn sonar:sonar  \
               -Dsonar.projectKey=$sonar_project_key \
               -Dsonar.projectName=$sonar_project_key \
               -Dsonar.host.url=$sonar_host \
               -Dsonar.login=$sonar_credentials \
               -Dsonar.tests.exclusions=**/test/** \
               -Dsonar.language=java '
            }

            stash includes: '**', name: 'workspace'
          }
        }

        stage('MAVEN package') {

          steps {
            script {
              sh 'mvn clean -Dmaven.test.skip package  '
            }

            stash includes: '**', name: 'workspace'
          }
        }
        stage('MAVEN deploy') {

          steps {


            script {
              sh 'mvn deploy -Dmaven.test.skip   '
            }

            stash includes: '**', name: 'workspace'
          }
        }


    }

}