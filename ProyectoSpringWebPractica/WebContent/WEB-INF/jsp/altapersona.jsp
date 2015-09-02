<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Formulario Registro</title>

<script type="text/javascript">

var xmlHttp = new XMLHttpRequest();
var dni="";

function llamadaDni()
{
	dni = document.getElementById("dni").value;
	
	xmlHttp.onreadystatechange = procesarEventoDNI; //indico que funcion es el punto de vuelta
	xmlHttp.open('GET', 'http://172.16.1.209:8090/Spring/calculaLetraDni?dni=' + dni, true); 
			
	xmlHttp.send(null); 
}

function procesarEventoDNI()
{
  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
  {
      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
          {
    	  	var letraDNI = xmlHttp.responseText; // el body de la respuesta en texto plano
    	  	//alert ("letra recibida: " + letraDNI);
    	  	var dnicompleto = document.getElementById("dni");
    	  	dnicompleto.value = dni + "-"+letraDNI;
          }
      else
      {
          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
          // window.location (http:/localhost:8090/pagina de error. html)
      }
  }

}

</script>

</head>
<body>
<a href="altaPersona?idioma=es"><img alt="Bandera española" src="imagenes/bandera_sp.png"></a>
<a href="altaPersona?idioma=it"><img alt="Bandera italiana" src="imagenes/bandera_it.png"></a>
<a href="altaPersona?idioma=en"><img alt="Bandera inglesa" src="imagenes/bandera_ing.png"></a>
  
  <form:form method="POST" modelAttribute="persona" enctype="multipart/form-data">
 
 
 				<spring:message code="formnombre"></spring:message>
                
                <form:input type="text" path="nombre" id="nombre"/>
                <form:errors path="nombre" class="errorsp"/><br><br>
                
                <spring:message code="formedad"></spring:message>
                
                <form:input type="text" path="edad" id="edad" />
                <form:errors path="edad" class="errorsp"/><br><br>
                
                <spring:message code="formdesc"></spring:message>
                
                <form:textarea path="descripcion" id="descripcion"/>
                <form:errors path="descripcion" class="errorsp"/><br><br>
                
                <spring:message code="formfoto"></spring:message>
                
                <form:input type="file" path="foto" id="foto" name="file"/>
                            
                <spring:message code="formdni"></spring:message>
                
                <form:input type="text" path="dni" id="dni" onblur="llamadaDni()"/>
                <form:errors path="dni" class="errorsp"/><br><br>
    
                <input type="submit" value="Registrar" >
    </form:form>







</body>
</html>

<!--<a href="bienvenido2">Pincha aqui</a>

 la peticion generada será: http://localhost:8090/ProyectoSpringWeb/html/bienvenido2 -->
<!-- 
<a href="../bienvenido2">Pincha aqui</a>
Para que la peticion sea http://localhost:8090/ProyectoSpringWeb/bienvenido2 -->
<!--  y asi llama al controlador y la opcion que le hemos puesto @RequestMapping("/bienvenido2") 
llamaria-->
<!-- OTRA VERSION DE FORMULARIO 

<form action="altaPersona" method="post">
Introduce tu nombre:   <br>
<input type="text" name="nombre"/>
<br>

Introduce tu Edad:   <br>
<input type="text" name="edad"/>
<br>

Introduce tu Descripción:  <br>   
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
FIN OTRA VERSION DEL FORMULARIO -->

