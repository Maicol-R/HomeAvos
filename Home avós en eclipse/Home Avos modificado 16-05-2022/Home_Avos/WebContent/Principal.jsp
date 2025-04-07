<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="250164194319-oqm4jhe3db8k606bo10jb7p81npte74n.apps.googleusercontent.com">

<link href="Estilos/FooterEstilos.css" type="text/css" rel="stylesheet"/>
<link href="Estilos/HeaderEstilos.css" type="text/css" rel="stylesheet"/>
<link rel="icon" href="images/icono2.ico">
<link rel="stylesheet" href="/movil.css" media="only screen and (max-width: 700px)">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="Estilos/Principal.css" type="text/css" rel="stylesheet"/>
<meta charset="utf-8">
<title>Página principal</title>
</head>

<body>

<%@include file="Header.jsp" %>

<!-- descripcion -->

<section id="info">
  <article>
  <p class="descr">
  Home avós está diseñado para hacer una búsqueda<br>
  clara y precisa de un lugar de estadía para esta persona a la cual tanto<br>
  amas, tomando en cuenta los aspectos más importantes como<br>
  los servicios prestados y la calidad del personal.
  </p>
  </article>

<!---carrusel-->
  <article id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" style="width: 80%; display:block;
  margin-left: auto; margin-right: auto;">
  
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
  </ol> 

  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/carrusel1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carrusel2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carrusel3.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carrusel4.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/carrusel5.jpg" class="d-block w-100" alt="...">
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
  
  </article>
  
  </section>
<!-- lema -->
 <section>
 <img src="images/Abuelitos.png" width="45%" class="imagenAbus">
  <p class="descr2">
  "Saber envejecer es la obra maestra de la vida,<br>
  y una de las cosas mas dificiles en el arte<br>
  de la misma".
  </p>
  <section>
<br><br>


<%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    

</body>
</html>