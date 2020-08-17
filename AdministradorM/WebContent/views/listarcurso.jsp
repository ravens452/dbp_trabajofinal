<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="css/listar.css">
<title>Listar Curso</title>
<link rel="stylesheet" href="listarcurso.css">
</head>
<body>
<div class="box">
    <h1 style="color:#9ee000;">Listar Curso</h1>
    <table BORDER=2 BORDERCOLOR=BLUE class="center">
        <tr>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Codigo del Curso</td>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Nombre del Curso</td>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Descripcion</td>
        </tr>
        <c:forEach var="curso" items="${lista}">
            <tr>
                <td><c:out value="${curso.codigo}"></c:out></td>
                <td><c:out value="${curso.nombre}"></c:out></td>
                <td><c:out value="${curso.descripcion}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
