FROM gradle:jdk11 as builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle clean bootjar

FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/project-base-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
#RUN #apt-get update && \
#    apt-get install -y mysql-client && \
#    rm -rf /var/lib/apt/lists/*
ENTRYPOINT ["java", "-jar", "/*.jar"]