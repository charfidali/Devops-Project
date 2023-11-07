pipeline {
  agent any

  stages {
    
    stage('Publish to Nexus') {
      steps {

        sh 'mvn deploy  -DskipTests'

      }
    }

    stage('Build Docker Image') {
      steps {
        script {
          sh 'docker build -t yb20/spring-app .'
        }
      }
    }

    stage('login dockerhub') {
      steps {

        sh 'docker login -u yb20 --password dockerhub'
      }
    }

    stage('Push Docker Image') {
      steps {
        sh 'docker push yb20/spring-app'
      }
    }

    stage('Run Spring && MySQL Containers') {
      steps {
        script {
          sh 'docker-compose up -d'
          sh 'docker run --network=host  -d --name Devops_container yb20/spring-app'
        }
      }
    }

  }

}