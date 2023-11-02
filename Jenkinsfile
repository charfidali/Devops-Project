stage('Checkout SCM') {
    steps {
        script {
            checkout([
                $class: 'GitSCM',
                branches: [[name: 'stockTetst']],  
                userRemoteConfigs: [[
                    url: 'https://github.com/yossrb/Devops-Project23-24.git',
                ]]
            ])
        }
    }
}
