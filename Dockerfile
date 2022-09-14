FROM maven:3.8.4-jdk-11-slim AS builder
COPY . /app
WORKDIR /app
RUN mvn install -DskipTests


FROM openjdk:11.0.13-jre-slim-buster
WORKDIR /root/
COPY --from=builder /app/target/backend-service.jar .
ENTRYPOINT ["java", "-jar","backend-service.jar"]
