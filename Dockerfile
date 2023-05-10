FROM eclipse-temurin:17

MAINTAINER brogrammersuz@gmail.com

COPY target/brogrammers-team-0.0.1.jar brogrammers-team-0.0.1.jar

ENTRYPOINT ["java", "-jar", "brogrammers-team-0.0.1.jar"]
