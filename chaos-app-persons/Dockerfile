FROM openjdk:8-jdk-alpine
MAINTAINER Dominik Kesim <dominik.kesim@novatec-gmbh.de>
ARG JAR_FILE
COPY ./build/libs/chaos-app-persons-0.0.1-SNAPSHOT.jar /usr/src/chaos-app-persons/
ADD ./build/libs/chaos-app-persons-0.0.1-SNAPSHOT.jar /usr/src/chaos-app-persons/
WORKDIR /usr/src/chaos-app-persons/
EXPOSE 8081
CMD ["java", "-jar", "chaos-app-persons-0.0.1-SNAPSHOT.jar"]