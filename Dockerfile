# Définit l'image de base pour construire le projet
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins

# Copie les sources et compile l'application
COPY src ./src
RUN mvn clean package

# Définit l'image de base pour exécuter l'application
FROM openjdk:17-alpine
COPY --from=build /app/target/ubeer_back-0.0.1-SNAPSHOT.jar /app.jar
ENV PORT 8080
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]