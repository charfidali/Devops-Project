pipeline {

  agent any   

  stages {

    stage("git pull"){
            steps{
                echo 'cloning project from Git'
                git branch: 'ActivitySector', 
                url: 'https://github.com/yossrb/Devops-Project23-24.git'
                    
                }
                
            }

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
     
    stage('MAVEN deploy') {

        steps {

          script {
            sh 'mvn deploy -Dmaven.test.skip   '
          }

      }
  


  }
  
      }
}

