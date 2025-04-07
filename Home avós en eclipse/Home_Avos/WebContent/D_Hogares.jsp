<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.servicios"%> 
<%@page import="Modelo.hogar_geriatrico"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="images/icono2.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="Estilos/D_Hogares.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<title>Buscar hogar geriátrico</title>
</head>
<body>

<%@include file="Header.jsp" %>

<% 
session.setAttribute("serviciosEscogidos", null);	
List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)session.getAttribute("ALLhogares");
for (hogar_geriatrico ob : hogares) {
%> 

 <article class="cont">
      <img class="imagen" src="images/EjemploImagenHogar.jpg">

      <p class="nombreH"><%=ob.getNom_Residencia()%></p>

    <div class="stars">
      <form class="formStar">
      <p class="clasificacion">
        <input class="inputStar" id="radio1" type="radio" name="estrellas" value="5"><!--
         --><label class="labelStar" for="radio1">&#9733;</label><!--
         --><input class="inputStar" id="radio2" type="radio" name="estrellas" value="4"><!--
         --><label class="labelStar" for="radio2">&#9733;</label><!--
         --><input class="inputStar" id="radio3" type="radio" name="estrellas" value="3"><!--
         --><label class="labelStar" for="radio3">&#9733;</label><!--
         --><input class="inputStar" id="radio4" type="radio" name="estrellas" value="2"><!--
         --><label class="labelStar" for="radio4">&#9733;</label><!--
         --><input class="inputStar" id="radio5" type="radio" name="estrellas" value="1"><!--
         --><label class="labelStar" for="radio5">&#9733;</label>
       </p>
       </form>
     </div>
 
	  <div class="verificado"><img class="iconV" src="images/icono_verificado.png"><label class="valores">Verificado</label></div>
	  <div class="ciudad"><img class="iconC" src="images/iconUbi.png"><label class="valores"><%=ob.getCiudad()%></label></div>
	  <div class="tipo"><img class="iconH" src="images/iconHogar.png"><label class="valores">Residencia</label></div><br>
	  <br>
	
	  <p class="descripcion"><%=ob.getDescrp_corta()%></p>
	 
	 <a href=mostrarInfo_hogarGeriatrico?NIT=<%=ob.getNit()%>><button class="btnVM">Ver más</button></a>
      
      <hr></hr>
 </article>	

<%}%>

<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>