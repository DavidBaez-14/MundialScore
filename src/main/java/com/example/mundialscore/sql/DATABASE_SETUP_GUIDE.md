# 🗄️ Guía de Configuración de Base de Datos PostgreSQL

## 📋 Prerrequisitos

- PostgreSQL instalado en tu máquina
- pgAdmin 4 o herramienta similar (opcional)
- Privilegios de administrador

---

## 🚀 Opción 1: Usando pgAdmin

### Paso 1: Abrir pgAdmin
1. Abre pgAdmin 4
2. Ingresa tu contraseña local

### Paso 2: Conectar al Servidor
1. En el panel izquierdo, expande "Servers"
2. Click derecho en "PostgreSQL [versión]" → "Properties"
3. Verifica que puedas conectarte

### Paso 3: Crear la Base de Datos
1. Click derecho en "Databases" → "Create" → "Database..."
2. En el campo "Database", escribe: `mundialscore`
3. En "Owner", selecciona: `postgres`
4. Click "Save"

### Paso 4: Verificar la Contraseña del Usuario postgres
La aplicación usa la contraseña `postgres` por defecto.

**Si tu contraseña es diferente:**
1. Abre el archivo `application.properties` en tu proyecto
2. Cambia la línea:
   ```properties
   spring.datasource.password=TU_CONTRASEÑA_AQUÍ
   ```

**Si quieres cambiar la contraseña de PostgreSQL:**
1. Click derecho en "PostgreSQL" → "Properties"
2. Ve a "Definition"
3. Cambia la contraseña
4. Click "Save"

### Paso 5: Verificar la Conexión
1. En el panel izquierdo, expande "Databases"
2. Deberías ver "mundialscore"
3. Click en "mundialscore" para seleccionarla

---

## 🖥️ Opción 2: Usando Terminal/CMD (Avanzado)

### Para Windows:

#### Paso 1: Abrir CMD como Administrador

#### Paso 2: Cambiar a la carpeta bin de PostgreSQL
```cmd
cd "C:\Program Files\PostgreSQL\[versión]\bin"
```
Ejemplo:
```cmd
cd "C:\Program Files\PostgreSQL\16\bin"
```

#### Paso 3: Conectar a PostgreSQL
```cmd
psql -U postgres
```
Te pedirá la contraseña del usuario postgres.

#### Paso 4: Crear la Base de Datos
```sql
CREATE DATABASE mundialscore;
```

#### Paso 5: Verificar que se creó
```sql
\l
```
Deberías ver "mundialscore" en la lista.

#### Paso 6: Conectar a la base de datos
```sql
\c mundialscore
```

#### Paso 7: Salir de psql
```sql
\q
```

---

## ⚙️ Opción 3: Usando el Script SQL Proporcionado

### Paso 1: Abrir pgAdmin Query Tool
1. En pgAdmin, selecciona tu servidor PostgreSQL
2. Click en "Tools" → "Query Tool"

### Paso 2: Cargar el Script
1. Click en el ícono de carpeta (Open File)
2. Navega a: `MundialScore/database_setup.sql`
3. Click "Open"

### Paso 3: Ejecutar el Script
1. Click en el botón "Execute/Refresh" o presiona F5
2. Verifica que aparezca el mensaje "CREATE DATABASE"

### Paso 4: Verificar
1. Refresca la lista de bases de datos
2. Deberías ver "mundialscore"

---

## 🔧 Configuración del Archivo application.properties

Asegúrate de que tu archivo tenga esta configuración:

```properties
spring.application.name=MundialScore

# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/mundialscore
spring.datasource.username=postgres
spring.datasource.password=TU_CONTRASEÑA_AQUÍ
spring.datasource.driverClassName=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# H2 Console (Disabled)
spring.h2.console.enabled=false

# Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Spring Doc / Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

**⚠️ IMPORTANTE:** Cambia `TU_CONTRASEÑA_AQUÍ` por tu contraseña real de PostgreSQL.

---


## 🚀 Ejecutar la Aplicación Spring Boot

### Paso 1: Abrir el Proyecto en VS Code
1. Abre VS Code
2. File → Open Folder
3. Selecciona la carpeta `MundialScore`

### Paso 2: Ejecutar la Aplicación

**Opción A: Con Maven Wrapper**
```cmd
cd "C:\Users\PC\Desktop\MundialWeb\MundialScore"
.\mvnw.cmd spring-boot:run
```

**Opción B: Desde VS Code**
1. Abre `MundialScoreApplication.java`
2. Click derecho → "Run Java"

### Paso 3: Verificar que inició correctamente

Deberías ver en la consola:
```
Tomcat started on port(s): 8080 (http)
Started MundialScoreApplication
```

Si ves esto: **¡LA APLICACIÓN ESTÁ CORRIENDO!**

---

## 🧪 Probar la Aplicación

### 1. Abrir Swagger UI
Abre tu navegador y ve a:
```
http://localhost:8080/swagger-ui.html
```

### 2. Probar el Endpoint de Registro
1. Expande "Autenticación"
2. Click en "POST /api/auth/register"
3. Click "Try it out"
4. Ingresa:
```json
{
  "nombre": "Test User",
  "email": "test@test.com",
  "contrasena": "test123",
  "rol": "ROLE_USER"
}
```
5. Click "Execute"
6. Deberías ver: `"Usuario registrado exitosamente"`

### 3. Ver los Partidos
1. Expande "Partidos"
2. Click en "GET /api/matches/available"
3. Click "Try it out"
4. Click en el candado 🔒 para autenticarte
5. Ingresa:
   - Username: `user1@mundial.com`
   - Password: `user123`
6. Click "Authorize"
7. Click "Execute"
---

## 🐛 Solución de Problemas Comunes

### Error: "la autentificación password falló"
**Solución:**
1. Verifica la contraseña en `application.properties`
2. Verifica que el usuario `postgres` existe
3. Intenta cambiar la contraseña de PostgreSQL

### Error: "database mundialscore does not exist"
**Solución:**
1. Crea la base de datos manualmente con pgAdmin
2. O ejecuta el script `sql/database_setup.sql`

### Error: "Port 8080 already in use"
**Solución:**
1. Cambia el puerto en `application.properties`:
```properties
server.port=8081
```

### Error: "Could not connect to PostgreSQL"
**Solución:**
1. Verifica que PostgreSQL esté corriendo (services.msc)
2. Verifica que el puerto sea 5432
3. Verifica el firewall

### Las tablas no se crean automáticamente
**Solución:**
1. Verifica que `spring.jpa.hibernate.ddl-auto=update` esté en application.properties
2. Revisa los logs de la aplicación
3. Las tablas se crean cuando inicias la app Spring Boot

---

## 📊 Verificar las Tablas Creadas

### Con pgAdmin:
1. Selecciona la base de datos "mundialscore"
2. Expande "Schemas" → "public" → "Tables"
3. Deberías ver:
   - `usuarios`
   - `partidos`
   - `pronosticos`

### Con Terminal:
```sql
psql -U postgres -d mundialscore
\dt
```

Deberías ver:
```
           List of relations
 Schema |     Name      | Type  |  Owner   
--------+---------------+-------+----------
 public | partidos      | table | postgres
 public | pronosticos   | table | postgres
 public | usuarios      | table | postgres
```

---
