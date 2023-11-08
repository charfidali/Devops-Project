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

         //sonar
 stage("MVN SONARQUBE") {
         	steps {
 	            sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
 	        }
         }


     //nexus
     stage('Nexus'){
                 steps{
                       script {
                         def nexusUsername = 'admin'
                         def nexusPassword = 'nexus'
                              sh "mvn deploy --settings /usr/share/maven/conf/settings.xml -Dusername=${nexusUsername} -Dpassword=${nexusPassword}"

                     }
                 }
             }

                stage('Building our image') { 
            steps { 
                script { 
                    sh 'docker login -u hamdiselmi -p 11945020.'
                    sh 'docker build -t hamdiselmi/kaddemf:0.0.1 .'
                }
            } 
        }
        stage('Deploy our image') { 
            steps { 
                script {
                    sh 'docker push hamdiselmi/kaddemf:0.0.1'
                }
            } 
        }
        
        stage('run docker compose') { 
            steps { 
                script { 
                    sh 'docker-compose --file docker-compose.yml up'
                }
            } 
        }
             }
 }
