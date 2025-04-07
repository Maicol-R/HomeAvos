package servlets_S;


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

import DAO_S.DAO_servicios_Impl;
import Modelo.familiar;
import Modelo.servicios;




@WebServlet("/modifica_servicios")
public class modifica_servicios extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
        	long cod=Long.parseLong(request.getParameter("codS"));
    		String nom=request.getParameter("nom");
    		String descrp=request.getParameter("des");
    		String tiem=request.getParameter("tiem");
    		int cup=Integer.parseInt(request.getParameter("cup"));
    		long prec=Long.parseLong(request.getParameter("prec"));
    
    		servicios ob=new servicios(cod,nom,descrp,tiem,cup,prec);
    		
    	
    		List <servicios> busqueda = new ArrayList(a.buscar(cod));
    		long cond=0;
    		cond=busqueda.get(0).getCodigo();
    		
    			a.modificar(ob);
                String alert="Datos actualizados EXITOSAMENTE";
            	session.setAttribute("alert", alert);
            	RequestDispatcher r = request.getRequestDispatcher("S_index_CRUD.jsp");
                r.forward(request, response);
    		
            
        }catch(Exception e){
        	String alert="ERROR no se pudo ACTUALIZAR correctamente los datos";
        	session.setAttribute("alert", alert);
        	System.out.println("Error "+e);
        	RequestDispatcher r = request.getRequestDispatcher("S_modificar.jsp");
            r.forward(request, response);    
        }finally {}
        
        
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
    	doGet(request,response);
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

    