# Utiliser une image de base Maven
FROM maven:3.8.3-openjdk-11-slim AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier pom.xml dans le répertoire de travail
COPY pom.xml .

# Copier les autres fichiers source dans le répertoire de travail
COPY src ./src

# Compiler le projet Maven
RUN mvn clean install

# Utiliser une image de base OpenJDK pour l'exécution
FROM openjdk:11-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers de construction à partir de l'étape précédente
COPY --from=build /app/target/nom-du-jar.jar .

# Exécuter le jar
CMD ["java", "-jar", "nom-du-jar.jar"]