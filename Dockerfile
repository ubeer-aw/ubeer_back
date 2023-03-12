# Définit l'image de base
FROM openjdk:17

# Copie l'application dans l'image Docker
COPY target/ubeer_back-0.0.1-SNAPSHOT.jar /app.jar

# Définit la variable d'environnement pour le port
ENV PORT 8080

# Expose le port
EXPOSE 8080

# Commande pour démarrer l'application
CMD ["java", "-jar", "/app.jar"]