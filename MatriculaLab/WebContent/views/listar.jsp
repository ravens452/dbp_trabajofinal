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
    <h1>Lista Estudiante</h1>
    <table BORDER=2 BORDERCOLOR=BLUE>
        <tr>
            <td>Cui</td>
            <td>Nombres</td>
            <td>Apellidos</td>
            <td>Correo</td>
        </tr>
        <c:forEach var="estudiante" items="${lista}">
            <tr>
                <td><c:out value="${estudiante.cui}"></c:out></td>
                <td><c:out value="${estudiante.nombres}"></c:out></td>
                <td><c:out value="${estudiante.apellidos}"></c:out></td>
                <td><c:out value="${estudiante.correo}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>