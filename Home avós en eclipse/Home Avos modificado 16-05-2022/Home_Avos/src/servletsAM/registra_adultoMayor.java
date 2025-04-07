package servletsAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import javax.swing.JOptionPane;

import DAO_AM.DAO_adultoMayor_Impl;
import DAO_infoP.DAO_infoPostulacion_Impl;
import Modelo.adulto_mayor;
import Modelo.familiar;
import Modelo.hogar_geriatrico;
import Modelo.info_postulacion;
import Modelo.servicios;

/**
 * Servlet implementation class registra_adultoMayor
 */
@WebServlet("/registra_adultoMayor")
public class registra_adultoMayor extends HttpServlet {
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
	    	List <info_postulacion> infoP=null;
	    	List <adulto_mayor> adulto=null;
	    	
	    	List<hogar_geriatrico> hogarG = (ArrayList<hogar_geriatrico>)session.getAttribute("datosHG");
    		List<servicios> serviciosE = (ArrayList<servicios>)session.getAttribute("serviciosEscogidos"); 
    		List<familiar> familiarP = (ArrayList<familiar>)session.getAttribute("datosF");
	    	
	    	PrintWriter out = response.getWriter();
	        DAO_adultoMayor_Impl a=new DAO_adultoMayor_Impl(); 
	        DAO_infoPostulacion_Impl b=new DAO_infoPostulacion_Impl();
	        
	        try {
	            /* TODO output your page here. You may use following sample code. */
	        	
	    		String tipo=request.getParameter("tipoDoc");
	    		long num=Long.parseLong(request.getParameter("Ndoc"));
	    		long numF=familiarP.get(0).getDocumentoFam();
	    		String nom=request.getParameter("nombre");
	    		String ape=request.getParameter("apellido");
	    		String rh=request.getParameter("rh");
	    		String fecha=request.getParameter("fecha");
	    		String genero=request.getParameter("genero");
	    		String cui=request.getParameter("cuidados");
	    		
	    		adulto_mayor ob=new adulto_mayor (num,numF,tipo,nom,ape,rh,genero,fecha,cui);
	    		
	    		
	    		    try{
	    		       a.registrar(ob);
	    	            
	 	               adulto=new ArrayList<adulto_mayor>();
	 	    		   adulto.add(ob);
	 	    		
	 	    		   session.setAttribute("datosAM", adulto);
	 	    		
			    		List<adulto_mayor> adultoP = (ArrayList<adulto_mayor>)session.getAttribute("datosAM");
			    		
			    		long aaa=familiarP.get(0).getDocumentoFam();
			    		long bbb=adultoP.get(0).getNumDocumento();
			    		long ccc=hogarG.get(0).getNit();
			    		long Codpost=(aaa+bbb+ccc)/5;
			    		long nit=hogarG.get(0).getNit();
			    		long docF=familiarP.get(0).getDocumentoFam();
			    		long docAM=adultoP.get(0).getNumDocumento();
			  
			    		String servicios="";
			    		for(servicios aa: serviciosE){
			    		    servicios=servicios+aa.getCodigo()+" ";
			    		    }
			    		Date objDate = new Date();
			    		String fecha_hora=objDate.toString();
			    		String estado="En proceso";
			    		info_postulacion info = new info_postulacion(Codpost, nit, docF, docAM, servicios, fecha_hora, estado);
			    		b.reportarPostulacion(info);
			    		
			    		infoP=new ArrayList<info_postulacion>();
			    		infoP.add(info);
	 	    		   
	    	            String alert="Adulto Mayor postulado EXITOSAMENTE";
	    	        	session.setAttribute("alert", alert);
	    	        	
	    	        	session.setAttribute("reportePostulacion", infoP);
	    		        RequestDispatcher r = request.getRequestDispatcher("reporte_Postulacion.jsp");
	    		        r.forward(request, response);
	    	        	
	    	            }
	    	            catch(Exception e){
	    	            	String alert="ERROR el formulario de postulaci�n est� mal diligenciado o ya realiz� esta postulaci�n con anterioridad";
	    	            	session.setAttribute("alert", alert);
	    	            	RequestDispatcher r = request.getRequestDispatcher("AM_registrar.jsp");
		    		        r.forward(request, response);
	    	            System.out.print("Error en REGISTRAR "+e.getMessage());
	    	            }
	    	        
	    	        
	            
	           
	            
	            
	        } catch(Exception e){
	        	String alert="ERROR el formulario de postulaci�n est� mal diligenciado o ya realiz� esta postulaci�n con anterioridad";
            	session.setAttribute("alert", alert);
	            System.out.println("ERROR en SERVLET Registrar "+e);
	            RequestDispatcher r = request.getRequestDispatcher("AM_registrar.jsp");
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
