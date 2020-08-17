<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Laboratorio</title>
<link rel="stylesheet" href="css/registrarlab.css">
<script src = "js/registrarlab.js"></script>
</head>
<body>
<div class="box">
<h1 style="text-align: center;">Registro de Labortorio</h1>
    <form id = "form" name ="form" action="laboratorio" method="post">
    <input type="hidden" name="opcion" value="guardarLab">
        <table class="center" style=" color: #000000;">
            <tr>
                <td>Grupo:</td>
                <td><input type="text" style="background-color: #9ee000; color: #000000;" name="grupo"></td>
            </tr>
            <tr>
                <td>Codigo Curso:</td>
                <td><input type="number" style="background-color: #9ee000; color: #000000;" name="codigo_curso"></td>
            </tr>
            <tr>
                <td>Aula:</td>
                <td><input type="text" style="background-color: #9ee000; color:#000000;" name="nro_aula"></td>
            </tr>
            <tr>
                <td>Permitir Matricula:</td>
                <td><input type="text" style="background-color: #9ee000; color:#000000;" name="permitir_matricula"></td>
            </tr>
        </table>
        <input type="submit" value="Guardar">
    </form>
</div>
</div>
</body>
</html>