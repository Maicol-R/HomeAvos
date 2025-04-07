<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.hogar_geriatrico"%> 

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="images/icono2.ico">
    <link href="EstilosHG/Index_CRUD_HG.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
    <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Hogar Geriatrico CRUD</title>
</head>
<body>

<%@include file="Header.jsp" %>
<br><br>
<section>

<% 
String nombre="Hogar Geriátrico";
List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
if(hogares!=null){
  nombre=hogares.get(0).getNom_Residencia();
}

%>

<h1 class="titulo"><%=nombre%></h1>

<p class="descr">
	Seleccione una de las siguientes opciones para interactuar <br>
	con la información del Hogar Geriátrico.
</p>

<form action="HG_buscar.jsp">
<input class="botones" type="submit" value="Consultar" name="Consultar"/>
</form>

<form action="HG_modificar.jsp">
<input class="botones" type="submit" value="Actualizar Datos" name="Modificar"/>
</form>

<form action="HG_eliminar.jsp">
<input class="botones" type="submit" value="Eliminar" name="Eliminar"/>
</form>

<form action="S_index_CRUD.jsp">
<input class="botones" type="submit" value="Administrar Servicios" name="servicios"/>
</form>

<form action="D_plan.jsp">
<input class="botones" type="submit" value="Ver plan de membresia" name="plan membresia"/>
</form>

<br>
<br>

<img src="images/abuelosIndex.jpg" class="imagen"/>

</section>

<%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>