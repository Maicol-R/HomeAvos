<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.Plan_membresia" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/icono2.ico">
        <link href="EstilosP/modificaP.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <meta charset="utf-8">
        <title>Actualizar Plan de membresía </title>
    </head>
    
    <body>
<% 
List<Plan_membresia> Dplan = (ArrayList<Plan_membresia>)session.getAttribute("datosP");
 %> 

      <%@include file="Header.jsp" %>

  
  <section>
<br><br>
<h1 class="titulo">Actualizar</h1> 
<br><br> 

<section class="contenedor">      
   <form id="formulario" action="modifica_Planmembresia" >
        <br>
   <!-- NO MODIFICA --->     
   <label class="text">Codigo del plan </label>
   <input class="Ctexto" type="text" name="codigo" style="width:11%;" value="<%=Dplan.get(0).getcodPlan()%>" disabled>
   
   <label class="text">Nombre del plan de membresía </label>
   <input class="Ctexto" type="text" name="nombre" style="width:35%;" value="<%=Dplan.get(0).getnombre()%>" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{3,30}" required >
   
   <label class="text">Duración del plan de membresía </label>
   <input class="Ctexto" type="text" name="duracion" style="width:20%;" value="<%=Dplan.get(0).getduracion()%>" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{3,30}" required>
   
   <label class="text">Precio del plan de membresía </label>
   <input class="Ctexto" type="text" name="precio" style="width:20%;" value="<%=Dplan.get(0).getprecio()%>" pattern="[0-9]{4,10}" required>
   <br>
   <label class="text">Descripción detallada</label>
   <textarea class="texarea" type="text" name="descripcion" value="<%=Dplan.get(0).getdescripcion()%>" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{5,500}" required></textarea>
    
          <input class="submit" type="submit" value="Enviar" title="Enviar"/>
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='P_index_CRUD.jsp'"/>
          
          </form>
         </section>
  
  <%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
    </body>
</html>