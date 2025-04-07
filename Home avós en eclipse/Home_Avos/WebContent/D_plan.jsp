<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
     <link rel="icon" href="images/icono2.ico">
     <link href="Estilos/D_plan.css" type="text/css" rel="stylesheet"/>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<meta charset="ISO-8859-1">
<title>Plan membresia</title>
</head>
<body>

<%@include file="Header.jsp" %>
<br><br>



<nav class="navbar navbar-expand-lg navbar" style="height:70px; background-color:#5005b6; margin-left:10%; margin-right:10%;  border-bottom: #FFFFFF 2px solid; border-top: #FFFFFF 2px solid;" >
    
    <label class="nombreHogar"> Plan membresia </label> 
</nav>

<br>


<table  class="table table-bordered" style=" margin-left:10%;  width:80%;">
  <thead>
    <tr>
    <section>
      <th class="btnPL"> CONOCE TU PLAN </th>
      </section>
        <section>
      <th class="btnPA"> CONOCE TU PLAN </th>
       </section>
        <section>
      <th class="btnPB"> CONOCE TU PLAN </th>
       </section>
    </tr>
  
  <tbody>
    <tr>
    <section>
      <td class="negra" style="width:30%;" ><br>BASICO <br><br>
      </section>
       <section class="basic" style="margin-left:70px;"> 
      Explora lo basico con este plan de hogares<br><br>
      </section>
       <section class="basico" style="margin-left:150px;"> 
      Valido por 6 meses<br><br>
      </section>
       <form action="D_pagoB.jsp" style="margin-left:35%;">
       <input class="btnVM" type="submit" value="Comprar" name="D_plan"/>
        </form></td>
        </section>
      
   <section>
      <td class="negra" style="width:35%;"><br>ESTANDAR<br><br>
      </section>
       <section class="esta" style="margin-left:130px;"> 
      Acceso a hogares de calidad media<br><br>
      </section>
       <section class="estandar" style="margin-left:195px;"> 
      Valido por un año<br><br>
      </section>
      <form action="D_pagoE.jsp" style="margin-left:38%;">
       <input class="btnVM" type="submit" value="Comprar" name="D_plan"/>
        </form></td>
        </section>
      <section >
      <td class="negra"><br>PREMIUM <br><br>
      </section>
       <section class="pre"> 
      Acceso ilimitado con hogares de alta calidad<br><br>
      </section>
       <section class="premium"> 
      Valido por 3 años<br><br>
      </section>
       <form action="D_pagoP.jsp" style="margin-left:35%; width:75%;">
      <input class="btnVM" type="submit" value="Comprar" name="D_plan"/>
        </form></td>
        </section >
    </tr>
    <tr>
     <!-- Basico -->
    
     <section class="numerouno"> 
     <td>Referencias<br><br>
      </section>
     <section class="numerodos"> 
      -Atencion al cliente<br><br>
       </section>
       <section class="numerotres">
      -Modos de prestaciones<br><br>
       </section>
       <section class="numerocuatro">
      -Datos basicos y automatizacion<br><br>
       </section>
       <section class="numerocinco">
      -Medidas con protocolos de seguridad</td>
       </section>
       
       <!-- estandar -->
       <section class="numeritouno">
      	<td scope="col">Referencias<br><br>
      	 </section>
      <section class="numeritodos">
      -Atencion al cliente<br><br>
       </section>
       <section class="numeritotres">
      -Modos de prestaciones<br><br>
       </section>
       <section class="numeritocuatro">
      -Datos basicos y automatizacion<br><br>
       </section>
       <section class="numeritocinco">
      -Colaboracion pagada en tiempo real<br><br>
       </section>
       <section class="numeritoseis">
      -Medidas con protocolos de seguridad<br><br>
       </section>
       <section class="numeritosiete">
      -Limitaciones en algunos planes del hogar</td>
       </section>
      
       <!-- premium -->
       <section class="uno">
      	<td scope="col">Referencias<br><br>
      	</section>
      <section class="dos">
      -Atencion al cliente<br><br>
      </section>
      <section class="tres">
      -Modos de prestaciones<br><br>
      </section>
       <section class="cuatro">
      -Objetos ilimitados<br><br>
       </section>
       <section class="cinco">
      -Datos basicos y automatizacion<br><br>
       </section>
       <section  class="seis">
      -Colaboracion pagada en tiempo real<br><br>
       </section>
       <section class="siete">
      -Medidas con protocolos de seguridad<br><br>
       </section>
       <section class="ocho">
      -Ilimitacion en los servicios propuestos por el hogar </td>
       </section>
     
    </tr>
  
  </tbody>
</table>


<%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>