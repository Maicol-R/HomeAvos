<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/icono2.ico">
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="EstilosAD/buscarAD.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Administrador</title>
                
    </head>
    <body>

<%@include file="Header.jsp" %>
<br><br>
<h1 class="titulo">Consultar</h1> 
<br><br>
 <section class="contenedor">
 
        <form class="formulario" action="busca_administrador" >
              
            </select>
            <br>
            <h3 class="text">Escriba el N° Documento del administrador a consultar</h3>
            <input class="Ctexto" type="text" name="dato">
            <p>
            <input class="submit" type="submit" id="consultar" value="Buscar">
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='AD_index_CRUD.jsp'"/>
          
        </form>

  </section>    
    <%@include file="Footer.jsp" %>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
          
        
    </body>
</html>