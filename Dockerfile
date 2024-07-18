FROM eclipse-temurin:17-alpine as build

RUN addgroup -S spring && adduser -S spring -G spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

FROM eclipse-temurin:17-alpine as run

USER spring:spring
ENTRYPOINT ["java","-jar","/app.jar"]