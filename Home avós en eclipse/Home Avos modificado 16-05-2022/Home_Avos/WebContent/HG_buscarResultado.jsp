<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.hogar_geriatrico" %>

<!DOCTYPE html>
<html>
    <head>
    <link rel="icon" href="images/icono2.ico">
    <meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="EstilosHG/resultadoHG.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Resultado de búsqueda </title>
    </head>
    <body>

        <div>
              <%PrintWriter impresora = response.getWriter();
              impresora.print("<table class='table'>" +
              				"<thead style='background-color:#5005b6; color:#FFFFFF;'>"+
            		  		"<tr>"+
            		  		"<th scope='col'>"+"Hogar geriatrico"+"</th>"+
            		  		"<th scope='col'>"+"NIT"+"</th>"+
            		  		"<th scope='col'>"+"Representante legal"+"</th>"+
            		  		"<th scope='col'>"+"Documento"+"</th>"+
            		  		"<th scope='col'>"+"Telefono"+"</th>"+
            		  		"<th scope='col'>"+"Direccion"+"</th>"+
            		  		"<th scope='col'>"+"Ciudad"+"</th>"+
            		  		"<th scope='col'>"+"Correo electronico"+"</th>"+
            		  		"</tr>"+"</thead>");
                  try {
                    ArrayList <hogar_geriatrico> lista = new ArrayList();
                    
                    lista = (ArrayList) request.getAttribute("hogares");
                                    
                    for (hogar_geriatrico elem : lista) {
                            hogar_geriatrico ob = (hogar_geriatrico) elem;
                            impresora.println("<tr>" + 
                            		"<td>"+ ob.getNom_Residencia() + "</td>" +
                                    "<td>"+ ob.getNit() +"</td>"+
                                    "<td>"+ ob.getRep_Legal() +"</td>"+
                                    "<td>"+ ob.getTipo_Documento()+" "+ob.getNum_Documento() +"</td>"+
                                    "<td>"+ ob.getTelefono2() +"</td>"+
                                    "<td>"+ ob.getDirección() +"</td>"+
                                    "<td>"+ ob.getCiudad() +"</td>"+
                                    "<td>"+ ob.getCorreo() +"</td"+
                                    "</tr>");
                        }

                    
                } catch (Exception e) {
                    throw e;
                }
            %>
            </table>
             <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='HG_index_CRUD.jsp'"/>
         
        </div>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
