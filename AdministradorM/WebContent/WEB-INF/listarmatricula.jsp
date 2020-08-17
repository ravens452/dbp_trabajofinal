<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="css/listar.css">
<title>Listar Matricula</title>
</head>
<body>
    <h1>Listar Matricula</h1>
    <table BORDER=2 BORDERCOLOR=BLUE>
        <tr>
            <td>Cui Estudiante</td>
            <td>Nombres y Apellidos</td>
            <td>Correo</td>
            <td>Curso</td>
            <td>Grupo </td>
            <td>Aula </td>
        </tr>
        <c:forEach var="matricula" items="${lista}">
            <tr>
                <td><c:out value="${matricula.cui}"></c:out></td>
                <td><c:out value="${matricula.nombre}"></c:out></td>
                <td><c:out value="${matricula.correo}"></c:out></td>
                <td><c:out value="${matricula.curso}"></c:out></td>
                <td><c:out value="${matricula.grupo}"></c:out></td>
                <td><c:out value="${matricula.aula}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>