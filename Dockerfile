# Use Maven with Java 21 as build image
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy source code
COPY . .

# Build the JAR
RUN mvn clean package -DskipTests

# Now create the actual image
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built JAR from the previous build stage
COPY --from=build /app/target/Resume_Builder-1.1.0.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose port 8080
EXPOSE 8080