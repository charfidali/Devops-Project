FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/DevOps_Project-1.0.war DevOps_Project-1.0.war
ENTRYPOINT ["java","-jar","/DevOps_Project-1.0.war"]   