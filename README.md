# ⚽ MUNDIAL SCORE - Backend

API REST para sistema de apuestas de marcadores del Mundial 2026

## 🚀 Inicio Rápido

### Prerrequisitos
- Java 17 o superior
- PostgreSQL 12 o superior
- Maven 3.6+

### Configuración de Base de Datos

1. Crea una base de datos PostgreSQL:
```sql
CREATE DATABASE mundialscore;
```

2. Configura las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mundialscore
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

3. Ejecuta los scripts SQL en este orden:
   - `src/main/java/com/example/mundialscore/sql/database_setup.sql`
   - `src/main/java/com/example/mundialscore/sql/usuarios_iniciales.sql`
   - `src/main/java/com/example/mundialscore/sql/partidos_mundial_2026.sql`

### Ejecutar el Proyecto

```bash
# Con Maven Wrapper (recomendado)
./mvnw spring-boot:run

# O con Maven instalado
mvn spring-boot:run
```

El servidor estará corriendo en `http://localhost:8080`

## 📡 Endpoints Principales

### Autenticación
- `POST /api/auth/register` - Registrar nuevo usuario
- `GET /api/auth/me` - Obtener usuario autenticado

### Partidos
- `GET /api/partidos/grupo/{grupo}/fecha/{fecha}` - Partidos por grupo y fecha
- `PUT /api/partidos/{id}/resultado` - Actualizar resultado (Admin)

### Pronósticos
- `POST /api/pronosticos` - Crear/actualizar pronóstico
- `GET /api/pronosticos/puntos` - Ver mis puntos
- `GET /api/pronosticos/pronosticos-usuario` - Mis pronósticos
- `GET /api/pronosticos` - Todos los pronósticos (Admin)

### Ranking
- `GET /api/ranking` - Tabla de posiciones

## 🔐 Autenticación

El API usa **HTTP Basic Authentication**. En cada petición incluye:

```
Authorization: Basic {base64(email:contraseña)}
```

### Usuarios Precargados

**Administradores:**
- carlos.angarita@mundial.com / admin123
- admin@mundial.com / admin123

**Usuarios de prueba:**
- juan.perez@mundial.com / user123
- maria.garcia@mundial.com / user123

## 🏗️ Estructura del Proyecto

```
src/main/java/com/example/mundialscore/
├── config/               # Configuraciones (CORS, Security, OpenAPI)
├── controller/           # Controladores REST
├── dto/                  # Data Transfer Objects
├── entity/              # Entidades JPA
├── repository/          # Repositorios Spring Data
├── security/            # Servicios de seguridad
├── service/             # Lógica de negocio
└── sql/                 # Scripts de base de datos
```

## 🎯 Sistema de Puntuación

La lógica de cálculo de puntos está en `ServicioPuntuacion.java`:

- **5 puntos:** Resultado exacto
- **3 puntos:** Acierta ganador o empate
- **1 punto:** Acierta goles de algún equipo
- **0 puntos:** No acierta

## 🛠️ Tecnologías

- **Java 17**
- **Spring Boot 3**
- **Spring Security** (Basic Auth)
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **SpringDoc OpenAPI** (Swagger)

## 📚 Documentación API

Accede a la documentación interactiva en:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/api-docs`

## 🔧 CORS

El backend acepta peticiones desde:
- `http://localhost:5173` (Vite dev)
- `http://localhost:3000` (React dev alternate)

Configurable en `CorsConfig.java`

---

### Desarrollado Por:
- Valerie De los Ángeles Sierra Pabón
- Raúl David Báez Suárez
