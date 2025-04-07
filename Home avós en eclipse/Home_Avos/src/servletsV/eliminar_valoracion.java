package servletsV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_V.DAO_valoracion_Impl;
import Modelo.familiar;
import Modelo.hogar_geriatrico;
import Modelo.valoracion;

/**
 * Servlet implementation class registro_valoracion
 */
@WebServlet("/eliminar_valoracion")
public class eliminar_valoracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminar_valoracion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        DAO_valoracion_Impl a=new DAO_valoracion_Impl(); 
        
        HttpSession session = request.getSession();
        List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
        List<familiar> Familliar = (ArrayList<familiar>)session.getAttribute("datosF");
        
        List <valoracion> comentarios=null;
        DAO_valoracion_Impl c = new DAO_valoracion_Impl();
        
        try {
            /* TODO output your page here. You may use following sample code. */
        	
        	long codF=Familliar.get(0).getDocumentoFam();
    		long nit=hogares.get(0).getNit();
    		
    		valoracion ob=new valoracion(nit,codF);
    		
    		try{
                a.eliminar(ob);
                String alert=" Su comentario fue ELIMINADO exitosamente";
                comentarios = new ArrayList(c.listarValoracion(nit));
                session.setAttribute("valoracionHG", comentarios);
            	session.setAttribute("alertB", alert);
            	RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
                r.forward(request, response);
                }
                catch(Exception e){
                	String alert="ERROR no se pudo ELIMINAR su comentario ";
                	session.setAttribute("alertE", alert);
                System.out.print("Error en ELIMINAR COMENTARIO "+e.getMessage());
                               }
            } catch(Exception e){
            	String alert="ERROR no se pudo ELIMINAR su comentario";
            	session.setAttribute("alertE", alert);
                System.out.println("ERROR en SERVLET Eliminar "+e);
               
                } finally {
                	
                }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
