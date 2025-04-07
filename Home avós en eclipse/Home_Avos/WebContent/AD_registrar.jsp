<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="images/icono2.ico">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
    <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
    <link href="EstilosAD/registroAD.css" type="text/css" rel="stylesheet"/>
    <link href="DisenoAlert/sweetalert.css" rel="stylesheet" />
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<meta charset="ISO-8859-1">
<title>Administrador</title>
</head>
<body>
<%@include file="Header.jsp" %>
<br><br>
<h1 class="titulo">Registro Administrador</h1>

<section class="contenedor">

	<form action="registra_administrador" class="formulario" method="POST">
	<h3 class="subtitle">Datos básicos</h3>
	
	<input type="text" class="Ctexto" name="nombreAD" placeholder="Nombre(s) *" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{3,30}" title="" required>
	<input type="text" class="Ctexto" name="apellidoAD" placeholder="Apellido(s) *" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ. ]{3,30}" title="" required>
	<br><br>
	
	<select name="tipoDocAD" class="Ctexto" required>
      <option>Tipo Documento</option>
      <option>C.C</option>
      <option>C.E</option>
    </select>
    
	<input type="text" class="Ctexto" name="NdocAD" placeholder="N° Documento *" pattern="[0-9]{1,10}" title="Solo números" required>
	<br><br>
	
	<label class="subt">Fecha de expedición del documento *</label>
    <input type="date" class="Cfecha" name="fechaAD" required>
    <br>
    
    <input type="text" class="Ctexto" name="direccionAD" placeholder="Dirección *" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{8,40}" title="" required>
     <select name="ciudadAD" class="Ctexto">
       <option>Ciudad</option>
       <option>Soacha</option>
       <option>Sibate</option>
       <option>Bogota</option>
     </select>
    <br><br>
       
    <input type="tel" class="Ctexto" name="celularAD" placeholder="N° Celular *" pattern="[0-9]{7,10}" title="Solo números" required>
    <br><br>
       
       <h3 class="subtitle">Datos de acceso</h3>
       
       <input type="email" class="Ctexto" id="correoAD" name="correoAD" placeholder="Correo Electrónico *" required>
       <input type="email" class="Ctexto" id="VcorreoAD" name="VcorreoAD" placeholder="Verificación Correo *" required>
       <br><br>
       
       <input type="password" class="Ctexto" id="contraAD" name="contraAD" placeholder="Crear Contraseña *" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Requiere 8 caráteres 1 mayúscula 1 minúscula y 1 número como mínimo" required>
       <input type="password" class="Ctexto" id="VcontraAD" name="VcontraAD" placeholder="Verificación *" required>
       <br>
       
       <input type="submit" name="Enviar" class="submit" value="Enviar" onclick="verificar()">
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
</section>
<br>

<%@include file="Footer.jsp" %>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>