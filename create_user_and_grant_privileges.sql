-- Crear el usuario con todos los permisos sobre la base de datos
CREATE USER 'conexion'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON bd_vegaMiranda.* TO 'conexion'@'localhost';
FLUSH PRIVILEGES;
