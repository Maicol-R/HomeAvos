

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.Plan_membresia" %>

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
      		  		    "<th scope='col'>"+"codigo del plan"+"</th>"+		
      		  			"<th scope='col'>"+"Nombre del Plan de membresia"+"</th>"+
      		  			"<th scope='col'>"+"Duracion del Plan de membresia"+"</th>"+
      		  			"<th scope='col'>"+"Descripcion del Plan de membresia"+"</th>"+
      		  			"<th scope='col'>"+"Precio del plan de membresia"+"</th>"+
      		  			"</tr>"+"</thead>");
                  try {
                    ArrayList <Plan_membresia> lista = new ArrayList();
                    lista = (ArrayList) request.getAttribute("Plan membresia");
                    
                    for (Plan_membresia elem : lista) {
                            Plan_membresia ob = (Plan_membresia) elem;
                            impresora.println("<tr>" +
                            		"<td>"+ ob.getcodPlan()+"</td>"+ 
                            		"<td>"+ ob.getnombre()+"</td>"+ 
                            		"<td>"+ ob.getduracion() +"</td>"+
                                    "<td>"+ ob.getdescripcion() +"</td>"+
                                    "<td>" + ob.getprecio() +"</td>"+
                                    "</tr>");
                        }
                    
                } catch (Exception e) {
                    throw e;
                }
            %>
            </table>
            <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='P_index_CRUD.jsp'"/>
          
            
        </div>
    </body>
</html>
