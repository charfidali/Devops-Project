FROM openjdk:11
COPY target/*.jar monapp.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar","monapp.jar"]
