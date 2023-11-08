pipeline {
  agent any

  stages {



    stage('Artifact Construction') {
      steps {
        sh "mvn -B -DskipTests package "
      }
    }



 stage('Publish to Nexus') {
      steps {

        sh 'mvn deploy  -DskipTests'

      }
    }








  }
}