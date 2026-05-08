INSERT INTO categorias (nombre, descripcion, imagen) VALUES
    ('Portátiles', 'Ordenadores portátiles para trabajo, gaming y uso doméstico.', 'portatilDell.png'),
    ('Periféricos', 'Teclados, ratones, monitores y otros accesorios esenciales.', 'perifericos.png'),
    ('Componentes', 'Placas base, procesadores, memorias RAM y tarjetas gráficas.', 'tablets.png'),
    ('Almacenamiento', 'Discos duros HDD, SSD y memorias USB de alta velocidad.', 'ssd1tb.png');

INSERT INTO marcas (nombre) VALUES ('HP'), ('Logitech'), ('Asus'), ('Samsung'), ('Crucial');


INSERT INTO productos (codigo_producto, nombre, descripcion, precio, descuento, stock, imagen, marca_id) VALUES

('8412345678001', 'Samsung Galaxy S24 Ultra', 'Pantalla Dynamic AMOLED, 512GB, S-Pen', 1450.00, 0, 50, 'samsung-s24.png', 4),
('8412345678002', 'Asus ROG Phone 8 Pro', 'Móvil gaming premium, Snapdragon 8 Gen 3', 1100.00, 0, 30, 'samsung-s24.png', 3),
('8412345678003', 'Samsung Galaxy Z Fold5', 'Pantalla plegable de 7.6 pulgadas', 1800.00, 0, 20, 'samsung-s24.png', 4),
('8412345678004', 'Asus Zenfone 10', 'Potencia compacta en 5.9 pulgadas', 750.00, 0, 45, 'samsung-s24.png', 3),

('8412345678005', 'HP Pavilion 15', 'Procesador i7, 16GB RAM, SSD 512GB', 850.00, 0, 100, 'rog-zephyrus.png', 1),
('8412345678006', 'Asus ROG Zephyrus G14', 'Gaming alto rendimiento, RTX 4060', 1450.00, 0, 15, 'rog-zephyrus.png', 3),
('8412345678007', 'HP Victus 16', 'Diseño elegante para gaming y oficina', 920.00, 0, 60, 'rog-zephyrus.png', 1),
('8412345678008', 'HP Omen 17', 'Pantalla 17 pulgadas, máxima potencia', 1700.00, 0, 10, 'rog-zephyrus.png', 1),
('8412345678009', 'Asus Zenbook S13 OLED', 'Ultra fino, pantalla OLED 2.8K', 1300.00, 0, 25, 'rog-zephyrus.png', 3),
('8412345678010', 'Samsung Galaxy Book4', 'Ecosistema Galaxy, Intel Core 7', 1100.00, 0, 40, 'rog-zephyrus.png', 4),

('8412345678011', 'Logitech G502 Hero', 'Sensor Hero 25K y 11 botones', 59.90, 0, 200, 'asus-tuf.png', 2),
('8412345678012', 'Logitech G213 Keyboard', 'Resistente a salpicaduras con RGB', 65.00, 0, 150, 'asus-tuf.png', 2),
('8412345678013', 'Asus TUF Gaming Monitor', '27 pulgadas, 144Hz, 1ms', 299.00, 0, 35, 'asus-tuf.png', 3),
('8412345678014', 'Logitech G435 Headset', 'Auriculares ligeros e inalámbricos', 79.00, 0, 80, 'asus-tuf.png', 2),
('8412345678015', 'Logitech C920 Webcam', 'Full HD 1080p para streaming', 85.00, 0, 95, 'asus-tuf.png', 2),
('8412345678016', 'Logitech MX Master 3S', 'Ratón profesional silencioso 8K DPI', 105.00, 0, 55, 'asus-tuf.png', 2),

('8412345678017', 'Samsung Galaxy Tab S9', 'Pantalla 11, S Pen incluido', 600.00, 0, 70, 'samsung-tab-s9.png', 4),
('8412345678018', 'Samsung Galaxy Tab A9', 'Tablet versátil para el día a día', 250.00, 0, 120, 'samsung-tab-s9.png', 4),
('8412345678019', 'Asus Vivobook Slate', 'Tablet 2 en 1 con pantalla OLED', 650.00, 0, 25, 'samsung-tab-s9.png', 3),
('8412345678020', 'Samsung Galaxy Tab S9 Ultra', 'La tablet más potente de Samsung', 1150.00, 0, 12, 'samsung-tab-s9.png', 4);

DELETE FROM productos_categorias;

-- Relación producto-categoria N a N
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES
-- Móviles
(1, 1), (2, 1), (3, 1), (4, 1),
-- Portátiles
(5, 2), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2),
-- Periféricos
(11, 3), (12, 3), (13, 3), (14, 3), (15, 3), (16, 3),
-- Tablets
(17, 4), (18, 4), (19, 4), (20, 4);


INSERT INTO roles (id, descripcion) VALUES ('ADMIN', 'Administrador');
INSERT INTO roles (id, descripcion) VALUES ('USER', 'Usuario normal');

INSERT INTO usuarios (nombre, apellidos, email, password, fecha_registro)
VALUES (
           'Admin',
           'Sistema',
           'admin@tienda.com',
           '$2a$12$E3lMGGjuK7LX7eepnJtW9e6TTGOAPnqn5ZgNatmR2f.RGENtCb55.', -- pass123
           CURRENT_TIMESTAMP
       );

INSERT INTO usuarios (nombre, apellidos, email, password, fecha_registro)
VALUES (
           'Haoye',
           'Escobar',
           'user@tienda.com',
           '$2a$12$E3lMGGjuK7LX7eepnJtW9e6TTGOAPnqn5ZgNatmR2f.RGENtCb55.', -- pass123
           CURRENT_TIMESTAMP
       );

-- Asignación de roles
-- El Admin tiene ambos roles
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 'ADMIN');
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 'USER');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2, 'USER');