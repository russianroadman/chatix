FROM gradle:latest AS build
WORKDIR /app
COPY . .
RUN gradle clean build

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]