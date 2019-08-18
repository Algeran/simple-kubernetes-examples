FROM openjdk:8-jre-alpine
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=Europe/Moscow","-jar","/app.jar"]