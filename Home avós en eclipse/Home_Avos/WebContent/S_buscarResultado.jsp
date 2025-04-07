<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.servicios" %>

<!DOCTYPE html>
<html>
    <head>
    <link rel="icon" href="images/icono2.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="EstilosS/resultadoS.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Resultado de búsqueda</title>
    </head>
    <body>
        
        <div>
              <%PrintWriter impresora = response.getWriter();
              impresora.print("<table class='table'>" +
        				"<thead style='background-color:#5005b6; color:#FFFFFF;'>"+
      		  			"<tr>"+
      		  			"<th scope='col'>"+"Nombre del servicio"+"</th>"+
      		  			"<th scope='col'>"+"Descripcion"+"</th>"+
      		  			"<th scope='col'>"+"Tiempo de prestacion"+"</th>"+
      		  			"<th scope='col'>"+"Cupos disponibles"+"</th>"+
      		  			"<th scope='col'>"+"Precio"+"</th>"+
      		  			"</tr>"+"</thead>");
                  try {
                    ArrayList <servicios> lista = new ArrayList();
                    lista = (ArrayList) request.getAttribute("servicios");
                    
                    for (servicios elem : lista) {
                            servicios ob = (servicios) elem;
                            System.out.println(ob.getNombre());
                            impresora.println("<tr>" +
                            		"<td>"+ ob.getNombre()+"</td>"+ 
                            		"<td>"+ ob.getDescrp() +"</td>"+
                                    "<td>"+ ob.getTiempo() +"</td>"+
                                    "<td>" + ob.getCupos() +"</td>"+
                                    "<td>" + ob.getPrecio() +"</td"+
                                    "</tr>");
                        }
                    
                } catch (Exception e) {
                    throw e;
                }
            %>
            </table>
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='S_index_CRUD.jsp'"/>
          
            
        </div>
    </body>
</html>
