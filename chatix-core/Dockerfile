FROM openjdk:21-jdk-slim
FROM gradle:latest
COPY . .
RUN chmod +x gradlew
RUN gradle clean build --no-daemon
CMD java -jar build/libs/*.jar


