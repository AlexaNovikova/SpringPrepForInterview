BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), age int);
INSERT INTO students(name, age) VALUES
('Alexandr', 23),
('David', 22),
('Nikolay', 19),
('Anna', 19),
('Alexandra', 18),
('Pol', 19),
('Bob', 20),
('Monika', 22),
('Nick', 19),
('Veronika', 19),
('Sally', 20);


COMMIT;