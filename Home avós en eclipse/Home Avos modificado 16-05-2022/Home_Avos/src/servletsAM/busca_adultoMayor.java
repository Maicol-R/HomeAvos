package servletsAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_AM.DAO_adultoMayor_Impl;
import DAO_F.DAO_familiar_Impl;
import Modelo.adulto_mayor;
import Modelo.familiar;
import Modelo.hogar_geriatrico;

/**
 * Servlet implementation class busca_adultoMayor
 */
@WebServlet("/busca_adultoMayor")
public class busca_adultoMayor extends HttpServlet {
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

    	ArrayList<adulto_mayor> AM = new ArrayList();
        DAO_adultoMayor_Impl a = new DAO_adultoMayor_Impl ();
        try {
            long dato = Long.parseLong(request.getParameter("Ndoc"));
            AM = (ArrayList) a.buscar(dato);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       // request.getSession().setAttribute("todos", aprendices);//revisar getSession
        request.setAttribute("adultoM", AM);//Se envía con request 
        RequestDispatcher r = request.getRequestDispatcher("AM_buscarResultado.jsp");
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
