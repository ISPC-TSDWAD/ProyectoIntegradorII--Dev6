-- 1. Crear la base de datos
CREATE DATABASE dev6_ispc_db;

-- 2. Seleccionar la base de datos para usarla
USE dev6_ispc_db;

-- 3. Crear una tabla de prueba (opcional, para testear)
CREATE TABLE test_connection (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(255) NOT NULL,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. Insertar un dato inicial
INSERT INTO test_connection (mensaje) VALUES ('Conexión exitosa desde VS Code');

-- 5. Verificar los datos
SELECT * FROM test_connection;