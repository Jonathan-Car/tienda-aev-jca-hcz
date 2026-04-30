INSERT INTO categorias (nombre, descripcion, imagen) VALUES
    ('Portátiles', 'Ordenadores portátiles para trabajo, gaming y uso doméstico.', 'portatilDell.png'),
    ('Periféricos', 'Teclados, ratones, monitores y otros accesorios esenciales.', 'perifericos.png'),
    ('Componentes', 'Placas base, procesadores, memorias RAM y tarjetas gráficas.', 'tablets.png'),
    ('Almacenamiento', 'Discos duros HDD, SSD y memorias USB de alta velocidad.', 'ssd1tb.png');

INSERT INTO marcas (nombre) VALUES ('HP'), ('Logitech'), ('Asus'), ('Samsung'), ('Crucial');


INSERT INTO productos (codigo_producto, nombre, descripcion, precio, descuento, imagen, marca_id) VALUES
('8412345678901', 'Laptop Pavilion 15', 'Procesador i7, 16GB RAM, SSD 512GB', 850.00, 0, 'hp-pavilion.png', 1),
('8412345678902', 'Ratón G502 Hero', 'Sensor Hero 25K y 11 botones programables', 59.90, 0, 'g502.png', 2),
('8412345678903', 'Monitor TUF Gaming', '27 pulgadas, 144Hz, 1ms respuesta', 299.00, 0, 'asus-tuf.png', 3),
('8412345678904', 'SSD NVMe P3 Plus', '1TB de alta velocidad Gen4', 110.00, 0, 'crucial-p3.png', 5),
('8412345678905', 'Memoria RAM Pro', '16GB DDR4 3200MHz', 45.00, 0, 'ram-crucial.png', 3),
('8412345678906', 'Monitor Odyssey G5', 'Curvo, 32 pulgadas, QHD', 350.00, 0, 'samsung-g5.png', 4),
('8412345678907', 'Teclado G213', 'Resistente a salpicaduras con RGB', 65.00, 0, 'logitech-g213.png', 2),
('8412345678908', 'Laptop ROG Zephyrus', 'Gaming de alto rendimiento, RTX 4060', 1450.00, 0, 'rog-zephyrus.png', 3),
('8412345678909', 'Disco Externo T7', 'SSD portátil 1TB, USB 3.2', 95.00, 0, 'samsung-t7.png', 4),
('8412345678910', 'Ratón Inalámbrico MX', 'Productividad avanzada, multidispositivo', 105.00, 0, 'mx-master.png', 2),
('8412345678911', 'Placa Base B550', 'Socket AM4 para procesadores AMD', 130.00, 0, 'asus-b550.png', 3),
('8412345678912', 'Laptop Victus 16', 'Diseño elegante para gaming y oficina', 920.00, 0, 'hp-victus.png', 1),
('8412345678913', 'SSD SATA MX500', '2TB de almacenamiento fiable', 140.00, 0, 'crucial-mx500.png', 5),
('8412345678914', 'Auriculares G435', 'Ligeros, inalámbricos y con Dolby Atmos', 79.00, 0, 'g435.png', 2),
('8412345678915', 'Monitor Business', '24 pulgadas Full HD, ajuste de altura', 180.00, 0, 'hp-monitor.png', 1),
('8412345678916', 'Tarjeta Gráfica Dual', 'RTX 4070 con 12GB GDDR6X', 650.00, 0, 'rtx4070.png', 3),
('8412345678917', 'Pendrive Bar Plus', '128GB, cuerpo metálico resistente', 25.00, 0, 'samsung-usb.png', 4),
('8412345678918', 'Webcam C920', 'Full HD 1080p para streaming', 85.00, 0, 'logitech-c920.png', 2),
('8412345678919', 'Laptop Omen 17', 'Pantalla 17 pulgadas, máxima potencia', 1700.00, 0, 'hp-omen.png', 1),
('8412345678920', 'Micro SD EVO Select', '256GB con adaptador SD', 35.00, 0, 'samsung-microsd.png', 4);

-- Relación producto-categoria N a N
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES
    (1, 1), (2, 2), (3, 2), (4, 4), (5, 3), (8, 1), (10, 2), (13, 4), (16, 3), (19, 1);