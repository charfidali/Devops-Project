pipeline {
  agent any

  stages {


    stage('Artifact Construction') {
      steps {
        sh "mvn -B -DskipTests package "
      }
    }


    stage('Run Spring && MySQL Containers') {
      steps {
        script {
          sh 'docker-compose up -d'
          sh 'docker run --network=host  -d --name Devops_container yb20/spring-app:yossr'
        }
      }
    }

  }

}