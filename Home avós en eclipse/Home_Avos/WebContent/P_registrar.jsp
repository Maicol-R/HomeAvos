<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.hogar_geriatrico"%> 

<!DOCTYPE html>
<html>
<head>
        <link rel="icon" href="images/icono2.ico">
        <link href="EstilosP/registrarP.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <meta charset="utf-8">

 <title>Registrar Plan de membresía </title>
</head>
<body>
<%@include file="Header.jsp" %>
<br><br>

<h1 class="titulo">Añadir Plan de membresía </h1> 
<br><br>

<section class="contenedor">
   <form action="registra_Planmembresia" id="formulario" method="POST">
   
   <p>
   
   <input type="text" class="Ctexto" name="codPlan" placeholder="Codigo de plan *" pattern="[0-9]{2,10}" title="Solo números" required>
   <input type="text" class="Ctexto" name="nombre" placeholder="Nombre del plan de membresia *" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{4,30}" required>
   <p>
   <input type="tel" class="Ctexto" name="duracion" placeholder="Duracion del plan de membresia  *" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{3,30}" required>
   <input type="tel" class="Ctexto" name="precio" placeholder="Precio del plan de membresia  *" pattern="[0-9]{4,10}" required>
   <p>
   <textarea class="texarea" type="text" name="descripcion" placeholder="Descripción detallada ..*" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{5,500}" required></textarea>
  </p>                 
   
   <p>

            <input class="submit" type="submit" value="Enviar" title="Enviar"/>
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='P_index_CRUD.jsp'"/>
          
        </form>
     
  </section>
  
  <%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>