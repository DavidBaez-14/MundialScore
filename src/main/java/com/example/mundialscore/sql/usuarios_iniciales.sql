-- =====================================================
-- USUARIOS INICIALES - MUNDIAL 2026
-- =====================================================
-- IMPORTANTE: Las contraseñas están encriptadas con BCrypt
-- Contraseñas en texto plano (solo para referencia):
-- - Administradores: admin123
-- - Usuarios: user123
-- =====================================================

-- =====================================================
-- ADMINISTRADORES
-- =====================================================

-- Admin 1: Carlos Angarita
INSERT INTO usuarios (nombre, email, contrasena, rol, puntos_totales) VALUES
('Carlos Angarita', 'carlos.angarita@mundial.com', '$2a$10$o5Gs.QqnEXqCfnodjGiV1uns4WvaDHUq461o4bROwaGKQjA8GeDFS', 'ROLE_ADMIN', 0);

-- Admin 2: Admin de Pruebas
INSERT INTO usuarios (nombre, email, contrasena, rol, puntos_totales) VALUES
('Administrador', 'admin@mundial.com', '$2a$10$o5Gs.QqnEXqCfnodjGiV1uns4WvaDHUq461o4bROwaGKQjA8GeDFS', 'ROLE_ADMIN', 0);

-- =====================================================
-- USUARIOS ESTÁNDAR
-- =====================================================

-- Usuario 1: Juan Pérez
INSERT INTO usuarios (nombre, email, contrasena, rol, puntos_totales) VALUES
('Juan Pérez', 'juan.perez@mundial.com', '$2a$10$hX941nOQAXW25SnKKhFXEORaX7aIJDAQ.8vm4vNlbLjP5WHMfi2C6', 'ROLE_USER', 0);

-- Usuario 2: María García
INSERT INTO usuarios (nombre, email, contrasena, rol, puntos_totales) VALUES
('María García', 'maria.garcia@mundial.com', '$2a$10$hX941nOQAXW25SnKKhFXEORaX7aIJDAQ.8vm4vNlbLjP5WHMfi2C6', 'ROLE_USER', 0);

-- =====================================================
-- CREDENCIALES DE ACCESO
-- =====================================================
/*
ADMINISTRADORES:
- Email: carlos.angarita@mundial.com | Contraseña: admin123
- Email: admin@mundial.com           | Contraseña: admin123

USUARIOS:
- Email: juan.perez@mundial.com      | Contraseña: user123
- Email: maria.garcia@mundial.com    | Contraseña: user123

NOTA: - Los demás usuarios serán creados desde el frontend o mediante API (Swagger o Postman).
 - Las contraseñas están encriptadas con BCrypt, si no funcionan ejecutar GeneradorContraseñas.java
*/
