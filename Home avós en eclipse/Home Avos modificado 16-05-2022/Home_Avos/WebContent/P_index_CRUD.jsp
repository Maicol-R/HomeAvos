<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
     <link rel="icon" href="images/icono2.ico">
     <link href="EstilosP/indexEstilos.css" type="text/css" rel="stylesheet"/>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<meta charset="ISO-8859-1">
<title>Plan membresia</title>
</head>
<body>

<%@include file="Header.jsp" %>
<br><br>


<section>
<h1 class="titulo">Plan de membresía</h1>

<p class="descr">
	Seleccione una de las siguientes opciones para interactuar <br>
	con la información del plan de membresía que ofrece <br>
	Home avós para los hogares geriátricos.
</p>

<form action="P_registrar.jsp">
<input class="botones" type="submit" value="Añadir" name="registrar"/>
</form>

<form action="P_buscar.jsp">
<input class="botones" type="submit" value="Consultar" name="Consultar"/>
</form>

<form action="P_modificar.jsp">
<input class="botones" type="submit" value="Actualizar información" name="Modificar"/>
</form>

<form action="P_eliminar.jsp">
<input class="botones" type="submit" value="Eliminar" name="Eliminar"/>
</form>

<form action="HG_index_CRUD.jsp">
<input class="botonRegresar" type="submit" value="Volver" name="Volver"/>
</form>

<br><br>
<img src="images/abuelosServicio.jpg" class="imagen"/>

</section>


<%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>