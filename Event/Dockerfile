FROM openjdk:17
EXPOSE 8088
ADD target/Event-0.0.1-SNAPSHOT.jar Event-docker.jar
ENTRYPOINT ["java", "-jar","Event-docker.jar"]