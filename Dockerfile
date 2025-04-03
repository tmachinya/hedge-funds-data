# Start with Java runtime
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Add the jar file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
