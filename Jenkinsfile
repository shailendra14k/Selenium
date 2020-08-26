def repo="https://shailendra14k.github.io/sample-helm-chart/"
pipeline{
		agent{
				label 'test'
		}
		stages{
				stage("Setup") {
            steps {
               
                    sh "mvn clean test"
              
            }
        }
				
				
		}

}
