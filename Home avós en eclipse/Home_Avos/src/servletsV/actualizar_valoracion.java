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
@WebServlet("/actualizar_valoracion")
public class actualizar_valoracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public actualizar_valoracion() {
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
        List<familiar> Fammiliar = (ArrayList<familiar>)session.getAttribute("datosF");
        
        List <valoracion> comentarios=null;
        DAO_valoracion_Impl c = new DAO_valoracion_Impl();
        
        try {
            /* TODO output your page here. You may use following sample code. */
        	
        	long codF=Fammiliar.get(0).getDocumentoFam();
    		long nit=hogares.get(0).getNit();
    		Short val=0;
        	String com=request.getParameter("textComA");
    		valoracion ob=new valoracion(nit,codF,val,com);
    		
    		try{
                a.modificar(ob);
                String alert=" Su comentario fue MODIFICADO exitosamente";
                comentarios = new ArrayList(c.listarValoracion(nit));
                session.setAttribute("valoracionHG", comentarios);
            	session.setAttribute("alertB", alert);
            	RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
                r.forward(request, response);
                }
                catch(Exception e){
                	String alert="ERROR no se pudo MODIFICAR su comentario ";
                	session.setAttribute("alertE", alert);
                System.out.print("Error en MODIFICAR comentario "+e.getMessage());
                RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
                r.forward(request, response);                }
            } catch(Exception e){
            	String alert="ERROR no se pudo MODIFICAR su comentario";
            	session.setAttribute("alertE", alert);
                System.out.println("ERROR en SERVLET Modificar "+e);
                RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
                r.forward(request, response);
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
