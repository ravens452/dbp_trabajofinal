<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="css/Registrar.css">
<script src = "registrar.js"></script>
<title>Crear</title>
<style>


</style>
</head>
<body>

<div class="box">
    <h1 style="text-align: center;">Registro de Estudiante</h1>
    <form id = "form" name ="form" form action="estudiante" method="post" onsubmit="return cuiestructura(inputtxt)" onsubmit="return nombresLetter(inputtxt)" onsubmit="return apellidosLetter(inputtxt)" onsubmit="return  correoLetter(inputtxt)" onsubmit="return validar(cui,nombres,apellidos,correo)" > 
    <input type="hidden" name="opcion" value="guardar">
            
                Cui:<br>
                <input type="number" style="background-color: #003A83; color: #ffffff;" name="cui"><br>            
                
        <br>Nombre:<br>
                <input type="text" style="background-color: #003A83; color: #ffffff;" name="nombres"><br>           
                
        <br>Apellido:<br>
                <input type="text" style="background-color: #003A83; color: #ffffff;" name="apellidos"><br>
                
        <br>Correo:<br>
                <input type="text" style="background-color: #003A83; color: #ffffff;" name="correo"><br><br>

        <br><input type="submit" value="Guardar Registro">
    </form>
</div>

</body>
</html>