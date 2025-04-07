package servlets_P;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_AM.DAO_adultoMayor_Impl;
import DAO_P.DAO_Planmembresia_Impl;
import DAO_S.DAO_servicios_Impl;
import Modelo.adulto_mayor;
import Modelo.compra_plan;
import Modelo.familiar;
import Modelo.hogar_geriatrico;
import Modelo.info_postulacion;
import Modelo.servicios;
import Modelo.Plan_membresia;

/**
 * Servlet implementation class registra_Planmembresia
 */
@WebServlet("/registra_Planmembresia")
public class registra_Planmembresia extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	       
	    }

	  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	    /**
	     * Handles the HTTP <code>GET</code> method.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	    	HttpSession session = request.getSession();
	    	List <compra_plan> compraP=null;
	    	List <Plan_membresia> Plan=null;
	    	
	    	PrintWriter out = response.getWriter();
	        DAO_Planmembresia_Impl a=new DAO_Planmembresia_Impl(); 
	        
	        try {
	            /* TODO output your page here. You may use following sample code. */
	        	
	    	
	    		Long codPlan=Long.parseLong(request.getParameter("codPlan"));
	    		String nombre=request.getParameter("nombre");
	    		String duracion=request.getParameter("duracion");
	    		String descripcion=request.getParameter("descripcion");
	    		long precio=Long.parseLong(request.getParameter("precio"));
	    	
	    		
	    		Plan_membresia ob=new Plan_membresia (codPlan,nombre,duracion,descripcion,precio);                     
	    		
	    		
	    		    try{
	    		       a.registrar(ob);
	    	            
	 	               Plan=new ArrayList< Plan_membresia>();
	 	    		   Plan.add(ob);
	 	    		   
	 	    		 
	 	    		   session.setAttribute("datosPM", Plan);
	 	    		  
	 	    		  
	 	    	
	 	    		    List<hogar_geriatrico> hogarG = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
			    		List<compra_plan> datosC = (ArrayList<compra_plan>)session.getAttribute("compraPlan");
			    		List<Plan_membresia> PlanP = (ArrayList<Plan_membresia>)session.getAttribute("datosPM");
			    		
			    					    		
			    		
			    		
			    		long cod_Compra=(PlanP.get(0).getcodPlan()+hogarG.get(0).getNit())/2;
			    		long Nit=hogarG.get(0).getNit();
			    		long codP=PlanP.get(0).getcodPlan();
			    		String metodo_Pago=request.getParameter("metodo_pago");
			    		long valor_Total=Long.parseLong(request.getParameter("precio"));
			    		
			    		
			    		Date objDate = new Date();
			    		String fecha_hora=objDate.toString();
			    		String estado="En proceso";
			    		compra_plan compra = new compra_plan(cod_Compra,Nit,codP,metodo_Pago,valor_Total,fecha_hora,estado);
			    		a.reportarcompraplan(compra);
			    		
			    		compraP=new ArrayList<compra_plan>();
			    		compraP.add(compra);
	    	        	
	    	        	session.setAttribute("compraplan", compraP);
	    		        RequestDispatcher r = request.getRequestDispatcher("compra_plan.jsp");
	    		        r.forward(request, response);
	    	        	
	    	            }
	    	            catch(Exception e){
	    	            	String alert="ERROR";
	    	            	session.setAttribute("alertE", alert);
	    	            	String alert2="Sucedi� un fallo inesperado";
	    	            	session.setAttribute("alertE2", alert2);
	    	            	RequestDispatcher r = request.getRequestDispatcher("D_plan.jsp");
		    		        r.forward(request, response);
	    	            System.out.print("Error en REGISTRAR "+e.getMessage());
	    	            }
	    	        
	    	        
	            
	           
	            
	            
	           
	            }catch(Exception e){
	            	String alert="ERROR";
	            	String alert2="Sucedi� un fallo inesperado";
	            	session.setAttribute("alertE", alert);
	            	session.setAttribute("alertE2", alert2);
	            	RequestDispatcher r = request.getRequestDispatcher("D_plan.jsp");
    		        r.forward(request, response);
	            } finally {
	            	
	            }
	     
	    } 
	           
	    

	    /**
	     * Handles the HTTP <code>POST</code> method.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /**
	     * Returns a short description of the servlet.
	     *
	     * @return a String containing servlet description
	     */
	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>

	}
