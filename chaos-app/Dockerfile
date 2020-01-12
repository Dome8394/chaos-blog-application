FROM openjdk:8-jdk-alpine
MAINTAINER Dominik Kesim <dominik.kesim@gmail.com>
ARG JAR_FILE
COPY ./build/libs/chaos-app-0.0.1-SNAPSHOT.jar /usr/src/chaos-app/
WORKDIR /usr/src/chaos-app
EXPOSE 8080
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mongo/test", "-jar", "chaos-app-0.0.1-SNAPSHOT.jar"]