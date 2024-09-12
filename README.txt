# tesffullstack

Este proyecto incluye un servicio CRUD completo con base de datos, backend en Java Spring Boot y frontend en Angular. A continuación, se describe cómo desplegar y ejecutar cada parte del proyecto.

Índice
Base de Datos
Backend
Frontend
Base de Datos
Script de Creación
Crear la base de datos y la tabla:

Ejecuta el siguiente script SQL en tu manejador de base de datos MySQL. Este script creará la base de datos, la tabla y el usuario con los permisos necesarios.(Estan en la repo de BD)

-- Crear la base de datos
CREATE DATABASE bd_vegaMiranda;

-- Usar la base de datos
USE bd_vegaMiranda;

-- Crear la tabla
CREATE TABLE person (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  fechaNacimiento DATE,
  puesto VARCHAR(100),
  sueldo DECIMAL(10, 2)
);

-- Crear el usuario y conceder permisos
CREATE USER 'conexion'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON bd_vegaMiranda.* TO 'conexion'@'localhost';
FLUSH PRIVILEGES;


Ejecutar el script:

Ejecutar el script SQL usando herramientas como MySQL Workbench, phpMyAdmin, o desde la línea de comandos de MySQL:


Backend

Requisitos
Java 11 o superior
Maven

Instrucciones

Configurar el archivo application.properties:

Asegúrate de configurar las propiedades de conexión a la base de datos en src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/bd_vegaMiranda
spring.datasource.username=conexion
spring.datasource.password=your_password

Construir y ejecutar el proyecto:

mvn clean install
mvn spring-boot:run
Probar el API:

Puedes probar el servicio REST utilizando herramientas como Postman.

Frontend

Requisitos
Node.js
Angular CLI

Instrucciones

Instalar dependencias:

npm install
Configurar la API URL:

Asegúrate de que la URL de la API en src/environments/environment.ts apunte a la URL del backend:

typescript

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080'
};

Ejecutar el proyecto:

ng serve
Probar el frontend:

Abre tu navegador y ve a http://localhost:4200 para ver la aplicación en funcionamiento.