<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="css/registrar.css">
<title>Matricula</title>
</head>

<body>
<div class="box">
<h1>Matricula Laboratorio</h1>
<form action="estudiante" method="post">
    <input type="hidden" name="opcion" value="guardarM">
    
                Cui:<br>
                <input type="text" style="background-color: #003A83; color: #ffffff;" name="cui">            
                <br>Codigo Curso:<br>
                <input type="text" style="background-color: #003A83; color: #ffffff;" name="codigo_laboratorio"><br>
    <input type="submit" value="Guardar">
</form>
</div>
</body>
</html>