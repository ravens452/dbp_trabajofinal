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
<div class="box">
    <h1 style="color:#9ee000;">Listar laboratorio</h1>
    <table BORDER=2 BORDERCOLOR=BLUE class="center">
        <tr>
            <td style="color:#9ee000;" > <a style="color:#4129b0;">Codigo Laboratorio</td>
            <td style="color:#9ee000;" > <a style="color:#4129b0;">Grupo de laboratorio</td>
            <td style="color:#9ee000;" > <a style="color:#4129b0;">Codigo Curso</td>
            <td style="color:#9ee000;" > <a style="color:#4129b0;">Numero de aula </td>
            <td style="color:#9ee000;" > <a style="color:#4129b0;">Editar Acceso</td>
        </tr>
        <c:forEach var="laboratorio" items="${lista}">
            <tr>
                <td><c:out value="${laboratorio.id}"></c:out></td>
                <td><c:out value="${laboratorio.grupo}"></c:out></td>
                <td><c:out value="${laboratorio.codigo_curso}"></c:out></td>
                <td><c:out value="${laboratorio.nro_aula}"></c:out></td>
                <td> <a href="laboratorio?opcion=meditar&id=<c:out value="${ laboratorio.id}"></c:out>"> <c:out value="${laboratorio.id}"></c:out>  </a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>