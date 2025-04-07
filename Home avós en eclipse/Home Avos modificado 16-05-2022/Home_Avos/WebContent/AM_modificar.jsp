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
    <link href="EstilosAM/modificarEstilos.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Actualizar Adulto Mayor</title>
</head>

<body>

<%@include file="Header.jsp" %>

<section>
<br><br>
<h1 class="titulo">Modificar Postulación</h1>
<br><br>
<form action="modifica_adultoMayor" class="formulario">
<br>
   <h1 class="text">N° Documento del adulto mayor</h1>
    <input type="text" class="Cdoc" name="Ndoc" ><p>
<br>
        <h2 class="text">En este apartado digite los nuevos datos</h2>
    <input type="text" class="Ctexto" name="nombre" placeholder="Nombre(s) *">
    <input type="text" class="Ctexto" name="apellido" placeholder="Apellido(s) *">
    <p><p>
    <select name="rh" class="Cbox">
        <option>RH</option>
        <option>O+</option>
        <option>O-</option>
        <option>A+</option>
        <option>A-</option>
        <option>B+</option>
        <option>B-</option>
        <option>AB+</option>
        <option>AB-</option>
    </select>     
    <input type="date" class="Cfecha" name="fecha" placeholder="Fecha Nacimiento *"><p>
    <label class="label">Género: </label> 
    	   <input type="radio" name="genero" value="Hombre"> Hombre
           <input type="radio" name="genero" value="Mujer"> Mujer
           <p>
    <textarea type="text" class="Ctext" name="cuidados" placeholder="Cuidados especiales"></textarea>
    <p>
    <input type="submit" name="Enviar" class="submit" value="Enviar">
    <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='AM_index_CRUD.jsp'"/>
    </p>
</form>
</section>

<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>