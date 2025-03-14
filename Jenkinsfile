pipeline {
    agent any

    environment {
        JAR_NAME = "spring-docker-demo.jar"
        IMAGE_NAME = "spring-docker-demo"
        CONTAINER_NAME = "spring-docker-demo-container"
    }

    stages {
        // Step 1: Checkout Code
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo.git'
            }
        }

        // Step 2: Build with Maven
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        // Step 3: Build Docker Image
        stage('Build Docker Image') {
            steps {
                bat """
                    docker build -t %IMAGE_NAME% .
                """
            }
        }

        // Step 4: Run Docker Container
        stage('Deploy') {
            steps {
                // Stop and remove any existing container
                bat """
                    docker stop %CONTAINER_NAME% || exit 0
                    docker rm %CONTAINER_NAME% || exit 0
                """

                // Start the new container on port 9099
                bat """
                    docker run -d -p 9099:9099 --name %CONTAINER_NAME% %IMAGE_NAME%
                """
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
    }
}
