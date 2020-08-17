function codigoestructura(inputtxt)
{
  var x= /^[0-9]{7}$/ ;
  if (inputtxt.value.match(x))
 {
    return true; 
 }
  else
  {
    alert('El codigo debe tener 7 digitos');
    return false;
  }

}

function allLetter(inputtxt)
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


function validar(codigo,nombre,descripcion)
{ 
if(codigoestructura(codigo) && allLetter(nombre)&& allLetter(descripcion))
  {
    document.getElementById("form").submit();
    alert('Formulario enviado');
    return true;
  }
  else
   {
    return false;
   }  

}
