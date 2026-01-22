pipeline {
    agent any

    parameters {
        string(name: 'SCENARIO', defaultValue: 'dev', description: 'Execution scenario')
    }

    stages {
        stage('Stage 1') {
            steps {
                script {
                    echo 'This whole pipeline will take ~40sec to finish.'
                    echo "Scenario: ${params.SCENARIO}"
                }
            }
        }

        stage('Parallel stages') {
            parallel {
                stage('Sequential nested stages') {
                    stages {
                        stage('Stage 2') {
                            steps {
                                script {
                                    echo 'Stage 2'
                                    sh 'sleep 20'
                                }
                            }
                        }

                        stage('Stage 3') {
                            steps {
                                script {
                                    echo 'Stage 3'
                                    sh 'sleep 20'
                                }
                            }
                        }
                    }
                }

                stage('Stage 4') {
                    steps {
                        script {
                            echo 'Stage 4'
                            sh 'sleep 20'
                        }
                    }
                }
            }
        }
    }
}
