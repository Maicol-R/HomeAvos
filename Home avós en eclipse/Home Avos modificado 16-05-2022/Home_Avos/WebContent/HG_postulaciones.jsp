<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Modelo.servicios"%>
<%@page import="Modelo.adulto_mayor"%>
<%@page import="Modelo.info_postulacion"%>
<%@page import="DAO_infoP.DAO_infoPostulacion_Impl" %>
<%@page import="DAO_AM.DAO_adultoMayor_Impl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
     <link rel="icon" href="images/icono2.ico">
     <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="EstilosHG/Postulaciones.css" type="text/css" rel="stylesheet"/>
<title>Postulaciones</title>
</head>
<body>
<% 
List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)(session.getAttribute("datosHG"));
long NIT=hogares.get(0).getNit();

DAO_infoPostulacion_Impl a=new DAO_infoPostulacion_Impl();
List<info_postulacion> infoP = (ArrayList<info_postulacion>)(a.buscarPostulacionesHG(NIT));
%>

<%@include file="Header.jsp" %>

<br>
<h1 class="titulo">Postulaciones</h1>
<br>
  <section> 
  
  <%if(infoP.size()==0){ %>
  
  <label class="altern">¡Vaya!</label><br><br>
  <label class="altern2">Todavia no tiene ninguna postulación</label><br>
   <label class="altern2">Se le notificará cada vez que reciba una</label>
  
  <%}else{ %>
  
           <table class="table">
             <thead class="tipoDato">
                <tr>
                  <th scope="col">N° Documento adulto mayor</th>
                  <th scope="col">Nombre completo</th>
                  <th scope="col">Fecha/hora postulación</th>
                  <th scope="col">ESTADO</th>
                  <th></th>
                </tr>
             </thead>
             <tbody>
             
             
 <%
 DAO_adultoMayor_Impl daoM = new DAO_adultoMayor_Impl();
 
 for (int i=0; i<infoP.size(); i++){
	long docAM = infoP.get(i).getDoc_adultoM();
	List<adulto_mayor> nombreAdulM = (ArrayList<adulto_mayor>)(daoM.buscar(docAM));
	long codPost=infoP.get(i).getCod_Post();
 %>          
                <tr>
                 <th scope="row"class="dato"><%=infoP.get(i).getDoc_adultoM()%></th>
                 <td class="dato"><%=nombreAdulM.get(0).getNombres()+" "+nombreAdulM.get(0).getApellidos()%></td>
                 <td class="dato"><%=infoP.get(i).getFecha_hora()%></td>
                 <td class="dato"><%=infoP.get(i).getEstado() %></td> 
                 <td class="dato"><a href=consulta_postulaciones?codPost=<%=codPost%>><button class="btnVD">Ver detalles</button></a></td>
                </tr>
 <%}%>               
             </tbody>   
          </table>
 <%}%>       
 <br>
 <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='HG_index_CRUD.jsp'"/>
   
    </section>
    
  <%@include file="Footer.jsp"%>
  
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
  
</body>
</html>