<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar </title>
<link rel="stylesheet" href="registrar.css">
<script src = "registrar.js"></script>
</head>
<body>
<div class="box">
<h1 style="text-align: center;">Registro</h1>

    <form id = "form" name ="form" form action="laboratorio" method="post">
    <input type="hidden" name="opcion" value="guardar">
        <table class="center" style=" color: #ffffff;">
            <tr>
                <td>Codigo Curso:</td>
                <td><input type="number" style="background-color: #9ee000; color: #ffffff;" name="codigo"></td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" style="background-color: #9ee000; color: #ffffff;" name="nombre"></td>
            </tr>
            
            <tr>
                <td>Descripcion:</td>
                <td><input type="text" style="background-color: #9ee000; color: #ffffff;" name="descripcion"></td>
            </tr>
        </table>
        <INPUT TYPE="Button" class="button" VALUE="guardar" onClick="validar(codigo,nombre,descripcion)">
    </form>
</div>
</div>
</body>
</html>