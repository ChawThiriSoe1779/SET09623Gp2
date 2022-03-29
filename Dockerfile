FROM openjdk:latest
COPY ./target/gp2-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "gp2-0.1.0.3-jar-with-dependencies.jar"]