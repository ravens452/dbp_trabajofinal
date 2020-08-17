<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar </title>
<link rel="stylesheet" href="css/registrar.css">
<script src = "js/registrar.js"></script>
</head>
<body>
<div class="box">
<h1 style="text-align: center;">Registro Curso</h1>

    <form id = "form" name ="form" action="laboratorio" method="post">
    <input type="hidden" name="opcion" value="guardarCurso">
        <table class="center" style=" color: #000000;">
            <tr>
                <td>Codigo Curso:</td>
                <td><input type="number" style="background-color: #9ee000; color: #000000;" name="codigo"></td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" style="background-color: #9ee000; color: #000000;" name="nombre"></td>
            </tr>
            
            <tr>
                <td>Descripcion:</td>
                <td><input type="text" style="background-color: #9ee000; color: #000000;" name="descripcion"></td>
            </tr>
        </table>
        <input type="submit" value="Guardar">
    </form>
</div>
</div>
</body>
</html>