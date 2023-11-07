pipeline {
     agent any

     stages {
         stage('Checkout GIT') {
             steps {
                 echo 'Pulling...'
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

<<<<<<< HEAD
         //sonar
 stage("MVN SONARQUBE") {
         	steps {
 	            sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
 	        }
         }
     }
 }
=======
        //sonar
stage("MVN SONARQUBE") {
        	steps {
	            sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
	        }
        }
    }
}
>>>>>>> 25229e1ac42eb9270bcfccc6c767bd40c05b3775
