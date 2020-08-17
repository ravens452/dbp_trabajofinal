<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="listar.css">
<title>Listar</title>
<style>
.box {
        margin: auto;
  	font-size: 16px;
	text-align: center;
	padding: 200px;
	color: #ffffff;

}
.center {
  margin-left: auto;
  margin-right: auto;
}
body {
  background-image: url("Images/background.png");
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 1920px 975px;
}

</style>
</head>
<body>
<div class="box">
    <h1 style="color:#9ee000;">Listar laboratorio</h1>
    <table BORDER=2 BORDERCOLOR=BLUE class="center">
        <tr>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Codigo Laboratorio</td>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Grupo de laboratorio</td>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Codigo Curso</td>
            <td style="color:#9ee000;" > <a style="color:#ffffff;">Numero de aula </td>
        </tr>
        <c:forEach var="laboratorio" items="${lista}">
            <tr>
                <td><c:out value="${laboratorio.id}"></c:out></td>
                <td><c:out value="${laboratorio.grupo}"></c:out></td>
                <td><c:out value="${laboratorio.codigo_curso}"></c:out></td>
                <td><c:out value="${laboratorio.nro_aula}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>