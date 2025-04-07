<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/icono2.ico">
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="EstilosF/modificarF.css" type="text/css" rel="stylesheet"/>
        <link href="DisenoAlert/sweetalert.css" rel="stylesheet" />
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Familiar</title>
    </head>
    <body>
    
<% 
List<familiar> Dfamiliar = (ArrayList<familiar>)session.getAttribute("datosF");
 %>     
    
<%@include file="Header.jsp" %>

<section>
<br><br>
<h1 class="titulo">Actualizar Datos</h1> 
 <br><br> 
 <article id="contt">      
  <form id="formulario" action="modifica_familiar" method="POST">
   
   <h4 class="subt">Datos básicos</h4>
   
   <!-- NO MODIFICA-->     
   <label class="text">Tipo Documento </label>
   <input class="Ctexto" type="text" name="nomTD" style="width:10.3%;" value="<%=Dfamiliar.get(0).getTipoDocumento()%>" disabled>
   <!-- NO MODIFICA-->
   <label class="text">N° Documento </label>
   <input class="Ctexto" type="text" name="nDocF" style="width:21%;" value="<%=Dfamiliar.get(0).getDocumentoFam()%>" disabled>
   <!-- NO MODIFICA-->     
   <label class="text">Género </label>
   <input class="Ctexto" type="text" name="nomG" style="width:13%; margin-bottom:14px;" value="<%=Dfamiliar.get(0).getGenero()%>" disabled>  
            
   <label class="text">Nombres </label>
   <input class="Ctexto" type="text" name="nomF" id="nomF" style="width:35%;" value="<%=Dfamiliar.get(0).getNombres()%>" pattern="[a-zA-ZÁáÉéÍíÓóÚúñÑ. ]{3,30}" title="" required>
   
   <label class="text">Apellidos </label>
   <input class="Ctexto" type="text" name="apllF" id="apllF" style="width:35%; margin-bottom:14px;" value="<%=Dfamiliar.get(0).getApellidos()%>" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ. ]{3,30}" title="" required>
   
   <label class="text">N° Contacto </label>
   
   <input class="Ctexto" type="tel" name="NcontactoF" id="NcontactoF" style="width:28.3%;" value="<%=Dfamiliar.get(0).getTelefono()%>" pattern="[0-9]{7,10}" title="" required>
   
   <label class="text">Dirección </label>
   <input class="Ctexto" type="text" name="direccionF" id="direccionF" style="width:38%; margin-bottom:14px;" value="<%=Dfamiliar.get(0).getDirección()%>" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{8,40}" title="" required>
   
   <h4 class="subt">Datos de acceso</h4>
   
   <label class="text">Correo electrónico </label>
   <input class="Ctexto" type="email" id="correoF" name="correoF" style="width:28.5%;" value="<%=Dfamiliar.get(0).getCorreo()%>" required>
   <label class="text">Verificación </label>
   <input class="Ctexto" type="email" id="VcorreoF" name="VcorreoF" style="width:28.5%; margin-bottom:14px;" value="<%=Dfamiliar.get(0).getCorreo()%>" required>
   
   <label class="text">Contraseña </label>
   <input class="Ctexto" type="password" id="contraF" name="contraF" style="width:32.3%;" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Requiere 8 caráteres 1 mayúscula 1 minúscula y 1 número como mínimo" required>
   <label class="text">Verificación </label>
   <input class="Ctexto" type="password" id="VcontraF" name="VcontraF" style="width:32.2%;" required>
   
   <br><br>
            
   <input class="submit" type="submit" value="Enviar" title="Enviar" onclick="verificar()"/>
   <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='F_index_CRUD.jsp'"/>
          
 </form>

 <script>
   function verificar(e){
	   
	   e = e || window.event;
	   
	   var correoAF=document.getElementById('correoF').value;
       var VcorreoAF=document.getElementById('VcorreoF').value;
       var contraAF=document.getElementById('contraF').value;
       var VcontraAF=document.getElementById('VcontraF').value;
       
       if(contraAF!=VcontraAF){
    	   swal({
    		   title: "",
    		   text: "Las contraseñas NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })  
       e.preventDefault();}
     
       
       if(correoAF!=VcorreoAF){
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
