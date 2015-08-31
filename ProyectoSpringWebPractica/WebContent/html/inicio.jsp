<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Formulario Registro</title>

<script type="text/javascript">

var xmlHttp = new XMLHttpRequest();

function llamadaRest()
{
	var name = document.getElementById("nombre").value;
	var age = document.getElementById("edad").value;
	var description = document.getElementById("descripcion").value;
	
	var persona = {
		    nombre:name,
		    edad:age, 
		    descripcion:description
		};
	
	xmlHttp.onreadystatechange = procesarEvento; //indico que funcion es el punto de vuelta
	xmlHttp.open('PUT', 'personaJSONPUT', true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
			
	xmlHttp.setRequestHeader('Accept', 'application/json'); //indicamos que aceptamos el tipo mime json
	xmlHttp.setRequestHeader('Content-Type', 'application/json'); // definiendo el formato del contenido del body, en �ste caso json
	xmlHttp.send(JSON.stringify(persona)); //hago la llamada y como par�metro le envio el objeto persona representado en json (serializar), en el body
	// JSON.stringify lo que hace es convertir el objeto en mensaje json.
}

function procesarEvento()
{
   
  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
  {
      if(xmlHttp.status==200)// y el c�digo de la cabecera http es bueno
          {
    	  	muestraPersona(xmlHttp.responseText); // el body de la respuesta en texto plano
          }
      else
      {
          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
          // window.location (http:/localhost:8090/pagina de error. html)
      }
  }

}

function muestraPersona(texto)
{
	alert("He recibido " + texto);
	var objetoJson = JSON.parse(texto); // para convertir el texto json y convertirlo en el objeto javascript
	document.getElementById("nombre").value = objetoJson.nombre;
	document.getElementById("edad").value = objetoJson.edad;
	document.getElementById("descripcion").value = objetoJson.descripcion;
	
	
}
</script>










</head>
<body>


<!--<a href="bienvenido2">Pincha aqui</a>

 la peticion generada ser�: http://localhost:8090/ProyectoSpringWeb/html/bienvenido2 -->
<!-- 
<a href="../bienvenido2">Pincha aqui</a>
Para que la peticion sea http://localhost:8090/ProyectoSpringWeb/bienvenido2 -->
<!--  y asi llama al controlador y la opcion que le hemos puesto @RequestMapping("/bienvenido2") 
llamaria-->

<form action="altaPersona" method="post">
Introduce tu nombre:   <br>
<input type="text" name="nombre"/>
<br>

Introduce tu Edad:   <br>
<input type="text" name="edad"/>
<br>

Introduce tu Descripci�n:  <br>   
<textarea rows="4" cols="50" name="descripcion">
</textarea>
<br>

Foto: <br> 
<input type="file" name="file" id="" /><br>
<input type="hidden" id="fotoname">

Introduce tu DNI:   <br>
<input type="text" name="dni"/>
<br>

<input type="submit" value="enviar" class="btn"/>

</form>

</body>
</html>