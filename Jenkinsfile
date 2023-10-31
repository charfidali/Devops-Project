pipeline {

  agent any



  environment {
    sonar_credentials = credentials('jenkins-user-sonar-laforge')
    sonar_host = 'http://192.168.109.2:9000'
    sonar_project_key = 'Devops_Project'
 }
    stages {

    stages {
     stage('Checkout SCM') {
                 steps {
                     checkout([
                      $class: 'GitSCM',
                      branches: [[name: 'operator2']],
                      userRemoteConfigs: [[
                         url: 'https://github.com/yossrb/Devops-Project23-24.git',
                         credentialsId: '',
                      ]]
                     ])
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
      stage('MAVEN deploy') {

              steps {

              dockerImage= docker.build (registry,"DevOps_Project/")
                          docker.withRegistry('', registryCredential) {
                         dockerImage.push("latest")
                script {
                  sh 'docker run --network=host  -d --name devopsproject_container yb20/DevOps_Project   '
                }

                stash includes: '**', name: 'workspace'
              }
            }



  }


