FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /usr/src/app

COPY pom.xml ./

RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /usr/src/app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
