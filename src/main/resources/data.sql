

INSERT INTO COURSE (id, name, teacher_name) VALUES
(1, 'Matemáticas Avanzadas', 'Dr. Juan Pérez'),
(2, 'Programación en Java', 'Ing. Ana García'),
(3, 'Bases de Datos', 'Lic. Carlos López');

-- Insertar usuarios
INSERT INTO USUARIOS (id, last_name, name) VALUES
(1, 'González', 'María'),
(2, 'Rodríguez', 'Pedro'),
(3, 'Martínez', 'Laura');

-- Establecer relaciones entre usuarios y cursos
INSERT INTO USER_COURSES (user_id, courses_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 1),
(3, 3);
