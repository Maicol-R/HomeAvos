package servlets_S;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_F.DAO_familiar_Impl;
import DAO_S.DAO_servicios_Impl;
import Modelo.familiar;
import Modelo.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/elimina_servicios")
public class elimina_servicios extends HttpServlet {

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
     DAO_servicios_Impl a=new DAO_servicios_Impl();        
        try {
        	long cod=Long.parseLong(request.getParameter("codS"));
    	
        	List <servicios> busqueda = new ArrayList(a.buscar(cod));
    		long cond=0;
    		cond=busqueda.get(0).getCodigo();
    		
    			a.eliminar(cod);
                String alert="Servicio '"+busqueda.get(0).getNombre()+"' eliminado EXITOSAMENTE";
            	session.setAttribute("alert", alert);
            	RequestDispatcher r = request.getRequestDispatcher("S_index_CRUD.jsp");
                r.forward(request, response);
    			
   
        } catch(Exception e){
        	String alert="ERROR no se pudo eliminar el servicio deseado";
        	session.setAttribute("alert", alert);
        	System.out.println("Error "+e);
        	RequestDispatcher r = request.getRequestDispatcher("S_eliminar.jsp");
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
