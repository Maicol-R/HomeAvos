/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsF;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_AD.DAO_administrador_Impl;
import DAO_F.DAO_familiar_Impl;
import DAO_HG.DAO_hogarGeriatrico_Impl;
import Modelo.administrador;
import Modelo.familiar;
import Modelo.hogar_geriatrico;





/**
 *
 * @author DeividAlexander
 */
@WebServlet("/inicioS_familiar")
public class inicioS_familiar extends HttpServlet {

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
    //List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)HGsession.getAttribute("datosHG");
    ArrayList <familiar> Dfamiliar = new ArrayList();
    DAO_familiar_Impl a = new DAO_familiar_Impl ();
        
        try {
        	
            String correo = request.getParameter("correoISF");
            String contr =request.getParameter("contraISF");
            
            request.setAttribute("correo", correo);
            request.setAttribute("contr", contr);
           
            Dfamiliar.add(0, (familiar) a.iniciarSesion(correo, contr)); 
        } catch (Exception e) {
           
       	    RequestDispatcher r = request.getRequestDispatcher("/inicioS_administrador");
            r.forward(request, response);
        }
        
        if(Dfamiliar.get(0).getDocumentoFam()==0) {
        	
        	 RequestDispatcher r = request.getRequestDispatcher("/inicioS_administrador");
             r.forward(request, response);     
        }
        
        if(Dfamiliar.get(0).getDocumentoFam()!=0) {
        	System.out.println("familiar");
        	String alert="Usuario V�lido";
        	session.setAttribute("alertB", alert);
        	String alert2="Bienvenido(a) FAMILIAR "+Dfamiliar.get(0).getNombres()+" "+Dfamiliar.get(0).getApellidos();
        	session.setAttribute("alertB2", alert2);
        	session.setAttribute("imgs", null);
			session.setAttribute("nombre", null);
        	session.setAttribute("datosF", Dfamiliar);
            RequestDispatcher r = request.getRequestDispatcher("/F_index_CRUD.jsp");
            r.forward(request, response);
        
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
        doGet(request, response);
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
