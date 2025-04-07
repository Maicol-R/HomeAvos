package servletsHG;

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

import DAO_HG.DAO_hogarGeriatrico_Impl;
import DAO_S.DAO_servicios_Impl;
import DAO_V.DAO_valoracion_Impl;
import Modelo.hogar_geriatrico;
import Modelo.servicios;
import Modelo.valoracion;

/**
 * Servlet implementation class mostrarInfo_hogarGeriatrico
 */
@WebServlet("/mostrarInfo_hogarGeriatrico")
public class mostrarInfo_hogarGeriatrico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarInfo_hogarGeriatrico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	
	    DAO_servicios_Impl a = new DAO_servicios_Impl();
	    DAO_hogarGeriatrico_Impl b = new DAO_hogarGeriatrico_Impl();
	    DAO_valoracion_Impl c = new DAO_valoracion_Impl();
	   
	    List <servicios> servicios=null;
	    List <valoracion> comentarios=null;
	    ArrayList <hogar_geriatrico> hogares = new ArrayList();
	
	    long nit=Long.parseLong(request.getParameter("NIT"));
	   
	        try {
	        	
	        
	        	hogares.add(0, (hogar_geriatrico) b.traerInfo(nit)); 	
	        
	        
	        servicios = new ArrayList(a.listarServicios(nit));
	        comentarios = new ArrayList(c.listarValoracion(nit));
	            
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	            session.setAttribute("datosHG", hogares);
	        	session.setAttribute("serviciosHG", servicios);
	        	session.setAttribute("valoracionHG", comentarios);
	            //request.setAttribute("datosHG", HGsession);
	            RequestDispatcher r = request.getRequestDispatcher("/D_Hogar.jsp");
	            r.forward(request, response);
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
