pipeline {
    agent any

    tools {
        // Ensure 'Maven 3' and 'JDK 17' match your Jenkins Global Tool Configuration names
        maven 'Maven 3.9.6' 
        jdk 'JDK 17'
    }

    environment {
        // dynamic variable to name the artifact
        APP_NAME = 'calculator-app'
    }

    stages {
        stage('Checkout') {
            steps {
                // Jenkins automatically checks out source code in Multibranch pipelines
                // but this print confirms the branch
                echo "Checking out branch: ${env.BRANCH_NAME}"
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling Java Calculator...'
                sh 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Running Calculator Logic Tests...'
                // runs tests and generates reports
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging Calculator JAR...'
                // skips tests here since we just ran them
                sh 'mvn package -DskipTests'
            }
        }

        stage('Release') {
            // Only release if the build is on the 'main' branch
            when {
                branch 'main'
            }
            steps {
                echo 'Simulating Release/Deploy...'
                // Example: sh 'mvn deploy'
            }
        }
    }

    post {
        always {
            // 1. Capture Test Results (JUnit) so Jenkins creates a trend graph
            junit '**/target/surefire-reports/*.xml'
            
            // 2. Archive the built Artifact (.jar file) so you can download it from Jenkins UI
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        failure {
            echo "Calculator build failed on branch: ${env.BRANCH_NAME}"
        }
    }
}
