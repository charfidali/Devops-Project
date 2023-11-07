pipeline {

  agent any   

  stages {


   stage('MVN clean install') {
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
                	sh 'mvn install package'
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

	  
  	  stage('MAVEN deploy') {
		steps {
			 script {
            				sh 'mvn deploy -Dmaven.test.skip   '
         		 }			
		}
  
	 }



	  
      }
}

