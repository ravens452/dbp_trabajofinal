
function cuiestructura(inputtxt)
{
  var x= /^[0-8]{8}$/ ;
  if (inputtxt.value.match(x))
 {
    alert('El CUI tiene 8 digitos');
    return true; 
 }
  else
  {
    alert('El CUI debe tener 8 digitos');
    return false;
  }
}


function nombresLetter(inputtxt)
{ 
      var letters = /^[A-Za-z\s]+$/;
      if(inputtxt.value.match(letters))
      {
      return true;
      }
      else
      {
      alert( inputtxt.name +' invalido');
      return false;
      }
}

function apellidosLetter(inputtxt)
{ 
      var letters = /^[A-Za-z\s]+$/;
      if(inputtxt.value.match(letters))
      {
      return true;
      }
      else
      {
      alert( inputtxt.name +' invalido');
      return false;
      }
}

function correoLetter(inputtxt)
{ 
      var letters = /^[A-Za-z\s]+$/;
      if(inputtxt.value.match(letters))
      {
      return true;
      }
      else
      {
      alert( inputtxt.name +' invalido');
      return false;
      }
}


function validar(cui,nombres,apellidos,correo)
{ 
 if(cuiestructura(cui) && nombresLetter(nombres) && apellidoseLetter(apellidos) && correoLetter(correo))
  {
    document.getElementById("form").submit();
    alert('Formulario enviado');
    return true;
  }
  else
   {
    alert('Formulario no enviado');
    return false;
   }  
}