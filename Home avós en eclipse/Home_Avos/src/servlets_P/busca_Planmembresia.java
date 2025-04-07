package servlets_P;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_P.DAO_Planmembresia_Impl;
import Modelo.Plan_membresia;


@WebServlet("/busca_Planmembresia")
public class busca_Planmembresia extends  HttpServlet {
	
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

        ArrayList<Plan_membresia> Plan_membresia = new ArrayList();
        DAO_Planmembresia_Impl a = new DAO_Planmembresia_Impl ();
        try {
            long dato = Long.parseLong(request.getParameter("dato"));
            Plan_membresia = (ArrayList) a.buscar(dato);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       // request.getSession().setAttribute("todos", aprendices);//revisar getSession
        request.setAttribute("Planmembresia", Plan_membresia);//Se envía con request 
        RequestDispatcher r = request.getRequestDispatcher("P_buscarResultado.jsp");
        r.forward(request, response);

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
