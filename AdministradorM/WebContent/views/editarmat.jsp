<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar matricula</title>
</head>
<body>
<h1>Editar matricula</h1>
<form action="laboratorio" method="post">
<c:set var="matricula" value="${matricula}"> </c:set>
    <input type="hidden" name="opcion" value="editar">
    <input type="hidden" name="id" value="${matricula.codigo_curso}">
        <table border="1">
            <tr>
                <td>Cui:</td>
                <td><input type="text" name="cui" size="50" value="${matricula.cui}"></td>
            </tr>    
            <tr>
                <td>Codigo lab:</td>
                <td><input type="text" name="codigo_laboratorio" size="50" value="${matricula.codigo_laboratorio}"></td>
            </tr>    
            <tr>
                <td>Grupo:</td>
                <td><input type="text" name="grupo" size="50" value="${matricula.grupo}"></td>
            </tr>   
        </table>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>