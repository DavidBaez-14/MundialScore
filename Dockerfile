# Etapa 1: Build con Maven
FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descargar dependencias (se cachea esta capa)
RUN mvn dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Construir el proyecto
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Variables de entorno por defecto (pueden ser sobrescritas)
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
