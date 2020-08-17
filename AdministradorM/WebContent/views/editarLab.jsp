<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Laboratorio</title>
</head>
<body>
<h1>Editar Laboratorio</h1>
<form action="laboratorio" method="post">
<c:set var="laboratorio" value="${laboratorio}"> </c:set>
    <input type="hidden" name="opcion" value="editar">
    <input type="hidden" name="id" value="${laboratorio.id}">
        <table border="1">
            <tr>
                <td>Permitir Matricula:</td>
                <td><input type="text" name="permitir_matricula" size="50" value="${laboratorio.permitir_matricula}"></td>
            </tr>     
        </table>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>