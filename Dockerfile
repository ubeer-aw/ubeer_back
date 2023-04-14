# Définit l'image de base pour construire le projet
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

# Copier le fichier pom.xml dans le répertoire de travail
COPY pom.xml .

# Copier les autres fichiers source dans le répertoire de travail
COPY src ./src

# Compile l'application
RUN mvn -B clean package

# Définit l'image de base pour exécuter l'application
FROM openjdk:17-alpine
COPY --from=build /app/target/ubeer_back-0.0.1-SNAPSHOT.jar /app.jar
ENV PORT 8080
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]