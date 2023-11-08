FROM openjdk:8-jdk-alpine
EXPOSE 8085
ADD target/*.jar DevOps_Project-1.0.jar
ENTRYPOINT ["java","-jar","/DevOps_Project-1.0.jar"]