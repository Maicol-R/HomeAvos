<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.administrador" %>

<!DOCTYPE html>
<html>
    <head>
    <link rel="icon" href="images/icono2.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="EstilosF/resultadoF.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Resultado de búsqueda</title>
    </head>
    <body>
        
        <div>
              <%PrintWriter impresora = response.getWriter();
              impresora.print("<table class='table'>" +
        				"<thead style='background-color:#5005b6; color:#FFFFFF;'>"+
      		  			"<tr>"+
      		  			"<th scope='col'>"+"Nombre del administrador"+"</th>"+
	      		  		"<th scope='col'>"+"Documento"+"</th>"+
	      		  		"<th scope='col'>"+"Fecha expedición"+"</th>"+
	      		  		"<th scope='col'>"+"Dirección de Residencia"+"</th>"+
	      		  		"<th scope='col'>"+"Ciudad"+"</th>"+
	      		  		"<th scope='col'>"+"N° de Contacto"+"</th>"+
	      		  		"<th scope='col'>"+"Correo electrónico"+"</th>"+
	      		  		"</tr>"+"</thead>");
                  try {
                    ArrayList <administrador> lista = new ArrayList();
                    lista = (ArrayList) request.getAttribute("administrador");
                    
                    for (administrador elem : lista) {
                            administrador ob = (administrador) elem;
                            impresora.println("<tr>" + 
                            		"<td>"+ob.getNombres()+" "+ob.getApellidos()+"</td>"+ 
                            		"<td>" +ob.getTipoDocumento()+" "+ob.getDocumentoAd() +"</td>"+
                                    "<td>" + ob.getFechaExpe() +"</td>"+
                                    "<td>" + ob.getDirección() +"</td>"+
                                    "<td>" + ob.getCiudad() +"</td>"+
                                    "<td>" + ob.getTelefono() +"</td>"+
                                    "<td>" + ob.getCorreo() +"</td>"+
                                    "</tr>");
                        }
                    
                } catch (Exception e) {
                    throw e;
                }
            %>
            </table>
             <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='AD_index_CRUD.jsp'"/>
          
            
        </div>
    </body>
</html>
