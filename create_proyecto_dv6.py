-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS proyecto_DV6;

-- Usar la base de datos
USE proyecto_DV6;

-- -----------------------------------------------------
-- Tabla `usuarios`
-- Guarda la información de los usuarios que pueden poseer archivos.
-- Normalización: Datos de usuario centralizados.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) UNIQUE,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------
-- Tabla `tipos_archivo`
-- Guarda los tipos de extensiones de archivo (ej. pdf, docx, jpg).
-- Normalización: Evita la redundancia de la cadena del tipo de archivo en la tabla 'archivos'.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipos_archivo (
    id_tipo INT AUTO_INCREMENT PRIMARY KEY,
    extension VARCHAR(10) NOT NULL UNIQUE, -- ej. 'pdf', 'docx', 'jpg'
    descripcion VARCHAR(100)
);

-- -----------------------------------------------------
-- Tabla `categorias_archivo`
-- Guarda las categorías a las que puede pertenecer un archivo (ej. Finanzas, Marketing).
-- Normalización: Evita la redundancia del nombre de la categoría en la tabla 'archivos'.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categorias_archivo (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- -----------------------------------------------------
-- Tabla `archivos`
-- Guarda los detalles de cada archivo.
-- Utiliza claves foráneas para referenciar metadatos de otras tablas,
-- eliminando redundancia.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS archivos (
    id_archivo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_archivo VARCHAR(255) NOT NULL,
    ruta_almacenamiento VARCHAR(500) NOT NULL, -- Ruta o URL donde se guarda el archivo
    tamano_bytes BIGINT,
    fecha_subida DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_usuario_propietario INT,
    id_tipo_archivo INT,
    id_categoria_archivo INT,
    FOREIGN KEY (id_usuario_propietario) REFERENCES usuarios(id_usuario) ON DELETE SET NULL,
    FOREIGN KEY (id_tipo_archivo) REFERENCES tipos_archivo(id_tipo) ON DELETE RESTRICT,
    FOREIGN KEY (id_categoria_archivo) REFERENCES categorias_archivo(id_categoria) ON DELETE SET NULL
);

-- -----------------------------------------------------
-- Inserción de Datos de Ejemplo
-- Para demostrar el funcionamiento y la integridad referencial.
-- -----------------------------------------------------

-- Insertar datos en `usuarios`
INSERT INTO usuarios (nombre_usuario, email) VALUES
('administrador', 'admin@example.com'),
('juanperez', 'juan.perez@dominio.com'),
('mariagarcia', 'maria.garcia@dominio.com');

-- Insertar datos en `tipos_archivo`
INSERT INTO tipos_archivo (extension, descripcion) VALUES
('pdf', 'Documento Portable'),
('docx', 'Documento de Word'),
('xlsx', 'Hoja de Cálculo de Excel'),
('jpg', 'Imagen JPEG'),
('png', 'Imagen PNG');

-- Insertar datos en `categorias_archivo`
INSERT INTO categorias_archivo (nombre_categoria, descripcion) VALUES
('Finanzas', 'Documentos relacionados con contabilidad y finanzas.'),
('Marketing', 'Materiales de marketing y publicidad.'),
('Recursos Humanos', 'Archivos de personal y RRHH.'),
('Reportes', 'Reportes generales del negocio.');

-- Insertar datos en `archivos`
-- Nota: id_usuario_propietario, id_tipo_archivo, id_categoria_archivo
-- deben corresponder a IDs existentes en sus respectivas tablas.
INSERT INTO archivos (nombre_archivo, ruta_almacenamiento, tamano_bytes, id_usuario_propietario, id_tipo_archivo, id_categoria_archivo) VALUES
('Reporte_Mensual_Q1.pdf', '/uploads/finanzas/reporte_q1.pdf', 1500000, 1, 1, 1),
('Campana_Verano.pptx', '/uploads/marketing/campana_verano.pptx', 3000000, 2, NULL, 2), -- Ejemplo con tipo no existente (NULL si permites)
('Lista_Empleados.xlsx', '/uploads/rrhh/lista_empleados.xlsx', 500000, 1, 3, 3),
('Logo_Nuevo.png', '/uploads/diseno/logo_nuevo.png', 80000, 3, 5, NULL), -- Ejemplo sin categoría
('Factura_001.pdf', '/uploads/finanzas/factura_001.pdf', 250000, 2, 1, 1);