-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS bd_vegaMiranda;

-- Seleccionar la base de datos
USE bd_vegaMiranda;

-- Crear la tabla person
CREATE TABLE IF NOT EXISTS person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    puesto VARCHAR(50),
    sueldo DECIMAL(10, 2)
);
