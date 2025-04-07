package servletsAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_AM.DAO_adultoMayor_Impl;
import Modelo.adulto_mayor;
import Modelo.familiar;

/**
 * Servlet implementation class elimina_adultoMayor
 */
@WebServlet("/elimina_adultoMayor")
public class elimina_adultoMayor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
    	PrintWriter out = response.getWriter();
       DAO_adultoMayor_Impl a=new DAO_adultoMayor_Impl();        
        try {
        	long Ndoc=Long.parseLong(request.getParameter("Ndoc"));
    	
        	List <adulto_mayor> busqueda = new ArrayList(a.buscar(Ndoc));
    		long cond=0;
    		cond=busqueda.get(0).getNumDocumento();
    		
    			a.eliminar(Ndoc);
                String alert="Postulación del adulto mayor "+busqueda.get(0).getNombres()+" "+busqueda.get(0).getApellidos()+" eliminada EXITOSAMENTE";
            	session.setAttribute("alert", alert);
            	RequestDispatcher r = request.getRequestDispatcher("AM_index_CRUD.jsp");
                r.forward(request, response);
    		
   
        } catch(Exception e){
        	String alert="ERROR no se pudo eliminar la postulación deseada";
        	session.setAttribute("alert", alert);
        	System.out.println("Error "+e);
        	RequestDispatcher r = request.getRequestDispatcher("AM_eliminar.jsp");
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
