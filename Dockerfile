FROM openjdk:11-jre-slim
EXPOSE 8082
ADD target/*.jar DevOps_Project-1.0.jar
ENTRYPOINT ["java","-jar","/DevOps_Project-1.0.jar"]
