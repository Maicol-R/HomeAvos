<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.hogar_geriatrico"%> 

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="images/icono2.ico">
    <link href="Estilos/BNayuda.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
    <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ayuda</title>
</head>
<body>

<%@include file="Header.jsp" %>

<section id="section">

  <div class="color">
  <br>
 <br>

 <nav class="navbar navbar-expand-lg navbar" style="height:70px; background-color:#5005b6; border-bottom: #FFFFFF 2px solid; border-top: #FFFFFF 2px solid;">
    
    <label class="nombreHogar"> Ayuda </label> 
</nav>

<br>
<p class="negra"> <h3>¿Algo que nos quieras comentar? <h3></h3></p>  <br><br>


<form id="frm" method="POST"> 
        <div class="form-group">
            <label  for="exampleInputEmail1">NOMBRE</label > 
            <input type="text" name="Nombre" placeholder="Digite su Nombre"class="form-control"required>
            </div>
        <div class="form-group">
            <label for="exampleInputEmail1">APELLIDO</label>
            <input type="text" name="Apellido" placeholder="Digite su Apellido"class="form-control"required>
            </div>
        <div class="form-group">
            <label for="exampleInputEmail1">TELEFONO</label>
            <input type="text" name="Telefono" placeholder="Digite su Telefono"class="form-control"required>
            </div>
        <div class="form-group">
            <label for="exampleInputEmail1">DOCUMENTO</label>
            <input type="text" name="Documento" placeholder="Digite su Documento" class="form-control"required>
            </div>
      
            <textarea class="texarea" type="text" name="des" placeholder="Descripcion*"></textarea>
           
  </p>    
      <input class="submit" type="submit" value="Enviar" id="guardadatos" class="botones"/>
      <input class="reset" type ="button" class="volver" value ="Volver" onclick="javascript:location.href='Principal.jsp'"/>
</form>
<br>
 
 </div>
 </section>



<%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>