
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/icono2.ico">
        <link href="EstilosS/modificaS.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <meta charset="utf-8">
        <title>Actualizar servicios</title>
    </head>
    
    <body>

      <%@include file="Header.jsp" %>

  
  <section>
<br><br>
<h1 class="titulo">Actualizar</h1> 
<br><br>        
   <form id="formulario" action="modifica_servicios" >
        
        <h3 class="text">CÓDIGO del servicio</h3>
        <p><input class="cod" type="text" name="codS"></p>
        <h3 class="text">En este apartado digite los nuevos datos</h3>
   <p><p>
   <input class="Ctexto" type="text" name="nom" placeholder="Nombre del servicio *">
   <input class="Ctexto" type="text" name="tiem" placeholder="Tiempo de prestación*">
   <p>
   <input class="Ctexto" type="text" name="cup" placeholder="Cupos disponibles *">
   <input class="Ctexto" type="text" name="prec" placeholder="Precio *">
   <p>
   <textarea class="textarea" type="text" name="des" placeholder="Descripcion detallada ..*"></textarea>
</p>
   
            
          <input class="submit" type="submit" value="Enviar" title="Enviar"/>
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='S_index_CRUD.jsp'"/>
          
         </section>
  
  <%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
    </body>
</html>