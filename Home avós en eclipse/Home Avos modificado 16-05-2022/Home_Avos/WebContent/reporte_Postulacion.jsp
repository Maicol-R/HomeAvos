<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Modelo.hogar_geriatrico" %>
<%@page import="Modelo.familiar" %>
<%@page import="Modelo.servicios" %>
<%@page import="Modelo.adulto_mayor" %>
<%@page import="Modelo.info_postulacion" %>
<!DOCTYPE html>
<html>
<head>

<%
List<hogar_geriatrico> Dhogar = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
List<servicios> servicios = (ArrayList<servicios>)session.getAttribute("serviciosEscogidos"); 
List<familiar> Dfamiliar = (ArrayList<familiar>)session.getAttribute("datosF");
List<adulto_mayor> Dadulto = (ArrayList<adulto_mayor>)session.getAttribute("datosAM");
List<info_postulacion> postulacion = (ArrayList<info_postulacion>)session.getAttribute("reportePostulacion");

%>

<meta charset="ISO-8859-1">
<link rel="icon" href="images/icono2.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="Estilos/reporte_Postulacion.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<title>Reporte postulación</title>
</head>
<body>

<%@include file="Header.jsp" %>


  <h2 class="titulo">Informe de Postulación</h2>

<section id="cont">

  <br>
  <label class="subtitulo">El familiar </label> 
  <label class="dato"><%=Dfamiliar.get(0).getNombres()+" "+Dfamiliar.get(0).getApellidos() %></label> 
  <label><%=Dfamiliar.get(0).getTipoDocumento()+" "+Dfamiliar.get(0).getDocumentoFam()  %></label> 
  
  <label class="subtitulo">hizo una postulación del adulto mayor </label>
  <label class="dato"><%=Dadulto.get(0).getNombres()+" "+Dadulto.get(0).getApellidos() %></label>
  <label><%=Dadulto.get(0).getTipoDocumento()+" "+Dadulto.get(0).getNumDocumento() %></label>
  
  <label class="subtitulo">para que sea recibido en </label>
  <label class="dato"><%=Dhogar.get(0).getNom_Residencia() %></label> 
  
  <label class="subtitulo">y reciba los servicios nombrados a continuación: </label>
  <br>
    <%for(servicios ob: servicios){ %>
    <br>
    <label>- <b><%=ob.getNombre()%></b> con una duración de <b><%=ob.getTiempo()%></b> y un precio de $ <b><%=ob.getPrecio()%></b></label> 
    <%}%>
  <br><br>
  
  <label class="subtitulo">A la fecha y hora </label>
  <label class="dato"><%=postulacion.get(0).getFecha_hora()%></label>
  
  <br>
  <label>Estado actual: </label>
  <label class="dato"><%=postulacion.get(0).getEstado() %></label>
  <br><br>
<label>Gracias por elegir home avós, esperamos que tenga una pronta respuesta !!</label>

</section>

<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>