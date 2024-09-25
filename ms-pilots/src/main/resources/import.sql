-- -- Crear tabla si no existe (opcional)
-- CREATE TABLE IF NOT EXISTS pilot (
-- id BIGINT PRIMARY KEY,
-- name VARCHAR(255),
-- last_name VARCHAR(255),
-- dni VARCHAR(50),
-- address VARCHAR(255),
-- city VARCHAR(100),
-- country VARCHAR(100)
-- );

-- Insertar datos de prueba
INSERT INTO pilot (name, last_name, dni, address, city, country) VALUES ('John', 'Doe', '12345678A', '1234 Elm St', 'Springfield', 'USA')
INSERT INTO pilot (name, last_name, dni, address, city, country) VALUES ('Jane', 'Smith', '87654321B', '5678 Oak St', 'Shelbyville', 'USA')
INSERT INTO pilot (name, last_name, dni, address, city, country) VALUES ('Pedro', 'Gonzalez', '56789012C', 'Calle Falsa 123', 'Madrid', 'Spain')
INSERT INTO pilot (name, last_name, dni, address, city, country) VALUES ('Laura', 'Martinez', '09876543D', 'Av. Siempre Viva 742', 'Buenos Aires', 'Argentina')
INSERT INTO pilot (name, last_name, dni, address, city, country) VALUES ('Maria', 'Rodriguez', '11223344E', 'Rua da Alegria 45', 'Lisboa', 'Portugal')