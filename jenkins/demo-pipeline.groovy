pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Get the code from the Version Control System e.g., Git
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Build your project here
                echo 'Building..'
            }
        }
        
        stage('Test') {
            parallel {
                stage('Firefox') {
                    steps {
                        // Run your tests in the Firefox environment
                        echo 'Testing on Firefox..'
                    }
                }
                stage('Edge') {
                    steps {
                        // Run your tests in the Edge environment
                        echo 'Testing on Edge..'
                    }
                }
            }
        }
        
        stage('Staging') {
            steps {
                // Deploy to a staging environment
                echo 'Deploying to Staging..'
            }
        }
        
        stage('Production') {
            steps {
                // Deploy to production
                echo 'Deploying to Production..'
            }
        }
    }
    
    post {
        // Define post-build actions
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
