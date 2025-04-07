package servletsV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_V.DAO_valoracion_Impl;
import Modelo.familiar;
import Modelo.hogar_geriatrico;
import Modelo.valoracion;

/**
 * Servlet implementation class registro_valoracion
 */
@WebServlet("/registro_valoracion")
public class registro_valoracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registro_valoracion() {
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
        List<familiar> Familiar = (ArrayList<familiar>)session.getAttribute("datosF");
        
        List <valoracion> comentarios=null;
        DAO_valoracion_Impl c = new DAO_valoracion_Impl();
        
        try {
            /* TODO output your page here. You may use following sample code. */
        	
        	long codF=Familiar.get(0).getDocumentoFam();
    		long nit=hogares.get(0).getNit();
    		long cod=(codF+nit)/2;
    		Short val=0;
        	String com=request.getParameter("textCom");
    		valoracion ob=new valoracion(cod,nit,codF,val,com);
    		
    		try{
                a.registrar(ob);
                String alert=" Su comentario fue AGREGADO exitosamente";
                comentarios = new ArrayList(c.listarValoracion(nit));
                session.setAttribute("valoracionHG", comentarios);
            	session.setAttribute("alertB", alert);
            	RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
                r.forward(request, response);
                }
                catch(Exception e){
                	String alert="ERROR no se pudo AGREGAR su comentario ";
                	session.setAttribute("alertE", alert);
                System.out.print("Error en REGISTRAR "+e.getMessage());
                RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
                r.forward(request, response);                }
            } catch(Exception e){
            	String alert="ERROR no se pudo AGREGAR su comentario";
            	session.setAttribute("alertE", alert);
                System.out.println("ERROR en SERVLET Registrar "+e);
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
