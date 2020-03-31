FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ADD target/*.jar application.jar
ENTRYPOINT ["sh", "-c", "java -jar /application.jar]