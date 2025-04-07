<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.familiar"%> 
<%@page import="Modelo.administrador"%> 
<%@page import="Modelo.hogar_geriatrico"%>
<!DOCTYPE html>
<html>
<head>
<link href="DisenoAlert/sweetalert.css" rel="stylesheet" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>



<%
String Malert=(String)session.getAttribute("alert");
String alertAdver=(String)session.getAttribute("alertA");
String alertAdver2=(String)session.getAttribute("alertA2");
String alertError=(String)session.getAttribute("alertE");
String alertError2=(String)session.getAttribute("alertE2");
String alertBien=(String)session.getAttribute("alertB");
String alertBien2=(String)session.getAttribute("alertB2");

        List<hogar_geriatrico> DDhogar = null; 
        DDhogar = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
        
        List<familiar> DDfamiliar = null;
        DDfamiliar = (ArrayList<familiar>)session.getAttribute("datosF");
        
        List<administrador> DDadmin = null;
        DDadmin = (ArrayList<administrador>)session.getAttribute("datosAD");


if(Malert!=null){
%>
<div class="alert alert-warning alert-dismissible fade show" role="alert" style="background-color:#ffdf72; margin-bottom:2px;">
  <strong><%=Malert%></strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<%
session.setAttribute("alert", null);
}
%>

<%
///// MENSAJES DE ADVERTENCIA

if(alertAdver!=null && alertAdver2!=null){
%>
<script>
swal("<%=alertAdver%>", "<%=alertAdver2%>", "warning");
</script>
<%
session.setAttribute("alertA2", null);
session.setAttribute("alertA", null);
}
%> 
       
<%if(alertAdver!=null && alertAdver2==null){
%>
<script>
swal({
	   title: "",
	   text: "<%=alertAdver%>",
	   icon: "warning",
	   dangerMode: true,
	 }) 
</script>
<%
session.setAttribute("alertA", null);
}
%>

<%

///// MENSAJES DE ERROR

if(alertError!=null && alertError2!=null){
%>
<script>
swal("<%=alertError%>", "<%=alertError2%>", "error");
</script>
<%
session.setAttribute("alertE2", null);
session.setAttribute("alertE", null);
}
%>

<%if(alertError!=null && alertError2==null){
%>
<script>
swal({
	   title: "",
	   text: "<%=alertError%>",
	   icon: "error",
	   dangerMode: true,
	 }) 
</script>
<%
session.setAttribute("alertE", null);
}
%>

<%

///// MENSAJES DE ÉXITO

if(alertBien!=null && alertBien2!=null){
%>
<script>
swal("<%=alertBien%>", "<%=alertBien2%>", "success");
</script>
<%
session.setAttribute("alertB2", null);
session.setAttribute("alertB", null);
}
%>

<%if(alertBien!=null && alertBien2==null){
%>
<script>
swal("", "<%=alertBien%>", "success");
</script>
<%
session.setAttribute("alertB", null);
session.setAttribute("alertB2", null);
}
%>


<header>

  <div>
    <img src="images/cabecera.jpg" width=100%>
  </div>



<!--Barra de navegacion-->

<nav class="navbar navbar-expand-lg navbar" style="background-color:#5005b6; border-bottom: #FFFFFF 2px solid; border-top: #FFFFFF 2px solid;">
 
 <a class="navbar-brand" href="Principal.jsp" style="margin-right:-8%;"><img src="images/home.png" class="home2"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" 
  style="width:60px; height:60px;">
    <span><img src="images/menuDespl.png" class="menuDespl"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNav">
    
    <ul class="navbar-nav">
      <li class="nav-item active" >
      <a class="nav-link" href="mostrarTodo_hogarGeriatrico" style="border-bottom: #08a1ff 3px solid;">Buscar hogar geriátrico<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="BN_ofertas.jsp">Ofertas</a>
      </li> 
      <li class="nav-item">
      <a class="nav-link" href="BN_blogs.jsp">Blogs<label class="lis">...</label></a>
      </li>
        
        <li class="lis2">.<label class="lis">...</label></li>
        
      <li class="nav-item">
      <a class="nav-link" href="BN_quienes_somos.jsp">Quiénes somos</a>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="BN_preguntas_frecuentes.jsp">Preguntas frecuentes</a>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="BN_ayuda.jsp">Ayuda<label class="lis">...</label></a>
      </li>
      <li class="lis2">.<label class="lis">...</label></li>
      <%if(DDadmin!=null){ %>   
      <li class="nav-item" style="width:12%;">
      <a class="nav-link"  id="btnFamiliar" href="AD_index_CRUD.jsp"><img class="iconBTNf" src="images/iconFamiliar.png"/>Usuario</a>
      </li>
      <%}%>
      <%if(DDfamiliar!=null){ %>   
       <li class="nav-item" style="width:12%;">
      <a class="nav-link"  id="btnFamiliar" href="F_index_CRUD.jsp"><img class="iconBTNf" src="images/iconFamiliar.png"/>Usuario</a>
      </li>
      <%}%>
       <%if(DDhogar!=null && DDfamiliar==null){ %>   
       <li class="nav-item" style="width:12%;">
      <a class="nav-link" id="btnHogar" href="HG_index_CRUD.jsp"><img class="iconBTNhg" src="images/iconHogar.png"/>Usuario</a>
      </li>
      <%}%>
       <li class="lis">....................</li>
     <li class="nav-item dropdown">
        
        <%if(DDhogar==null && DDfamiliar==null && DDadmin==null){ %> 
        <button class="btn btn-primary" id="btnlogin" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
         Login - Registrarse
        </button>
     <%}else{ %>
        <form action="cerrar_sesion" method="POST">
        <input type="submit" class="btnCerrar" value="Cerrar sesión"/>
        </form>
     <%} %>
      </li>
    </ul>
  </div>
</nav>

<!--login-->

<div class="collapse" id="collapseExample">
<aside id="login">


 <label class="ind">INICIO DE SESIÓN</label>

<!--/////////////////////INICO DE SESION////////////////////-->

 <ul class="nav nav-tabs" id="myTab" role="tablist" style="border:0;">
   <li class="espacio"></li>
   <li class="nav-item" role="presentation">
     <a class="nav-link active" id="home-tab1" data-toggle="tab" href="#home1" role="tab" aria-controls="home1" aria-selected="true" style="font-size: 15px;">FAMILIAR</a>
   </li>
   <li class="espacio2"></li>
   <li class="nav-item" role="presentation">
     <a class="nav-link" id="profile-tab1" data-toggle="tab" href="#profile1" role="tab" aria-controls="profile1" aria-selected="false" style="font-size: 15px;">HOGAR GERIÁTRICO</a>
   </li>
 </ul>
 <div class="tab-content" id="myTabContent">
 <div class="tab-pane fade show active" id="home1" role="tabpanel1" aria-labelledby="home-tab1">
    
    <!--inicio de sesion familiar - administrador-->

  <form action="inicioS_familiar" id="formularioR" method="POST">
    <img src="images/iconFamiliar.png" width="30%" class="iconFam"> <br>
    <input type="email" class="cajasInicioS" name="correoISF" placeholder="Correo electrónico">
    <br>
    <input type="password" class="cajasInicioS" name="contraISF" placeholder="Contraseña">
    <br>
    <input type="submit" name="EnviarISF" class="submitISF" value="CONFIRMAR">
  </form>
  
  <!----------------------- login google --------------------->
 
 <%@include file="login_google.jsp"%>


 <!----------------------- login facebook --------------------->
 
 <%@include file="login_facebook.jsp"%>

   <!--inicio de sesion hogar geriatrico-->
  
</div>
  
<div class="tab-pane fade" id="profile1" role="tabpanel1" aria-labelledby="profile-tab1">
 <!--Inicio de sesion hogar geriatrico-->
   <form action="inicioS_hogarGeriatrico" id="formularioR" method="POST">
     <img src="images/iconHogar.png" width="30%" class="iconFam"> <br>
     <input type="text" class="cajasInicioS" name="nitISHG" placeholder="NIT">
     <br>
     <input type="password" class="cajasInicioS" name="contraISHG" placeholder="Contraseña">
     <br>
     <input type="submit" name="EnviarISF" class="submitISF" value="CONFIRMAR">
   </form> 
    <!--///////////////////////////-->

  </div>
  
 </div>
 
 
 
<!--/////////////////////////REGISTROS//////////////////////-->
 <br><br>
 <label class="ind">¿Quieres formar parte de nosotros?<br>
 REGISTRATE AQUI
 </label>


 <ul class="nav nav-tabs" id="myTab" role="tablist" style="border:0;">
   <li class="espacio"></li>
   <li class="nav-item" role="presentation">
     <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true" style="font-size: 15px;">FAMILIAR</a>
   </li>
   <li class="espacio2"></li>
   <li class="nav-item" role="presentation">
     <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false" style="font-size: 15px;">HOGAR GERIÁTRICO</a>
   </li>
 </ul>

 <div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

    <!--registro familiar-->
    
   <form action="registra_familiar" id="formularioR" name="formularioRF" method="POST">
  
       <h3 class="subtitles">Datos básicos</h3>
       <br>
       <input type="text" class="CtextoR" id="nombreFam" name="nombreFam" placeholder="Nombre(s) *" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ. ]{3,30}" title="" required>
       <input type="text" class="CtextoR" id="apellidoFam" name="apellidoFam" placeholder="Apellido(s) *" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ. ]{3,30}" title="" required>
   
       <br>
       <label>Género: </label>
       <input type="radio" name="sexoFam" value="Hombre"/> Hombre
       <input type="radio" name="sexoFam" value="Mujer"/> Mujer

       <select name="tipoDocFam" class="CboxR" required>
         <option>Tipo Documento</option>
         <option>C.C</option>
         <option>C.E</option>
       </select>

       <input type="text" class="CtextoR" id="NdocumentoFam" name="NdocumentoFam" placeholder="N° documento *" pattern="[0-9]{5,10}" title="" required>
       <br>
       <input type="tel" class="CtextoR" id="celularFam" name="celularFam" placeholder="N° Celular *" pattern="[0-9]{7,10}" title="" required>
       <input type="text" class="CtextoR" id="direccionFam" name="direccionFam" placeholder="Dirección residencia *" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{8,40}" title="" required>
  
       <br><br>
       <h3 class="subtitles">Datos de acceso</h3>
       <br>

       <input type="email" class="CtextoR" id="correoFam" name="correoFam" placeholder="Correo electrónico *" required>
       <input type="email" class="CtextoR" id="VcorreoFam" name="VcorreoFam" placeholder="Verificación Correo *" required>
       <br>
       <input type="password" class="CtextoR" id="contraFam" name="contraFam" placeholder="Crear Contraseña *" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Requiere 8 caráteres 1 mayúscula 1 minúscula y 1 número como mínimo" required>
       <input type="password" class="CtextoR" id="VcontraFam" name="VcontraFam" placeholder="Verificación *" required>
       <br><br>

       <input type="radio" name="acepTerminosF" value="acepto"/> <label class="terminos"> Acepto todos los términos y condiciones</label>
       <br>
       <a href="#"><label class="verTerminos">Ver términos y condiciones</label></a>
       <br>
       <input type="submit" name="EnviarRF" class="submitR" value="ENVIAR" onclick="verificarRF()"/>
       <input type="reset" name="BorrarRF" class="resetR" value="BORRAR">
    </form>
   <!--////////////////////-->
   </div>
  
   <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
   
   <script>
   function verificarRF(e){
	   
	   e = e || window.event;
	   
	   var correo=document.getElementById('correoFam').value;
       var Vcorreo=document.getElementById('VcorreoFam').value;
       var contra=document.getElementById('contraFam').value;
       var Vcontra=document.getElementById('VcontraFam').value;
       var genero=document.querySelector('input[name="sexoFam"]:checked');
       var tipoD= document.formularioRF.tipoDocFam.value;
       
       if(document.querySelector('input[name="acepTerminosF"]:checked')==null){
    	   swal({
    		   title: "",
    		   text: "Debe ACEPTAR nuestros términos y condiciones",
    		   icon: "warning",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
       
       if(contra!=Vcontra){
    	   swal({
    		   title: "",
    		   text: "Las contraseñas NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
     
       
       if(correo!=Vcorreo){
    	   swal({
    		   title: "",
    		   text: "Los correos NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
        
       
       if(tipoD == "Tipo Documento"){
    	   swal({
    		   title: "",
    		   text: "NO se ha seleccionado el tipo de documento",
    		   icon: "warning",
    		   dangerMode: true,
    		 }) 
       e.preventDefault();}
       
       if(genero==null){
    	   swal({
    		   title: "",
    		   text: "No se ha seleccionado el género",
    		   icon: "warning",
    		   dangerMode: true,
    		 })
               
       e.preventDefault();}
             
   }
   
   </script> 
   
 <!--registro hogar geriatrico-->

    <form action="registra_hogarGeriatrico" method="POST" id="formularioR" name="formularioRHG">
  
        <h3 class="subtitles">Datos requeridos</h3>
        <br>

        <input type="text" class="CtextoR" id="representanteHogarG" name="representanteHogarG" placeholder="Representante Legal" Nombre(s) *" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ. ]{6,80}" title="" required>
          <select name="tipoDocHogarG" id="tipoDocHogarG" class="CboxR">
          <option>Tipo Documento</option>
          <option>C.C</option>
          <option>C.E</option>
        </select>
        <br>
        <input type="text" class="CtextoR" id="NdocHogarG" name="NdocHogarG" placeholder="N° Documento *" pattern="[0-9]{6,10}" title="" required>
        <input type="text" class="CtextoR" id="nombreResHogarG" name="nombreResHogarG" placeholder="Nombre Residencia *" Nombre(s) *" pattern="[a-zA-ZÁáÉéÍíÓóÚúÑñ.'-:_@&/¿?¡! ]{3,50}" title="" required>
        <br>
        <input type="tel" class="CtextoR" id="NcontactoHogarG" name="NcontactoHogarG" placeholder="N° de Contacto *" pattern="[0-9]{7,10}" title="" required>
        <input type="tel" class="CtextoR" id="Ncontacto2HogarG" name="Ncontacto2HogarG" placeholder="N° de Contacto 2 *" pattern="[0-9]{7,10}" title="" required>
        <br>
        <input type="text" class="CtextoR" id="direccionHogarG" name="direccionHogarG" placeholder="Dirección del lugar *" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{8,40}" title="" required>
 
        <select id="ciudadHogarG" name="ciudadHogarG" class="CboxR">
          <option>Ciudad</option>
          <option>Soacha</option>
          <option>Bogotá</option>
          <option>Sibaté</option>
        </select>
   
        <br>
        <input type="email" class="CtextoR" id="correoHogarG" name="correoHogarG" placeholder="Correo Electrónico *" required>
        <input type="email" class="CtextoR" id="VcorreoHogarG" name="VcorreoHogarG" placeholder="Verificación Correo *" required>
        <br><br>
        <h3 class="subtitles">Datos de acceso</h3>
        <br>

        <input type="text" class="CtextoR" id="nitHogarG" name="nitHogarG" placeholder="NIT *" pattern="[0-9]{7,20}" title="" required>
        <input type="text" class="CtextoR" id="VnitHogarG" name="VnitHogarG" placeholder="Verificación NIT *" pattern="[0-9]{7,20}" title="" required>
        <br>
        <input type="password" class="CtextoR" id="contraHogarG" name="contraHogarG" placeholder="Crear Contraseña *" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Requiere 8 caráteres 1 mayúscula 1 minúscula y 1 número como mínimo" required>
        <input type="password" class="CtextoR" id="VcontraHogarG" name="VcontraHogarG" placeholder="Verificación *" required>
        <br><br>

        <input type="radio" id="acepTerminosHogarG" name="acepTerminosHogarG" value="acepto"/> <label class="terminos"> Acepto todos los términos y condiciones</label>
        <br>
        <a href="#"><label class="verTerminos">Ver términos y condiciones</label></a>
        <br>

        <input type="submit" name="EnviarRHG" class="submitR" value="ENVIAR" onclick="verificarRHG()">
        <input type="reset" name="BorrarRHG" class="resetR" value="BORRAR">

    </form>


    <script>
   function verificarRHG(e){
	   
	   e = e || window.event;
	   
	   var correo=document.getElementById('correoHogarG').value;
       var Vcorreo=document.getElementById('VcorreoHogarG').value;
       var nit=document.getElementById('nitHogarG').value;
       var Vnit=document.getElementById('VnitHogarG').value;
       var contra=document.getElementById('contraHogarG').value;
       var Vcontra=document.getElementById('VcontraHogarG').value;
       var tipoD= document.formularioRHG.tipoDocHogarG.value;
       var ciudad= document.formularioRHG.ciudadHogarG.value;
       
       if(document.querySelector('input[name="acepTerminosHogarG"]:checked')==null){
    	   swal({
    		   title: "",
    		   text: "Debe ACEPTAR nuestros términos y condiciones",
    		   icon: "warning",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
       
       if(contra!=Vcontra){
    	   swal({
    		   title: "",
    		   text: "Las contraseñas NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
     
       
       if(nit!=Vnit){
    	   swal({
    		   title: "",
    		   text: "El NIT NO coincide",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
       
       
       if(correo!=Vcorreo){
    	   swal({
    		   title: "",
    		   text: "Los correos NO coinciden",
    		   icon: "error",
    		   dangerMode: true,
    		 })   
       e.preventDefault();}
        
       
       if(ciudad == "Ciudad"){
    	   swal({
    		   title: "",
    		   text: "NO se ha seleccionado la ciudad del hogar geriátrico",
    		   icon: "warning",
    		   dangerMode: true,
    		 }) 
       e.preventDefault();}
       
       
       if(tipoD == "Tipo Documento"){
    	   swal({
    		   title: "",
    		   text: "NO se ha seleccionado el tipo de documento",
    		   icon: "warning",
    		   dangerMode: true,
    		 }) 
       e.preventDefault();}
             
   }
   
   </script> 
    <!--///////////////////////////-->

   </div>
  
 </div>

</aside>
</div>

</header>
</body>
</html>