FROM openjdk:17-jdk-slim as build
ADD target/brogrammers-team-0.0.1-SNAPSHOT.jar brogrammers-team-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/brogrammers-team-0.0.1-SNAPSHOT.jar"]
COPY mvnw .
COPY .mvn .mvn

#Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline.
# This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B