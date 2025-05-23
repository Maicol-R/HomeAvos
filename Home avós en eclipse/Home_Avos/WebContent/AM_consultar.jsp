<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <link rel="icon" href="images/icono2.ico">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="EstilosAM/consultaEstilos.css" type="text/css" rel="stylesheet">
        <meta charset="ISO-8859-1">
<title>Consultar Adulto Mayor</title>
</head>

<body>

<%@include file="Header.jsp" %>

<section>

<br><br>
<h1 class="titulo">Consultar Postulaci�n</h1> 
<br><br>

<form action="busca_adultoMayor" class="formulario">
    <h1 class="text">Digite el N� Documento del adulto mayor</h1>
    <input type="texto" class="Ctexto" name="Ndoc">
    <p>
    <input type="submit" class="submit" value="Enviar" name="Enviar">
     <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='AM_index_CRUD.jsp'"/>
</form>
</section>

<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
     

</body>
</html>