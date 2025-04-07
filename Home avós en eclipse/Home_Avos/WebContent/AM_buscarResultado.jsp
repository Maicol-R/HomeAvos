<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="Modelo.adulto_mayor" %>
<!DOCTYPE html>
<html>
    <head>  
    <link rel="icon" href="images/icono2.ico">
    <link rel="stylesheet" type="text/css" href="EstilosAM/resultadoAM.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado de búsqueda</title>
    </head>
    <body>

        <div>
              <%PrintWriter impresora = response.getWriter();
              impresora.print("<table class='table'>" +
      				"<thead style='background-color:#5005b6; color:#FFFFFF;'>"+
  		  			"<tr>"+
  		  			"<th scope='col'>"+"Nombre completo"+"</th>"+
      		  		"<th scope='col'>"+"Documento"+"</th>"+
      		  		"<th scope='col'>"+"Género"+"</th>"+
      		  		"<th scope='col'>"+"RH"+"</th>"+
      		  		"<th scope='col'>"+"Fecha Nacimiento"+"</th>"+
      		  		"<th scope='col'>"+"Cuidados Especiales"+"</th>"+
      		  		"</tr>"+"</thead>");
                  try {
                    ArrayList <adulto_mayor> lista = new ArrayList();
                    lista = (ArrayList) request.getAttribute("adultoM");
                    
                    for (adulto_mayor elem : lista) {
                    	adulto_mayor ob = (adulto_mayor) elem;
                            impresora.println("<tr>"+
                            		"<td>"+ ob.getNombres() +" "+ ob.getApellidos() +"</td>"+ 
                                    "<td>" + ob.getTipoDocumento() +" "+ ob.getNumDocumento() +"</td>"+
                                    "<td>" + ob.getGenero() +"</td>"+
                                    "<td>" + ob.getRh() +"</td>"+
                                    "<td>" + ob.getFechaNac()+"</td>"+
                                    "<td>" + ob.getCuidadosEspeciales() +"</td>"+
                                    "</tr>");
                        }
                    
                } catch (Exception e) {
                    throw e;
                }
            %>
            </table>
             <input type ="button" class="volver" value ="Volver" onclick="javascript:location.href='AM_index_CRUD.jsp'"/>
          
            
        </div>
        
    </body>
</html>
