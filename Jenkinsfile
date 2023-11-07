pipeline {

  agent any   
  environment{
        DOCKERHUB_CREDENTIALS=credentials('CredentialHub')
   }
	
stages {


  	 stage('Cleaning the project') {
                	steps {
               			 sh 'mvn clean'
               		 }
        }

   	 stage('MVN compile') {
               	steps {
                	sh 'mvn compile'
                }
	}


	/*stage('SONARQUBE'){
		  steps {
			  sh"mvn clean verify sonar:sonar \
  				-Dsonar.projectKey=Myproject \
 				 -Dsonar.projectName='Myproject' \
				  -Dsonar.host.url=http://192.168.33.10:9000 \
				  -Dsonar.token=sqp_515f0fb27d8940af27dfbc13c5443e9b224549fa"
		  }
	  }*/
	  
	  
	  stage('MVN build'){
          	  steps{
                	sh 'mvn -B -DskipTests package'
            	  }
	 }


	  

	  
  	/*  stage('Publish to Nexus') {
		steps {
			 script {
            				sh 'mvn deploy -Dmaven.test.skip   '
         		 }			
		}
  
	 }
*/
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
/*
    stage('Push Docker Image') {
      steps {
        sh 'docker push ilyeshamdi/spring-app'
      }
    }
*/
	  stage('DOCKER-COMPOSE'){
          
			 	steps{
             
					script{
                				    sh 'docker-compose up -d'
                		   	      }
         			      }
		 }


	  
      }
}

