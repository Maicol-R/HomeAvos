
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.familiar" %>

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
      		  			"<th scope='col'>"+"Nombre del familiar"+"</th>"+
	      		  		"<th scope='col'>"+"Documento"+"</th>"+
	      		  		"<th scope='col'>"+"Género"+"</th>"+
	      		  		"<th scope='col'>"+"N° de Contacto"+"</th>"+
	      		  		"<th scope='col'>"+"Dirección de Residencia"+"</th>"+
	      		  		"<th scope='col'>"+"Correo electrónico"+"</th>"+
	      		  		"</tr>"+"</thead>");
                  try {
                    ArrayList <familiar> lista = new ArrayList();
                    lista = (ArrayList) request.getAttribute("familiar");
                    
                    for (familiar elem : lista) {
                            familiar ob = (familiar) elem;
                            impresora.println("<tr>" + 
                            		"<td>"+ob.getNombres()+" "+ob.getApellidos()+"</td>"+ 
                            		"<td>" +ob.getTipoDocumento()+" "+ob.getDocumentoFam() +"</td>"+
                                    "<td>" + ob.getGenero() +"</td>"+
                                    "<td>" + ob.getTelefono() +"</td>"+
                                    "<td>" + ob.getDirección() +"</td>"+
                                    "<td>" + ob.getCorreo() +"</td>"+
                                    "</tr>");
                        }
                    
                } catch (Exception e) {
                    throw e;
                }
            %>
            </table>
             <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='F_index_CRUD.jsp'"/>
          
            
        </div>
    </body>
</html>
