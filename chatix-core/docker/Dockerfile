LABEL authors="russianroadman&jeka"

# Use an official OpenJDK runtime as a base image
FROM openjdk:21-ea-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container (adjust path if necessary)
COPY target/app.jar app.jar

# Expose the port your app uses
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
