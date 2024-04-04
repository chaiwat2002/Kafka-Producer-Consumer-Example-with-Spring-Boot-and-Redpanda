FROM openjdk:17

RUN mkdir /home/app
WORKDIR /home/app

COPY target/*-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]