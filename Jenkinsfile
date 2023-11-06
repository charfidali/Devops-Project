pipeline {
  agent any

  stages {
    stage('Cleaning the project') {
      steps {
        sh "mvn clean  "
      }
    }

    stage('Artifact Construction') {
      steps {
        sh "mvn -B -DskipTests package "
      }
    }

    stage('Unit Tests') {
      steps {
        sh "mvn test "
      }
    }

    stage('Code Quality Check via SonarQube') {
      steps {

        sh "  mvn clean verify sonar:sonar \
                -Dsonar.projectKey=Devops_Project \
                -Dsonar.projectName='Devops_Project' \
                -Dsonar.host.url=http://192.168.56.2:9000 \
                -Dsonar.token=sqp_bd4017627f662b527cd60ffbf17f05d02fea6717"
      }
    }

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