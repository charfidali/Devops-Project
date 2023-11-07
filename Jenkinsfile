pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'pulling...'
                git branch: 'product',
                url: 'https://github.com/yossrb/Devops-Project23-24.git'
            }
        }
        stage('Clean') {
            steps {
                sh "mvn clean"
            }
        }
        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Testing Maven') {
            steps {
                sh "mvn -version"
            }
        }
        stage("build & SonarQube analysis") {
            steps {
			  sh"mvn clean verify sonar:sonar \
  				-Dsonar.projectKey=devops1 \
  				-Dsonar.projectName='devops1' \
  				-Dsonar.host.url=http://http://192.168.56.2:900\
  				-Dsonar.token=sqb_4a581459a42997b2affde03b45d125b7041de69a"
		  }
	  }
       
    }
}
