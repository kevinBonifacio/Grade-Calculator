# Use OpenJDK 17 as the base image
FROM openjdk:17-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the source code into the container
COPY src /app/src

# Create a directory for compiled files
RUN mkdir -p /app/bin

# Compile the Java program
RUN javac -d /app/bin $(find /app/src -name "*.java")

# Set the classpath and specify the main class to run
CMD ["java", "-cp", "/app/bin", "com.valencia.Main"]

EXPOSE 3000