<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.administrador" %>
    
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/icono2.ico">
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="EstilosAD/modificarAD.css" type="text/css" rel="stylesheet"/>
        <link href="DisenoAlert/sweetalert.css" rel="stylesheet" />
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Administrador</title>
    </head>
    <body>
    
<% 
List<administrador> Dadministrador = (ArrayList<administrador>)session.getAttribute("datosAD");
 %>     
    
<%@include file="Header.jsp" %>

<section>
<br><br>
<h1 class="titulo">Actualizar Datos</h1> 
 <br><br> 
 <article id="contt">      
  <form id="formulario" action="modifica_administrador" method="POST">
   
   <h4 class="subt">Datos básicos</h4>
   
   <!-- NO MODIFICA-->     
   <label class="text">Tipo Documento </label>
   <input class="Ctexto" type="text" name="tipoDocAD" style="width:10.3%;" value="" disabled>
   <!-- NO MODIFICA-->
   <label class="text">N° Documento </label>
   <input class="Ctexto" type="text" name="nDocAD" style="width:21%;" value="" disabled>
   <!-- NO MODIFICA-->     
   <label class="text">Fecha Expedición </label>
   <input class="Ctexto" type="text" name="fechaAD" style="width:13%; margin-bottom:14px;" value="" disabled>  
            
   <label class="text">Nombres </label>
   <input class="Ctexto" type="text" name="nomAD" id="nomAD" style="width:35%;" value="" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{3,30}" title="" required>
   
   <label class="text">Apellidos </label>
   <input class="Ctexto" type="text" name="apllAD" id="apllAD" style="width:35%; margin-bottom:14px;" value="" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ. ]{3,30}" title="" required>
   
   <label class="text">Dirección </label>
   <input class="Ctexto" type="text" name="direccionAD" id="direccionAD" style="width:38%; margin-bottom:14px;" value="" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{8,40}" title="" required>
   
   <label class="text">Ciudad </label>
   <input class="Ctexto" type="text" name="ciudadAD" id="ciudadAD" style="width:38%; margin-bottom:14px;" value="" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{6,40}" title="" required>
   
   <label class="text">N° Contacto </label>
   <input class="Ctexto" type="tel" name="NcontactoAD" id="NcontactoAD" style="width:28.3%;" value="" pattern="[0-9]{7,10}" title="" required>
   
   <h4 class="subt">Datos de acceso</h4>
   
   <label class="text">Correo electrónico </label>
   <input class="Ctexto" type="email" id="correoAD" name="correoAD" style="width:28.5%;" value="" required>
   <label class="text">Verificación </label>
   <input class="Ctexto" type="email" id="VcorreoAD" name="VcorreoAD" style="width:28.5%; margin-bottom:14px;" value="" required>
   
   <label class="text">Contraseña </label>
   <input class="Ctexto" type="password" id="contraAD" name="contraAD" style="width:32.3%;" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Requiere 8 caráteres 1 mayúscula 1 minúscula y 1 número como mínimo" required>
   <label class="text">Verificación </label>
   <input class="Ctexto" type="password" id="VcontraAD" name="VcontraAD" style="width:32.2%;" required>
   
   <br><br>
            
   <input class="submit" type="submit" value="Enviar" title="Enviar" onclick="verificar()"/>
   <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='AD_index_CRUD.jsp'"/>
          
 </form>

 <script>
   function verificar(e){
	   
	   e = e || window.event;
	   
	   var correoAD=document.getElementById('correoAD').value;
       var VcorreoAD=document.getElementById('VcorreoAD').value;
       var contraAD=document.getElementById('contraAD').value;
       var VcontraAD=document.getElementById('VcontraAD').value;
       
       if(contraAD!=VcontraAD){
    	   swal({
    		   title: "",
    		   text: "Las contraseñas NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
       
       if(correoAD!=VcorreoAD){
    	   swal({
    		   title: "",
    		   text: "Los correos NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
        
   }
   
   </script>
 
 </article>  
   </section>
   
   <%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
   
    </body>
</html>
