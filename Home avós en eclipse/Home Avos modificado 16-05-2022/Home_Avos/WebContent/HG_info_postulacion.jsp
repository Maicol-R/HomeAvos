<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.StringTokenizer" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.info_postulacion" %>
<%@page import="Modelo.familiar" %>
<%@page import="Modelo.adulto_mayor" %>
<%@page import="Modelo.servicios" %>
<%@page import="DAO_F.DAO_familiar_Impl" %>
<%@page import="DAO_AM.DAO_adultoMayor_Impl" %>
<%@page import="DAO_S.DAO_servicios_Impl" %>

<!DOCTYPE html>
<html>
<head>
     <link rel="icon" href="images/icono2.ico">
     <link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="EstilosHG/verPostulaciones.css" type="text/css" rel="stylesheet"/>
     <meta charset="ISO-8859-1">
<title>Info postulación</title>
</head>

<body>

<%@include file="Header.jsp" %>
 
<% 
//info postulacion
List<info_postulacion> infoP = (ArrayList<info_postulacion>)(session.getAttribute("infoP"));

//info familiar
DAO_familiar_Impl a=new DAO_familiar_Impl();
ArrayList<familiar> infoF = (ArrayList<familiar>)(a.buscar(infoP.get(0).getDoc_familiar()));

//info adulto mayor
DAO_adultoMayor_Impl b=new DAO_adultoMayor_Impl();
ArrayList<adulto_mayor> infoAM = (ArrayList<adulto_mayor>)(b.buscar(infoP.get(0).getDoc_adultoM()));

//info servicios escogidos
DAO_servicios_Impl c=new DAO_servicios_Impl();
String servicios=infoP.get(0).getServicios();
StringTokenizer tokens = new StringTokenizer(servicios," ");
List<Long> codServicios = new ArrayList();
while(tokens.hasMoreElements()){
	codServicios.add(Long.parseLong(tokens.nextToken()));
}
%> 
    
    <section style="display:block; margin-left:20%; margin-right:20%;">
    
       <article>
         <br>
         <label class="titulo2">Fecha y hora postulación </label> <label class="datos"><%=infoP.get(0).getFecha_hora() %></label>
         <br>
         <label class="titulo2">Estado </label> <label class="datos"><%=infoP.get(0).getEstado() %></label>
       </article>
    
       <article>     
       
        <!-- tabla datos familiar -->
         
         <h1 class="titulo">Datos familiar</h1>
            
             <table class='table'>
	      	   <tbody>		
                  <tr>
                    <th scope='col' class="tipoDato">N° Documento</th><td class="dato"><%=infoF.get(0).getDocumentoFam() %></td>
                  </tr><tr>  
                    <th scope='col' class="tipoDato">Nombres</th><td class="dato"><%=infoF.get(0).getNombres() %></td>
	      		  </tr><tr>  
	      		    <th scope='col' class="tipoDato">Apellidos</th><td class="dato"><%=infoF.get(0).getApellidos() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">N° de Contacto</th><td class="dato"><%=infoF.get(0).getTelefono() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">Correo electrónico</th><td class="dato"><%=infoF.get(0).getCorreo() %></td>  
                  </tr>
               </tbody>
            </table>
            
          </article>  
          
          <article>
         <!-- tabla datos familiar -->
         
            <h1 class="titulo">Datos adulto mayor</h1>
            
             <table class='table'>
	      	   <tbody>		
                  <tr>
                    <th scope='col' class="tipoDato">N° Documento</th><td class="dato"><%=infoAM.get(0).getNumDocumento() %></td>
                  </tr><tr>  
                    <th scope='col' class="tipoDato">Tipo Documento</th><td class="dato"><%=infoAM.get(0).getTipoDocumento() %></td>
	      		  </tr><tr>  
	      		    <th scope='col' class="tipoDato">Nombres</th><td class="dato"><%=infoAM.get(0).getNombres() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">Apellidos</th><td class="dato"><%=infoAM.get(0).getApellidos() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">RH</th><td class="dato"><%=infoAM.get(0).getRh() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">Género</th><td class="dato"><%=infoAM.get(0).getGenero() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">Fecha de nacimiento</th><td class="dato"><%=infoAM.get(0).getFechaNac() %></td>
	      		  </tr><tr> 
	      		    <th scope='col' class="tipoDato">Cuidados y/o observaciones</th><td class="dato"><%=infoAM.get(0).getCuidadosEspeciales() %></td>
	      		  </tr>
               </tbody>
            </table>
            
         </article>
         <article> 
            <!-- tabla servicios elegidos -->
         
          <h1 class="titulo">Servicios elegidos</h1>
            
          <table class="table">
             <thead class="tipoServicios">
                <tr>
                  <th scope="col">Nombre del servicio</th>
                  <th scope="col">Descripción</th>
                  <th scope="col">Tiempo</th>
                  <th scope="col">Precio</th>
                </tr>
             </thead>
             <tbody>
           <%for (int i=0;i<codServicios.size();i++){ 
             List<servicios> tempserv = new ArrayList(c.buscar(codServicios.get(i)));
           %>  
                <tr>
                 <th scope="row"class="dato2"><%=tempserv.get(0).getNombre() %></th>
                 <td class="dato2"><%=tempserv.get(0).getDescrp() %></td>
                 <td class="dato2"><%=tempserv.get(0).getTiempo() %></td>
                 <td class="dato2"><%=tempserv.get(0).getPrecio() %></td> 
                </tr>
           <%}%>     
             </tbody>   
          </table>
               
             <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='HG_postulaciones.jsp'"/>
          
            
        </section>
        
<%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>