pipeline {
  agent any

  stages {



      stage("clone frontend"){
             steps{
                 script{
                       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url:"https://github.com/yossrb/DevopsFront.git"


    ]]])
                 }
             }



         }

          stage('Build Docker Image front') {
               steps {
                 script {
                   sh 'docker build -t yb20/front-app:yossr .'
                 }
               }
             }

              stage('login dockerhub') {
                   steps {

                     sh 'docker login -u yb20 --password dockerhub'
                   }
                 }

                 stage('Push Docker Image front') {
                   steps {
                     sh 'docker push yb20/front-app:yossr'
                   }
                 }

  }
}