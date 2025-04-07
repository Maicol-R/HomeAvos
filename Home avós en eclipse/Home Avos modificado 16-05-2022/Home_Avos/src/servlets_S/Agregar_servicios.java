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
import javax.swing.JOptionPane;

import DAO_HG.DAO_hogarGeriatrico_Impl;
import DAO_S.DAO_servicios_Impl;
import Modelo.hogar_geriatrico;
import Modelo.servicios;


/**
 * Servlet implementation class A�adir_servicios
 */
@WebServlet("/Agregar_servicios")
public class Agregar_servicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Agregar_servicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		long codServ=Long.parseLong(request.getParameter("codServ"));
		
	    List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
	    List<servicios> Listservicios = (ArrayList<servicios>)session.getAttribute("serviciosHG");
	    List<servicios> serviciosAgregados = (ArrayList<servicios>)session.getAttribute("serviciosEscogidos");
	    
	    if(serviciosAgregados==null) {
	    	serviciosAgregados=new ArrayList();
	    }
	    
	    long NIT=hogares.get(0).getNit();
	    
	    DAO_servicios_Impl a = new DAO_servicios_Impl();
	    
			if(request.getParameter("codServ")!=null){			
					for(servicios ob:Listservicios){					
						if((ob.getCodigo()==codServ)){
							serviciosAgregados.add(0, ob);	
							String alert="El servicio '"+serviciosAgregados.get(0).getNombre()+"' fue agregado EXITOSAMENTE";
				        	session.setAttribute("alertB", alert);
						
						}
						
					}									
			}				
				
			session.setAttribute("serviciosEscogidos", serviciosAgregados);		
			RequestDispatcher r = request.getRequestDispatcher("D_Hogar.jsp");
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
