INSERT INTO USUARIOS (id, last_name, name) VALUES
                                               (1, 'Fernández', 'Laura'),
                                               (2, 'Pérez', 'Martín'),
                                               (3, 'González', 'Sofía'),
                                               (4, 'Gómez', 'Carlos'),
                                               (5, 'López', 'Ana'),
                                               (6, 'Díaz', 'Javier'),
                                               (7, 'Pérez', 'Lucía'),
                                               (8, 'Sánchez', 'Diego'),
                                               (9, 'Romero', 'Valentina'),
                                               (10, 'Torres', 'Fernando'),
                                               (11, 'Acosta', 'Bruno'),
                                               (12, 'Benítez', 'Camila'),
                                               (13, 'Cabrera', 'Joaquín'),
                                               (14, 'Delgado', 'Martina'),
                                               (15, 'Escobar', 'Tomás'),
                                               (16, 'Figueroa', 'Luciana'),
                                               (17, 'Gallardo', 'Agustín'),
                                               (18, 'Herrera', 'Julieta'),
                                               (19, 'Ibarra', 'Mateo'),
                                               (20, 'Jiménez', 'Isabella'),
                                               (21, 'Krause', 'Thiago'),
                                               (22, 'Luna', 'Emilia'),
                                               (23, 'Medina', 'Benjamín'),
                                               (24, 'Navarro', 'Victoria'),
                                               (25, 'Ortega', 'Valentín'),
                                               (26, 'Paredes', 'Mía'),
                                               (27, 'Quiroga', 'Dante'),
                                               (28, 'Ríos', 'Emma'),
                                               (29, 'Sosa', 'Alejo'),
                                               (30, 'Toledo', 'Amanda'),
                                               (31, 'Ulloa', 'Ciro'),
                                               (32, 'Vera', 'Lola'),
                                               (33, 'Wagner', 'Simón'),
                                               (34, 'Ximénez', 'Ámbar'),
                                               (35, 'Yáñez', 'Lautaro'),
                                               (36, 'Zárate', 'Renata'),
                                               (37, 'Almeida', 'Bautista'),
                                               (38, 'Barrios', 'Julia'),
                                               (39, 'Córdoba', 'Francisco'),
                                               (40, 'Duarte', 'Catalina');

INSERT INTO COURSE (id, name, teacher_name) VALUES
                                                (1, 'Matemáticas', 'Prof. Susana Bravo'),
                                                (2, 'Historia', 'Prof. Javier Méndez'),
                                                (3, 'Física', 'Dra. Nora Estrada'),
                                                (4, 'Inteligencia Artificial', 'Dr. Roberto Sánchez'),
                                                (5, 'Desarrollo Web Avanzado', 'Ing. Sofía Martínez'),
                                                (6, 'Seguridad Informática', 'Lic. Diego Ramírez'),
                                                (7, 'Cloud Computing', 'Ing. Laura Torres'),
                                                (8, 'Machine Learning', 'Dr. Andrés Castro'),
                                                (9, 'Desarrollo Móvil', 'Ing. Camila Rojas'),
                                                (10, 'Big Data', 'Dr. Miguel Ángel Díaz'),
                                                (11, 'Blockchain', 'Lic. Laura Ibáñez');

INSERT INTO USER_COURSES (user_id, courses_id) VALUES
                                                   (3, 9), (3, 11),                        -- Sofía: Móvil, Blockchain
                                                   (4, 4), (4, 5), (4, 6),                -- Carlos: IA, Web, Seguridad
                                                   (5, 7), (5, 8), (5, 9),                -- Ana: Cloud, ML, Móvil
                                                   (6, 10), (6, 11),                      -- Javier: Big Data, Blockchain
                                                   (7, 4), (7, 8), (7, 10),               -- Lucía: IA, ML, Big Data
                                                   (8, 5), (8, 6),                        -- Diego: Web, Seguridad
                                                   (9, 7), (9, 9),                        -- Valentina: Cloud, Móvil
                                                   (10, 8), (10, 11);                     -- Fernando: ML, Blockchain