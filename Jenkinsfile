pipeline {
  agent any

  stages {


    
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