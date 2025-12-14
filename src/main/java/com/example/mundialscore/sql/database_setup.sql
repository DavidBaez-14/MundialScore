-- ====================================
-- Script SQL para MundialScore Database
-- PostgreSQL
-- ====================================

-- 1. CREAR LA BASE DE DATOS (ejecutar como superusuario)
-- DROP DATABASE IF EXISTS mundialscore;
CREATE DATABASE mundialscore;

-- Conectar a la base de datos mundialscore
\c mundialscore;

-- 2. VERIFICAR LA CONEXIÓN
SELECT current_database();

-- 3. Las tablas se crearán automáticamente por Hibernate (spring.jpa.hibernate.ddl-auto=update)
-- Pero aquí está el esquema para referencia:

-- TABLA: usuarios
-- CREATE TABLE IF NOT EXISTS usuarios (
--     id BIGSERIAL PRIMARY KEY,
--     nombre VARCHAR(255) NOT NULL,
--     email VARCHAR(255) UNIQUE NOT NULL,
--     contrasena VARCHAR(255) NOT NULL,
--     rol VARCHAR(50) NOT NULL,
--     puntos_totales INTEGER DEFAULT 0
-- );

-- TABLA: partidos
-- CREATE TABLE IF NOT EXISTS partidos (
--     id BIGSERIAL PRIMARY KEY,
--     equipo_local VARCHAR(255) NOT NULL,
--     equipo_visitante VARCHAR(255) NOT NULL,
--     goles_local INTEGER,
--     goles_visitante INTEGER,
--     finalizado BOOLEAN DEFAULT FALSE
-- );

-- TABLA: predicciones
-- CREATE TABLE IF NOT EXISTS predicciones (
--     id BIGSERIAL PRIMARY KEY,
--     usuario_id BIGINT NOT NULL REFERENCES usuarios(id),
--     partido_id BIGINT NOT NULL REFERENCES partidos(id),
--     goles_local_predichos INTEGER NOT NULL,
--     goles_visitante_predichos INTEGER NOT NULL,
--     puntos_obtenidos INTEGER DEFAULT 0,
--     UNIQUE(usuario_id, partido_id)
-- );

-- 4. VERIFICAR QUE LAS TABLAS SE CREARON
-- \dt

-- 5. VERIFICAR DATOS INICIALES (después de ejecutar la aplicación Spring Boot)
-- SELECT * FROM usuarios;
-- SELECT * FROM partidos;
-- SELECT * FROM predicciones;

-- ====================================

-- Limpiar todas las tablas (¡CUIDADO!)
-- TRUNCATE TABLE predicciones CASCADE;
-- TRUNCATE TABLE partidos CASCADE;
-- TRUNCATE TABLE usuarios CASCADE;

-- Resetear secuencias
-- ALTER SEQUENCE usuarios_id_seq RESTART WITH 1;
-- ALTER SEQUENCE partidos_id_seq RESTART WITH 1;
-- ALTER SEQUENCE predicciones_id_seq RESTART WITH 1;
