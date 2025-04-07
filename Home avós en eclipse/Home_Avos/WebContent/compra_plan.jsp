<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Modelo.hogar_geriatrico" %>
<%@page import="Modelo.familiar" %>
<%@page import="Modelo.servicios" %>
<%@page import="Modelo.adulto_mayor" %>
<%@page import="Modelo.Plan_membresia" %>
<%@page import="Modelo.compra_plan" %>
<!DOCTYPE html>
<html>
<head>

<%
List<hogar_geriatrico> hogarG = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
List<compra_plan> datosC = (ArrayList<compra_plan>)session.getAttribute("compraPlan");
List<Plan_membresia> PlanP = (ArrayList<Plan_membresia>)session.getAttribute("datosPM");
%>

<meta charset="ISO-8859-1">
<link rel="icon" href="images/icono2.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="Estilos/compra_plan.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<title>Reporte compra plan</title>
</head>
<body>

<%@include file="Header.jsp" %>


  <h2 class="titulo">Informe compra plan</h2>

<section id="cont">

  <br>
  <label class="subtitulo"> El Hogar geriatrico. con el NIT correspondiente. </label> 
  <label class="dato"><%=hogarG.get(0).getNom_Residencia()+" "+hogarG.get(0).getNit() %></label> 
  
  <label class="subtitulo"> hizo la Compra del plan de membresia,con un codigo referente.</label>
  <label class="dato"><%=PlanP.get(0).getnombre()+" "+PlanP.get(0).getcodPlan() %></label>

  <label class="subtitulo"> el cual le cede los beneficios de. </label>
  <label class="dato"><%=PlanP.get(0).getdescripcion()%></label>


  <label class="subtitulo"> con una duracion de. el metodo de pago elegido fue. y con un valor total de. </label>
  <label class="dato"><%=datosC.get(0).getmetodo_pago()+" "+PlanP.get(0).getprecio() %></label> 
  
  
  <br><br>
  
  <label class="subtitulo">A la fecha y hora </label>
  <label class="dato"><%=datosC.get(0).getFecha_hora()%></label>
  
  <br>
  <label>Estado actual: </label>
  <label class="dato"><%=datosC.get(0).getEstado() %></label>
  <br><br>
<label>Gracias por elegir home avós, esperamos que tenga una pronta respuesta !!</label>

</section>

<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>