<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
     <link rel="icon" href="images/icono2.ico">
     <link href="Estilos/D_pagoB.css" type="text/css" rel="stylesheet"/>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
     <link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<meta charset="ISO-8859-1">
<title> Valoracion</title>
</head>
<body>

<%@include file="Header.jsp" %>
<br><br>


<nav class="navbar navbar-expand-lg navbar" style="height:70px; background-color:#5005b6; margin-left:20%; margin-right:20%;  border-bottom: #FFFFFF 2px solid; border-top: #FFFFFF 2px solid;">
    <label class="nombreHogar"> Informacion de pago  </label> 
</nav>

<br>

<section>
<nav class="navbar navbar-expand-lg navbar" style="height:60px; background-color:#08a1ff; margin-left:20%; margin-right:20%;  border-bottom: #FFFFFF 2px solid; border-top: #FFFFFF 2px solid;" >

  <textfiel class="nombreHogar" readonly style="margin-left:20%; height: 50px;width: 60%;" class="texarea" type="text" name=" "> Plan Basico de Hogar Geriatrico- Corporacion Home Avos </textfiel>
    
</section>

<br>
 <hr style=" margin-left:20%; margin-right:20%;">
		</hr>
		
		
	<form action="registra_Planmembresia" class="formulario">
	
		
        <div class="form-group">
            <label  for="exampleInputEmail1" style="margin-left:20%;">CODIGO DE PLAN </label > 
            <textarea readonly style="margin-left:20%; height: 50px;width: 60%;" class="texarea" type="text" name="codPlan"> 105363</textarea>
            </div>
        <div class="form-group">
            <label for="exampleInputEmail1" style="margin-left:20%;"> NOMBRE PLAN</label>
            <textarea readonly style="margin-left:20%; height: 50px;width: 60%;" class="texarea" type="text" name="nombre"> PLAN BASICO DE HOGAR GERIATRICO</textarea>
            </div>
             <div class="form-group">
            <label for="exampleInputEmail1" style="margin-left:20%;">METODO DE PAGO</label><br>
              <select style="margin-left:20%;height:50px; width: 60%;" name="metodo_pago" class="Cbox"> 
        <option>SELECCIONE EL METODO DE PAGO DE SU PREFERENCIA  </option>
        <option>Visa</option>
        <option>Bancolombia</option>
        <option>Maestro</option>
        <option>Mastercard</option>
        <option>American Express </option>
        <option>Discover</option>
        <option>Paypal</option>
    </select>      
          
            </div>
            <div class="form-group">
            <label for="exampleInputEmail1" style="margin-left:20%;">DURACION PLAN</label>
          <textarea readonly style="margin-left:20%; height: 50px;width: 60%;" class="texarea" type="text" name="duracion"> 3 MESES </textarea>
            </div>
       <div class="form-group">
            <label for="exampleInputEmail1" style="margin-left:20%;">DESCRIPCION</label><br>
           <textarea readonly style="margin-left:20%; height: 130px;width: 60%;" class="texarea" type="text" name="descripcion"> Este plan Basico obtiene Hogares y servicos a un bajo costo, permitiendo que cualquier familiar que no tenga los recursos necesarios pueda adquirirlo sin ningun compromiso y opte por este plan  para sus beneficios.</textarea>
           
        <div class="form-group">
            <label for="exampleInputEmail1" style="margin-left:20%;">PRECIO</label><br>
           <textarea readonly style="margin-left:20%; height: 130px;width: 60%;" class="texarea" type="text" name="precio"> $850.000  </textarea>
           
<br>
<br>
 <br>
 <br>
 <div class="form-group row">
    <div class="col-sm-2"></div>
    <div class="col-sm-10">
      <div style=" margin-left:15%;" class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck1">
        <label class="form-check-label" for="gridCheck1">
          Confirmo que acepto todos los Terminos y Condicciones de los Planes de membresia <br><br>
            <input class="form-check-input" type="checkbox" id="gridCheck1">
        <label class="form-check-label" for="gridCheck1">
          Acepto la Politica de Tratamiento de datos personales del Plan de membresia
        </label>
      </div>
    </div>
  </div>


<br>

  <input style="margin-left:40%;width: 10%;"class="submit" type="submit" value="Enviar" id="guardadatos" class="botones" class="btnVM" type="submit" value="Enviar" name=""/>
  <input style="margin-left:1%;width:10%;"class="reset" type ="button" class="volver" value ="Volver" onclick="javascript:location.href='D_plan.jsp'"/>
     
</form>
       
       
<%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



</body>
</html>