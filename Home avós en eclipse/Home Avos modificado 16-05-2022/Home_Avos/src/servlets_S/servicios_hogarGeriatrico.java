package servlets_S;

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

import DAO_HG.DAO_hogarGeriatrico_Impl;
import DAO_S.DAO_servicios_Impl;
import Modelo.hogar_geriatrico;
import Modelo.servicios;

/**
 * Servlet implementation class servicios_hogarGeriatrico
 */
@WebServlet("/servicios_hogarGeriatrico")
public class servicios_hogarGeriatrico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servicios_hogarGeriatrico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    HttpSession session = request.getSession();
		    List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
		    long nit=hogares.get(0).getNit();
		    DAO_servicios_Impl a = new DAO_servicios_Impl();
		    List <servicios> servicios=null;
		    
		        try {
		        	
		        servicios = new ArrayList(a.listarServicios(nit));
		            
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		        
		        if(hogares.get(0).getCod()==0) {
		        	 RequestDispatcher r = request.getRequestDispatcher("/Principal.jsp");
		             r.forward(request, response);
		        }else {
		        	session.setAttribute("serviciosHG", servicios);
		            //request.setAttribute("datosHG", HGsession);
		            RequestDispatcher r = request.getRequestDispatcher("/D_Hogar.jsp");
		            r.forward(request, response);
		        
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
