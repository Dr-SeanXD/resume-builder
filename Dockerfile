# Use a Java 21 JDK image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy JAR file to the container
COPY target/Resume_Builder-1.1.0.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose port 8080
EXPOSE 8080