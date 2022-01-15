pipeline {
    agent any
  
    stages {
        stage('Build') {
            steps {
                bat 'mvn compile' 
                echo 'Compiling Project....'
                echo 'Compiled Successfully'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
                echo 'Testing.....'
                echo 'Tested Successfully'
            }
        }
        
        stage('Install') {
            steps {
                bat 'mvn install' 
                echo 'installing Project....'
                echo 'installed Successfully'
            }
        }
    }
}