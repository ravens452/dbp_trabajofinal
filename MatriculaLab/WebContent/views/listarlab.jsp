<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="css/listar.css">
<title>Listar</title>
</head>
<body>
    <h1>Lista Laboratorios</h1>
    <table BORDER=2 BORDERCOLOR=BLUE>
        <tr>
            <td>Codigo</td>
            <td>Nombre</td>
            <td>Codigo Curso</td>
            <td>Grupo</td>
            <td>Aula</td>
            <td>Capacidad</td>
            <td>Matriculas</td>
        </tr>
        <c:forEach var="laboratorio" items="${lista}">
            <tr>
                <td><c:out value="${laboratorio.codigo}"></c:out></td>
                <td><c:out value="${laboratorio.nombre}"></c:out></td>
                <td><c:out value="${laboratorio.codigo_curso}"></c:out></td>
                <td><c:out value="${laboratorio.grupo}"></c:out></td>
                <td><c:out value="${laboratorio.nro_aula}"></c:out></td>
                <td><c:out value="${laboratorio.capacidad}"></c:out></td>
                <!--  <td> <a href="estudiante?opcion=matricula">Matriculame</a></td> -->
                <td> <a href="estudiante?opcion=matricula&codigo=<c:out value="${laboratorio.codigo}"></c:out>"> <c:out value="${laboratorio.codigo}"></c:out>  </a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>