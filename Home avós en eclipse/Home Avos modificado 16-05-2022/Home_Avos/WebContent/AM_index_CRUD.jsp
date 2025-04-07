<!DOCTYPE html>
<html>
<head>
     <link rel="icon" href="images/icono2.ico">
     <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="EstilosAM/indexEstilos.css" type="text/css" rel="stylesheet"/>
     <meta charset="ISO-8859-1">
<title>Index Adulto Mayor</title>
</head>
<body>

<%@include file="Header.jsp" %>
<br><br>
<section>
<h1 class="titulo">Postulación Adulto Mayor</h1>
<p class="descr">
	Seleccione una de las siguientes opciones para interactuar <br>
	con la información de sus postulaciones.
</p>

<form action="AM_consultar.jsp">
<input class="boton" type="submit" value="Consultar" name="Consultar"/>
</form>

<form action="AM_modificar.jsp">
<input class="boton" type="submit" value="Actualizar Datos" name="Modificar"/>
</form>

<form action="AM_eliminar.jsp">
<input class="boton" type="submit" value="Eliminar" name="Eliminar"/>
</form>

<form action="F_index_CRUD.jsp">
<input class="botonRegresar" type="submit" value="Volver" name="Volver"/>
</form>

<br>
<br>

<img src="images/adultoIndex.jpg" class="imagen">
</section>

<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>