function allLetter(inputtxt)
{ 
      var letters = /^[A-Za-z\s]+$/;
      if(inputtxt.value.match(letters))
      {
      return true;
      }
      else
      {
      alert( inputtxt.name +' invalido, no pude haber digitos');
      return false;
      }
}

function codigoestructura(inputtxt)
{
	var x= /^[0-9]+$/ ;
  	if (inputtxt.value.match(x))
 	{
    	return true; 
 	}
 	 else
  	{
	alert('Codigo invalido');
    	return false;
	}
}
function aulaestuctura(inputtxt)
{
  var x= /^[0-9]{4}$/ ;
  if (inputtxt.value.match(x))
 {
    return true; 
 }
  else
  {
    alert('El numero del aula debe tener 4 digitos');
    return false;
  }
}


function validar(id,grupo,codigo_curso,nro_aula)
{ 
if(allLetter(grupo) && codigoestructura(codigo_curso) && aulaestuctura(nro_aula))
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

