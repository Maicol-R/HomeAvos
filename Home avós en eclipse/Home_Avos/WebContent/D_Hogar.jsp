<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.servicios"%> 
<%@page import="Modelo.valoracion"%> 
<%@page import="Modelo.hogar_geriatrico"%> 
<%@page import="DAO_F.DAO_familiar_Impl"%>    
<!DOCTYPE html>
<html>
<head>

<% 	
String nombre="Hogar Geriátrico",ciudad="",direccion="",correo="",descripcion="";
long telefono1=0, telefono2=0;
List<familiar> Familiar = (ArrayList<familiar>)session.getAttribute("datosF");
List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
if(hogares!=null){
  nombre=hogares.get(0).getNom_Residencia();
  ciudad=hogares.get(0).getCiudad();
  direccion=hogares.get(0).getDirección();
  telefono1=hogares.get(0).getTelefono();
  telefono2=hogares.get(0).getTelefono2();
  correo=hogares.get(0).getCorreo();
  descripcion=hogares.get(0).getDescripcion();
}

%> 

<meta charset="UTF-8">
<link rel="icon" href="images/icono2.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/HogarD.css" type="text/css" rel="stylesheet"/>
<title><%=nombre%></title>
</head>
<body>

<%@include file="Header.jsp" %>

<br>

<!-----------informacion 1cuadro-------------->

<section id="section">

  <div class="color">

 <nav class="navbar navbar-expand-lg navbar" style="height:70px; background-color:#5005b6;">
 
    <label class="nombreHogar"><%=nombre%></label> 
 
</nav>

 <article>
    <p class="descrip">
   	<%=descripcion%>
     </p>      
       

<!-- carrusel de imagenes -->

     <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" style="width:65%; display: block; margin-left:auto; margin-right:auto; margin-bottom:5px;">
       <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
  
       </ol>
     <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/carruselHogar1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carruselHogar2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carruselHogar3.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carruselHogar4.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carruselHogar5.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  </div>

   <br>
   <br>

<!--datos de ubicacion -->

    <img class="icons" src="images/iconUbi.png"><div class="subs"><label>Ciudad:</label><h6><%=ciudad%></h6></div><br>
    <img class="icons" src="images/iconUbi.png"><div class="subs"><label>Dirección:</label><h6><%=direccion%></h6></div><br> 
    <img class="icons" src="images/iconTel.png"><div class="subs"><label>Telefonos:</label><h6><%=telefono1+" - "%><%=telefono2%></h6></div><br>
    <img class="icons" src="images/iconCorreo.png"><div class="subs"><label>Correo electronico:</label><h6><%=correo%></h6></div><br> 


</article>
</div>

<br><br>

<!-------------informacion 2 cuadro---------------------->


<div class="color">

   <nav class="navbar navbar-expand-lg navbar" style="height:70px; background-color:#5005b6;">
   <label class="nombreHogar">Servicios que ofrecemos</label> 
</nav>
 <br>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Servicios</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Tiempo</th>
      <th scope="col">Cupos</th>
      <th scope="col">Precio</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>

<%List<servicios> ListServicios = (ArrayList<servicios>)session.getAttribute("serviciosHG"); 
List<servicios> serviciosEscogidos = (ArrayList<servicios>)session.getAttribute("serviciosEscogidos"); 
int contador=0;
if(serviciosEscogidos!=null){
   for(servicios ob : ListServicios){
	  for(servicios ob2 : serviciosEscogidos){
		  if(ob2.getCodigo()==ob.getCodigo()){
          contador=1;
%>
          <tr>
            <th scope="row"><%=ob.getNombre()%></th>
            <td><%=ob.getDescrp()%></td>
            <td><%=ob.getTiempo()%></td>
            <td><%=ob.getCupos()%></td>
            <td>$<%=ob.getPrecio()%></td> 
            <td>¡AGREGADO!</td>
         </tr>
         
         <%}%>
       <%}%>
       <%if(contador==0){%>
          <tr>
           <th scope="row"><%=ob.getNombre()%></th>
           <td><%=ob.getDescrp()%></td>
           <td><%=ob.getTiempo()%></td>
           <td><%=ob.getCupos()%></td>
           <td>$<%=ob.getPrecio()%></td> 
           <td><a href=Agregar_servicios?codServ=<%=ob.getCodigo()%>><button class="btonServicio">ELEGIR SERVICIO</button></a></td>
         </tr>
         <%}%>
         <%contador=0;%>
     <%}%>
<%}else{
   for(servicios ob : ListServicios){%>
      <tr>
        <th scope="row"><%=ob.getNombre()%></th>
        <td><%=ob.getDescrp()%></td>
        <td><%=ob.getTiempo()%></td>
        <td><%=ob.getCupos()%></td>
        <td>$<%=ob.getPrecio()%></td> 
        <td><a href=Agregar_servicios?codServ=<%=ob.getCodigo()%>><button class="btonServicio">ELEGIR SERVICIO</button></a></td>
      </tr>
    <%}%>
<%}%>
  <tr>
  <th></th>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  </tr>
  </tbody>
</table>

</div>

<br>

<!-------------informacion 3 cuadro--------------------->
<div class="color">

<nav class="navbar navbar-expand-lg navbar" style="height:70px; background-color:#5005b6;">
    <label class="nombreHogar">Opiniones</label> 
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
</nav>
 <br>


<table class="table">
  <thead>
   
  </thead>
  <tbody>
 
<%
List<valoracion> ListComentarios = (ArrayList<valoracion>)session.getAttribute("valoracionHG"); 
DAO_familiar_Impl DAOF = null;
List<familiar> FamComt = null;
String indexUsu="nada";                         //aqui está la variable indexUsu
String comentario="";

if(!ListComentarios.isEmpty()){
int cont=0;   
  for(valoracion ob : ListComentarios){	
	DAOF = new DAO_familiar_Impl();
    FamComt = new ArrayList(DAOF.buscar(ob.getDocumento_Fam()));
      
    if(ob.getDocumento_Fam()==Familiar.get(0).getDocumentoFam()){
       indexUsu=String.valueOf(cont);
       comentario=ListComentarios.get(Integer.parseInt(indexUsu)).getComentario();
    }else{
%>

   <tr>
      <th scope="row" class="datosF" style="width:11%;"> 
        <img class="iconoU" src="images/iconFamiliar.png">
      </th>
      <td>
        <label class="nombresU"><%=FamComt.get(0).getNombres()+" "+FamComt.get(0).getApellidos()%></label><br>
        <label class="TextComBD"><%=ListComentarios.get(cont).getComentario()%></label>
      </td>
   </tr>
    
<%}
cont++;
  }
    if(indexUsu=="nada"){
 %>   	
   <tr>
       <th scope="row" class="datosF"> 
          <img class="iconoU" src="images/iconFamiliar.png">
       </th>
       <td>
         <label class="nombresU" scope="col"> <%=Familiar.get(0).getNombres()+" "+Familiar.get(0).getApellidos()%> </label>
         <form action="registro_valoracion" method="POST">
          <label class="textIC" >Escribe un comentario</label><br>
          <input type="textarea" id="comentar" class="textCom" name="textCom" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{10,600}" title="10 - 600 carácteres" required/> 
          <input class="submitCom" id="submitCom" type="submit" value="COMENTAR">
          <input class="resetCom" id="restCom" type="reset" value="CANCELAR">
         </form>
       </td>
   </tr>
   <tr>
      <td></td>
      <td></td>
   </tr>
  <%}else{
	  DAOF = new DAO_familiar_Impl();
	  FamComt = new ArrayList(DAOF.buscar(Familiar.get(0).getDocumentoFam()));
  %>
  <tr>
        <th scope="row" class="datosF" style="width:11%;"> 
          <img class="iconoU" src="images/iconFamiliar.png">
      
        </th>
        <td>
           
          <!-- Botones actualizar -->
          <form action="actualizar_valoracion" method="POST">
             <label class="nombresU" scope="col"> <%=Familiar.get(0).getNombres()+" "+Familiar.get(0).getApellidos()%> </label>
             <br>
             <textarea id="modComentario" minlength="10" maxlength="600" name="textComA" readonly><%=ListComentarios.get(Integer.parseInt(indexUsu)).getComentario()%></textarea>
              
             <label id="comMostrar" class="textComBD"><%=ListComentarios.get(Integer.parseInt(indexUsu)).getComentario()%></label>
             
             <input class="deleteCom" id="actualizarC" type="button" value="ELIMINAR" onclick="eliminar()">
             <input class="updateCom" id="eliminarC" type="button" value="ACTUALIZAR" onclick="actualizarForm()">
             <input type="submit" class="submitCom" id="actualizarFinal" value="ACTUALIZAR" style="display:none;">
             <input class="resetCom" type="button" id="cancelActualizar" value="CANCELAR" onclick="cancelar()" visibility="false" style="display:none;">
          </form>
       
          
          
          
        </td>
     </tr>	
     <tr>
      <td></td>
      <td></td>
     </tr>
  <%}%> 
  
     <script>
     
     function actualizarForm(){
    	 modComentario.style.border = '3px #5005b6 solid'
    	 modComentario.style.marginLeft = '-1%'
         document.getElementById("modComentario").focus();
    	 $("#modComentario").prop('readonly', false)

         modComentario.style.display = 'block'
         comMostrar.style.display = 'none'
    	 actualizarFinal.style.display = 'block'
         cancelActualizar.style.display = 'block'
         actualizarC.style.display = 'none'
         eliminarC.style.display = 'none'
         
     }
     
     function cancelar(){
    	 modComentario.style.border = '0 #FFFFFF solid'
         modComentario.style.marginLeft = '0'
         $("#modComentario").prop('readonly', true)
         $('#modComentario').val('<%=comentario%>');
    	 $('#comMostrar').val('<%=comentario%>');
        
    	 modComentario.style.display = 'none'
         comMostrar.style.display = 'block'
         actualizarFinal.style.display = 'none'
         cancelActualizar.style.display = 'none'
         actualizarC.style.display = 'block'
         eliminarC.style.display = 'block'
     }
     
     function eliminar(e){
    	 
    	 e = e || window.event;
    	 
    	 swal({
    		  title: "¿Está seguro?",
    		  text: "Si elimina el comentario no podrá deshacer esta acción",
    		  icon: "warning",
    		  buttons: ["Cancelar" , "Confirmar"],
    		  dangerMode: true,
    		})
    		.then((willDelete) => {
    		  if (willDelete) {
    			  window.location.href = "eliminar_valoracion"
    		  } else {
    			  e.preventDefault();
    		  }
    		});
     }
     </script>
  
</tbody>
</table> 
<%}else{
%>	
<td colspan="2"><label class="msjNOcomt">Este hogar geriátrico todavía no tiene opiniones<p>¡Sé el primero en comentar!</label></td>
    <tr>
       <th scope="row" class="datosF" style="width:11%;"> 
          <img class="iconoU" src="images/iconFamiliar.png">
       </th>
       <td>
         <label class="nombresU" scope="col"> <%=Familiar.get(0).getNombres()+" "+Familiar.get(0).getApellidos()%> </label>
         <form action="registro_valoracion" method="POST">
          <label class="textIC" >Escribe un comentario</label><br>
          <input type="textarea" id="comentar" class="textCom" name="textCom" pattern="[a-zA-ZÁáÉéÍíÓóÚú#-°.ñÑ0-9 ]{10,600}" title="10 - 600 carácteres" required/> 
          <input class="submitCom" id="submitCom" type="submit" value="COMENTAR">
          <input class="resetCom" id="restCom" type="reset" value="CANCELAR">
         </form>
       </td>
   </tr>
   <tr>
      <td></td>
      <td></td>
   </tr>
 </tbody>
</table>


<%}%>
</div>




<!------------ boton POSTULAR --------------->


<br><br>
<div class="cuadroP">
<p>Si este hogar geriátrico ha cumplido con todos sus requerimientos y desea postular a su adulto mayor<br>
Recuerda primero seleccionar los servicios a recibir en la tabla "Servicios que ofrecemos".<p>


<%if (serviciosEscogidos!=null){ %>
<a href="AM_registrar.jsp"><button class="btnPostular">Click aqui para CONTINUAR</button></a>
<%}else{%>
<button class="btnPostularDes">Click aqui para CONTINUAR</button>
<%}%>
</div>


</section>
   <!--////////////////////-->
  
  
  
<%@include file="Footer.jsp" %>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>