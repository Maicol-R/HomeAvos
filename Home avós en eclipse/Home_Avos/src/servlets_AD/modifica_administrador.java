package servlets_AD;

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

import DAO_AD.DAO_administrador_Impl;
import Modelo.administrador;

/**
 * Servlet implementation class modifica_administrador
 */
@WebServlet("/modifica_administrador")
public class modifica_administrador extends HttpServlet {
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
     DAO_administrador_Impl a=new DAO_administrador_Impl();        
        try {
            /* TODO output your page here. You may use following sample code. */
        	
        	
    		String nom=request.getParameter("nomAD");
    		String apll=request.getParameter("apllAD");
    		String dir=request.getParameter("direccionAD");
    		String ciudad=request.getParameter("ciudadAD");
    		long tel=Long.parseLong(request.getParameter("NcontactoAD"));
    		String correo=request.getParameter("correoAD");
    		String contra=request.getParameter("contraAD");
    
    		administrador ob=new administrador(tel,tel,dir,correo,contra,nom,apll,ciudad);
    		
    			a.modificar(ob);
                String alert="Datos actualizados EXITOSAMENTE";
            	session.setAttribute("alert", alert);
            	RequestDispatcher r = request.getRequestDispatcher("AD_index_CRUD.jsp");
                r.forward(request, response);
            
            
        }catch(Exception e){
        	String alert="ERROR no se pudo ACTUALIZAR correctamente los datos";
        	session.setAttribute("alert", alert);
        	System.out.println("Error "+e);
        	RequestDispatcher r = request.getRequestDispatcher("AD_modificar.jsp");
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
