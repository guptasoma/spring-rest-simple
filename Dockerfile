FROM openjdk:21-jdk-slim
EXPOSE 9099
ADD target/spring-docker-demo.jar spring-docker-demo.jar
CMD ["java", "-jar","spring-docker-demo.jar"]

