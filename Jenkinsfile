pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Velpuri88/Devopsproject.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Build stage running...'
            }
        }

        stage('Test') {
            steps {
                echo 'Test stage running...'
            }
        }
    }
}
