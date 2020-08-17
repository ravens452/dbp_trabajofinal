DROP DATABASE sistema_de_matriculas;
CREATE DATABASE sistema_de_matriculas;
USE sistema_de_matriculas;

CREATE TABLE IF NOT EXISTS estudiante
(
    cui integer,
    nombres varchar(64) not null,
    apellidos varchar(64) not null,
    correo varchar(64) not null
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS curso
(
    codigo integer,
    nombre varchar(64) not null,
    descripcion varchar(256) default null
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS aula
(
    numero char(4),
    capacidad integer not null
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS laboratorio
(
    codigo integer,
    grupo char(1),
    codigo_curso integer not null,
    numero_aula char(4) not null
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS matricula
(
    id integer,
    cui_estudiante integer not null,
    codigo_laboratorio integer not null
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE estudiante ADD PRIMARY KEY(cui);
ALTER TABLE estudiante MODIFY cui integer not null;

ALTER TABLE curso ADD PRIMARY KEY(codigo);
ALTER TABLE curso MODIFY codigo integer not null;

ALTER TABLE aula ADD PRIMARY KEY(numero);
ALTER TABLE aula MODIFY numero char(4) not null;

ALTER TABLE laboratorio ADD PRIMARY KEY(codigo);
ALTER TABLE laboratorio MODIFY codigo integer not null auto_increment;
ALTER TABLE laboratorio ADD FOREIGN KEY(codigo_curso) REFERENCES curso(codigo) ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE laboratorio ADD FOREIGN KEY(numero_aula) REFERENCES aula(numero) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE matricula ADD PRIMARY KEY(id);
ALTER TABLE matricula MODIFY id integer not null auto_increment;
ALTER TABLE matricula ADD FOREIGN KEY(cui_estudiante) REFERENCES estudiante(cui) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE matricula ADD FOREIGN KEY(codigo_laboratorio) REFERENCES laboratorio(codigo) ON DELETE CASCADE ON UPDATE CASCADE;
