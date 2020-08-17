-- Obetener matricula
SELECT
	m.id AS NMatricula,
    m.cui_estudiante AS CUI_Matriculado,
    CONCAT(e.nombres, ' ', e.apellidos) AS Nombres,
    e.correo AS Correo,
	c.nombre AS Curso,
	lab.grupo AS Grupo, lab.numero_aula AS Aula
FROM
	(
		(
			laboratorio lab
				INNER JOIN
			curso c ON lab.codigo_curso = c.codigo
		)
			INNER JOIN
		matricula m ON m.codigo_laboratorio = lab.codigo
	)
		INNER JOIN
	estudiante e ON m.cui_estudiante = e.cui;

-- Mostrar laboratorios
SELECT
	c.codigo AS CodigoCurso,
    c.nombre AS Nombre,
    l.grupo AS Grupo,
    l.codigo AS CodigoLab,
    l.numero_aula AS NAula,
    a.capacidad AS Capacidad
FROM
	(
		laboratorio l
			INNER JOIN
		curso c ON l.codigo_curso = c.codigo
	)
		INNER JOIN
	aula a ON l.numero_aula = a.numero
ORDER BY c.nombre, l.grupo;

-- Mostrar numero de matriculados por curso y grupo
SELECT
	c.nombre AS Curso,
    l.grupo AS Grupo,
	COUNT(*) AS Matriculados
FROM
	(
		matricula m
			INNER JOIN
		laboratorio l ON m.codigo_laboratorio = l.codigo
	)
		INNER JOIN
	curso c ON l.codigo_curso = c.codigo
GROUP BY l.codigo
ORDER BY c.nombre, l.grupo;

-- Fusion de los 2 de arriba xd
SELECT
	c.codigo AS CodigoCurso,
	c.nombre AS Curso,
    l.grupo AS Grupo,
    l.codigo AS CodigoLab,
    a.numero AS Numero_de_Aula,
	SUM(IF(ISNULL(m.id), 0, 1)) AS Numero_de_Matriculados,
    a.capacidad AS Capacidad
FROM
	(
		(
			matricula m
				RIGHT JOIN
			laboratorio l ON m.codigo_laboratorio = l.codigo
		)
			INNER JOIN
		curso c ON l.codigo_curso = c.codigo
	)
		INNER JOIN
	aula a ON l.numero_aula = a.numero
GROUP BY l.codigo
ORDER BY c.nombre, l.grupo;