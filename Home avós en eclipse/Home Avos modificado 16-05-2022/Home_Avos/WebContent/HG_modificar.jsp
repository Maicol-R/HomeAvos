<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/icono2.ico">
        <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="EstilosHG/modificarHG.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
        <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
        <meta charset="utf-8">
        <title>Actualizar Datos Hogar</title>
    </head>
    <body>
    
    <%@include file="Header.jsp" %>
    
<section>
<br><br>
<h1 class="titulo">Actualizar</h1> 
<br><br>        
   <form id="formulario" action="modifica_hogarGeriatrico" >
        
        <h3 class="text">NIT del hogar geriátrico</h3>
        <p><input class="nit" type="text" name="nitHG"></p>
        <h3 class="text">En este apartado digite los nuevos datos</h3>
            
            <input class="Ctexto" type="text" name="representanteHG" placeholder="Representante Legal">
   
   <select class="Cboxx" name="tipoDocHG">
   <option>Tipo Documento</option>
   <option>C.C</option>
   <option>C.E</option>
   </select>
   
   <p><p>
   
   <input class="Ctexto" type="text" name="NdocHG" placeholder="N° Documento *">
   <input class="Ctexto" type="text" name="nombreResHG" placeholder="Nombre Residencia *">
   <p>
   <input class="Ctexto" type="text" name="NcontactoHG" placeholder="N° de Contacto *">
   <input class="Ctexto" type="text" name="Ncontacto2HG" placeholder="N° de Contacto 2 *">
   <p>
   <input class="Ctexto" type="text" name="direccionHG" placeholder="Dirección del lugar *">
 
   <select class="Cboxx" name="ciudadHG">
   <option>Ciudad</option>
   <option>Soacha</option>
   <option>Bogota</option>
   <option>Sibate</option>
   </select>
   
   <p>
   <input class="Ctexto" type="email" name="correoHG" placeholder="Correo Electrónico *">
   <input class="Ctexto" type="email" name="VcorreoHG" placeholder="Verificación Correo *">
   
   <p>
   
   <input class="Ctexto" type="password" name="contraHG" placeholder="Contraseña *">
   <input class="Ctexto" type="password" name="VcontraHG" placeholder="Verificación *">
   <p>
   <textarea type="text" class="Ctext" name="descrp" placeholder="Escribe toda la información relevante del hogar geriátrico .."></textarea>
   <p>
   <textarea type="text" class="Ctext2" name="descrp-corta" placeholder="En este apartado coloca una breve descripción máximo 380 carácteres .."></textarea>
   
   
   <p>
            
            <input class="submit" type="submit" value="Enviar" title="Enviar"/>
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='HG_index_CRUD.jsp'"/>
          
        </form>
     
     
     
        
  </section>
  
  <%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
        
    </body>
</html>
