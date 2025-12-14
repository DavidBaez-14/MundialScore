-- =====================================================
-- PARTIDOS FASE DE GRUPOS - MUNDIAL 2026
-- 12 Grupos (A-L) con 4 equipos cada uno
-- 3 Fechas por grupo
-- Total: 72 partidos
-- Basado en el fixture oficial de FIFA
-- =====================================================

-- =====================================================
-- GRUPO A: México (Anfitrión), Sudáfrica, República de Corea, Dinamarca
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('México', 'Sudáfrica', false, NULL, NULL, 'A', 1, 'GRUPOS'),
('República de Corea', 'Dinamarca', false, NULL, NULL, 'A', 1, 'GRUPOS'),
-- Fecha 2
('Dinamarca', 'Sudáfrica', false, NULL, NULL, 'A', 2, 'GRUPOS'),
('México', 'República de Corea', false, NULL, NULL, 'A', 2, 'GRUPOS'),
-- Fecha 3
('Dinamarca', 'México', false, NULL, NULL, 'A', 3, 'GRUPOS'),
('Sudáfrica', 'República de Corea', false, NULL, NULL, 'A', 3, 'GRUPOS');

-- =====================================================
-- GRUPO B: Canadá (Anfitrión), Italia, Catar, Suiza
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Canadá', 'Italia', false, NULL, NULL, 'B', 1, 'GRUPOS'),
('Catar', 'Suiza', false, NULL, NULL, 'B', 1, 'GRUPOS'),
-- Fecha 2
('Suiza', 'Italia', false, NULL, NULL, 'B', 2, 'GRUPOS'),
('Canadá', 'Catar', false, NULL, NULL, 'B', 2, 'GRUPOS'),
-- Fecha 3
('Suiza', 'Canadá', false, NULL, NULL, 'B', 3, 'GRUPOS'),
('Italia', 'Catar', false, NULL, NULL, 'B', 3, 'GRUPOS');

-- =====================================================
-- GRUPO C: Brasil, Marruecos, Haití, Escocia
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Brasil', 'Marruecos', false, NULL, NULL, 'C', 1, 'GRUPOS'),
('Haití', 'Escocia', false, NULL, NULL, 'C', 1, 'GRUPOS'),
-- Fecha 2
('Brasil', 'Haití', false, NULL, NULL, 'C', 2, 'GRUPOS'),
('Escocia', 'Marruecos', false, NULL, NULL, 'C', 2, 'GRUPOS'),
-- Fecha 3
('Escocia', 'Brasil', false, NULL, NULL, 'C', 3, 'GRUPOS'),
('Marruecos', 'Haití', false, NULL, NULL, 'C', 3, 'GRUPOS');

-- =====================================================
-- GRUPO D: Estados Unidos (Anfitrión), Paraguay, Australia, Rumania
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Estados Unidos', 'Paraguay', false, NULL, NULL, 'D', 1, 'GRUPOS'),
('Australia', 'Rumania', false, NULL, NULL, 'D', 1, 'GRUPOS'),
-- Fecha 2
('Estados Unidos', 'Australia', false, NULL, NULL, 'D', 2, 'GRUPOS'),
('Rumania', 'Paraguay', false, NULL, NULL, 'D', 2, 'GRUPOS'),
-- Fecha 3
('Rumania', 'Estados Unidos', false, NULL, NULL, 'D', 3, 'GRUPOS'),
('Paraguay', 'Australia', false, NULL, NULL, 'D', 3, 'GRUPOS');

-- =====================================================
-- GRUPO E: Alemania, Curazao, Costa de Marfil, Ecuador
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Alemania', 'Curazao', false, NULL, NULL, 'E', 1, 'GRUPOS'),
('Costa de Marfil', 'Ecuador', false, NULL, NULL, 'E', 1, 'GRUPOS'),
-- Fecha 2
('Alemania', 'Costa de Marfil', false, NULL, NULL, 'E', 2, 'GRUPOS'),
('Ecuador', 'Curazao', false, NULL, NULL, 'E', 2, 'GRUPOS'),
-- Fecha 3
('Ecuador', 'Alemania', false, NULL, NULL, 'E', 3, 'GRUPOS'),
('Costa de Marfil', 'Curazao', false, NULL, NULL, 'E', 3, 'GRUPOS');

-- =====================================================
-- GRUPO F: Países Bajos, Japón, Polonia, Túnez
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Países Bajos', 'Japón', false, NULL, NULL, 'F', 1, 'GRUPOS'),
('Polonia', 'Túnez', false, NULL, NULL, 'F', 1, 'GRUPOS'),
-- Fecha 2
('Países Bajos', 'Polonia', false, NULL, NULL, 'F', 2, 'GRUPOS'),
('Túnez', 'Japón', false, NULL, NULL, 'F', 2, 'GRUPOS'),
-- Fecha 3
('Japón', 'Polonia', false, NULL, NULL, 'F', 3, 'GRUPOS'),
('Túnez', 'Países Bajos', false, NULL, NULL, 'F', 3, 'GRUPOS');

-- =====================================================
-- GRUPO G: Bélgica, Egipto, Irán, Nueva Zelanda
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Bélgica', 'Egipto', false, NULL, NULL, 'G', 1, 'GRUPOS'),
('Irán', 'Nueva Zelanda', false, NULL, NULL, 'G', 1, 'GRUPOS'),
-- Fecha 2
('Bélgica', 'Irán', false, NULL, NULL, 'G', 2, 'GRUPOS'),
('Nueva Zelanda', 'Egipto', false, NULL, NULL, 'G', 2, 'GRUPOS'),
-- Fecha 3
('Nueva Zelanda', 'Bélgica', false, NULL, NULL, 'G', 3, 'GRUPOS'),
('Irán', 'Egipto', false, NULL, NULL, 'G', 3, 'GRUPOS');

-- =====================================================
-- GRUPO H: España, Cabo Verde, Arabia Saudí, Uruguay
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('España', 'Cabo Verde', false, NULL, NULL, 'H', 1, 'GRUPOS'),
('Arabia Saudí', 'Uruguay', false, NULL, NULL, 'H', 1, 'GRUPOS'),
-- Fecha 2
('España', 'Arabia Saudí', false, NULL, NULL, 'H', 2, 'GRUPOS'),
('Uruguay', 'Cabo Verde', false, NULL, NULL, 'H', 2, 'GRUPOS'),
-- Fecha 3
('Uruguay', 'España', false, NULL, NULL, 'H', 3, 'GRUPOS'),
('Arabia Saudí', 'Cabo Verde', false, NULL, NULL, 'H', 3, 'GRUPOS');

-- =====================================================
-- GRUPO I: Francia, Senegal, Bolivia, Noruega
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Francia', 'Senegal', false, NULL, NULL, 'I', 1, 'GRUPOS'),
('Bolivia', 'Noruega', false, NULL, NULL, 'I', 1, 'GRUPOS'),
-- Fecha 2
('Francia', 'Bolivia', false, NULL, NULL, 'I', 2, 'GRUPOS'),
('Noruega', 'Senegal', false, NULL, NULL, 'I', 2, 'GRUPOS'),
-- Fecha 3
('Noruega', 'Francia', false, NULL, NULL, 'I', 3, 'GRUPOS'),
('Senegal', 'Bolivia', false, NULL, NULL, 'I', 3, 'GRUPOS');

-- =====================================================
-- GRUPO J: Argentina, Argelia, Austria, Jordania
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Argentina', 'Argelia', false, NULL, NULL, 'J', 1, 'GRUPOS'),
('Austria', 'Jordania', false, NULL, NULL, 'J', 1, 'GRUPOS'),
-- Fecha 2
('Argentina', 'Austria', false, NULL, NULL, 'J', 2, 'GRUPOS'),
('Jordania', 'Argelia', false, NULL, NULL, 'J', 2, 'GRUPOS'),
-- Fecha 3
('Jordania', 'Argentina', false, NULL, NULL, 'J', 3, 'GRUPOS'),
('Austria', 'Argelia', false, NULL, NULL, 'J', 3, 'GRUPOS');

-- =====================================================
-- GRUPO K: Portugal, República Del Congo, Uzbekistán, Colombia
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Portugal', 'República Del Congo', false, NULL, NULL, 'K', 1, 'GRUPOS'),
('Uzbekistán', 'Colombia', false, NULL, NULL, 'K', 1, 'GRUPOS'),
-- Fecha 2
('Portugal', 'Uzbekistán', false, NULL, NULL, 'K', 2, 'GRUPOS'),
('Colombia', 'República Del Congo', false, NULL, NULL, 'K', 2, 'GRUPOS'),
-- Fecha 3
('Colombia', 'Portugal', false, NULL, NULL, 'K', 3, 'GRUPOS'),
('República Del Congo', 'Uzbekistán', false, NULL, NULL, 'K', 3, 'GRUPOS');

-- =====================================================
-- GRUPO L: Inglaterra, Croacia, Ghana, Panamá
-- =====================================================
INSERT INTO partidos (equipo_local, equipo_visitante, finalizado, goles_local, goles_visitante, grupo, fecha, fase) VALUES
-- Fecha 1
('Inglaterra', 'Croacia', false, NULL, NULL, 'L', 1, 'GRUPOS'),
('Ghana', 'Panamá', false, NULL, NULL, 'L', 1, 'GRUPOS'),
-- Fecha 2
('Inglaterra', 'Ghana', false, NULL, NULL, 'L', 2, 'GRUPOS'),
('Panamá', 'Croacia', false, NULL, NULL, 'L', 2, 'GRUPOS'),
-- Fecha 3
('Panamá', 'Inglaterra', false, NULL, NULL, 'L', 3, 'GRUPOS'),
('Ghana', 'Croacia', false, NULL, NULL, 'L', 3, 'GRUPOS');

-- =====================================================
-- VERIFICACIONES
-- =====================================================

-- Contar partidos por grupo (debe ser 6 por cada grupo)
SELECT grupo, COUNT(*) as total_partidos 
FROM partidos 
WHERE fase = 'GRUPOS'
GROUP BY grupo 
ORDER BY grupo;

-- Contar partidos por fecha (debe ser 24 por cada fecha)
SELECT fecha, COUNT(*) as total_partidos 
FROM partidos 
WHERE fase = 'GRUPOS'
GROUP BY fecha 
ORDER BY fecha;

-- Ver todos los grupos disponibles
SELECT DISTINCT grupo FROM partidos WHERE fase = 'GRUPOS' ORDER BY grupo;

-- Total de partidos (debe ser 72)
SELECT COUNT(*) as total_partidos FROM partidos WHERE fase = 'GRUPOS';

-- Ver partidos del Grupo A como ejemplo
SELECT id, equipo_local, equipo_visitante, grupo, fecha, fase 
FROM partidos 
WHERE grupo = 'A' 
ORDER BY fecha, id;
