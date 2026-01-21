pipeline {
    agent any

    environment {
        SONAR_HOST_URL = "http://100.31.125.203:9000"   // మీ SonarQube URL
        SONAR_PROJECT_KEY = "devopsproject"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Velpuri88/Devopsproject.git'
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

        stage('SonarQube Scan') {
            steps {
                withCredentials([string(credentialsId: 'sonarqube-api', variable: 'SONAR_TOKEN')]) {
                    sh '''
                      sonar-scanner \
                        -Dsonar.projectKey=$SONAR_PROJECT_KEY \
                        -Dsonar.sources=. \
                        -Dsonar.host.url=$SONAR_HOST_URL \
                        -Dsonar.login=$SONAR_TOKEN
                    '''
                }
            }
        }

        stage('Trivy Scan') {
            steps {
                sh '''
                  trivy fs --exit-code 0 --severity HIGH,CRITICAL .
                '''
            }
        }
    }
}

