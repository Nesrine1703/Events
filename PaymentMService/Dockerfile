FROM openjdk:17
EXPOSE 8085
ADD target/payment-0.0.1-SNAPSHOT.jar payment-docker.jar
ENTRYPOINT ["java", "-jar","payment-docker.jar"]