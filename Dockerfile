FROM eclipse-temurin:17-jdk-focal AS build

ARG DIR=/app
ENV DIR=${DIR}

RUN mkdir ${DIR}
WORKDIR ${DIR}

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ${DIR}/app.jar

FROM build AS run

RUN addgroup spring
RUN useradd -g spring spring
RUN chown -R spring:spring $DIR

USER spring:spring
ENTRYPOINT ["java","-jar","app.jar"]