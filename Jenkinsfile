pipeline {

  agent any   
  environment{
        DOCKERHUB_CREDENTIALS=credentials('CredentialHub')
       		}
  stages {


   stage('Cleaning the project') {
                steps {
               		 sh 'mvn clean install'
                }
   }

   	 stage('MVN compile') {
               	steps {
                	sh 'mvn compile'
                }
	}


	  stage('build'){
          	  steps{
                	sh 'mvn -B -DskipTests package'
            	  }
	 }


	  stage('SONARQUBE'){
		  steps {
			  sh"mvn clean verify sonar:sonar \
  				-Dsonar.projectKey=Myproject \
  				-Dsonar.projectName='Myproject' \
  				-Dsonar.host.url=http://192.168.33.10:9000 \
  				-Dsonar.token=sqp_c3d8ed75166a30ad97b84ad3f71903c7af37328a"
		  }
	  }

	  
  	  stage('Publish to Nexus') {
		steps {
			 script {
            				sh 'mvn deploy -Dmaven.test.skip   '
         		 }			
		}
  
	 }

	  stage('Build Docker Image') {
     		 steps {
     			   script {
      				    sh 'docker build -t ilyeshamdi/spring-app .'
       			   }
      		}
    	  }


	  stage('Login Dockerhub') {
     			 steps {

      				 sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
      			}
  	  }

    stage('Push Docker Image') {
      steps {
        sh 'docker push ilyeshamdi/spring-app'
      }
    }


	  
      }
}

