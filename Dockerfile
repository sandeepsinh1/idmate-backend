# Start from a lightweight OpenJDK image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from your host to the container
COPY target/idmate-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 for the Spring Boot app
EXPOSE 8080

# Run the jar file when the container starts
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
