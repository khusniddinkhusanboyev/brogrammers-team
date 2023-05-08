FROM eclipse-temurin:17
WORKDIR /app

COPY target/brogrammers-team-0.0.1-SNAPSHOT.jar brogrammers-team-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/brogrammers-team-0.0.1-SNAPSHOT.jar"]
