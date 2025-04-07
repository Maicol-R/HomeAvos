<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="250164194319-oqm4jhe3db8k606bo10jb7p81npte74n.apps.googleusercontent.com">

<style>
.botonCont {
     width:85%;
	 height: 27px;
     color: #FFFFFF;
	 border:0;  
     font-size:14px;
	 font-weight:bold;
     background-color:#08a1ff;
     display:block;
     margin-left:10%;
     margin-right:auto;
}

.botonCont:hover {
     background-color:#02769E;
}

.botonCerrar {
     visibility:hidden;
     width:85%;
	 height: 27px;
     color: #FFFFFF;
	 border:0;  
     font-size:14px;
	 font-weight:bold;
     background-color:#FF0000;
     display:block;
     margin-left:10%;
     margin-right:auto;
    
}

.botonCerrar:hover {
     background-color:#CA0606;
}

.mensaje {
    margin-top:30px;
    margin-left:10%;
    color:#FFFFFF; 
    font-weight: bold;
}

.g-signin2 { 
    margin-top:20px;
    margin-left:10%;
    margin-bottom:-100px;
}
</style>

</head>

 

<body>


<div class="g-signin2" data-onsuccess="onSignIn" id="myP" style="width:305px;"></div>
   
<img id="myImg"><br>
<p id="name"></p>

  
<div id="status">


</div>



<script type="text/javascript">
			function onSignIn(googleUser) {
			// window.location.href='success.jsp';

	
			
				  var profile = googleUser.getBasicProfile();
				  var imgs=profile.getImageUrl();
				  var name=profile.getName(); 
				  var email=profile.getEmail();
				  
				  //document.getElementById("myImg").src = imagurl;
				  //document.getElementById("name").innerHTML = name;
				  document.getElementById("myP").style.visibility = "hidden";
				  document.getElementById("signout").style.visibility = "visible";
				  document.getElementById("status").innerHTML = '<label class="mensaje">Bienvenido(a) '+name+'</label><a href=inicioSF_google?imgs='+imgs+'&name='+name+'/><button class="botonCont">CLICK PARA CONTINUAR</button></a></p>'
				 
				  //window.location.assign("F_index_CRUD.jsp");
				  

				  
			 }
</script>
 
                                     
<button class="botonCerrar" id="signout" onclick="myFunction()">CERRAR SESIÓN</button>

<script>
function myFunction() {
	gapi.auth2.getAuthInstance().disconnect();
	location.reload();
    window.location.assign("Principal.jsp");
    
}
</script>
 


</body>
</html>