/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsHG;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_HG.DAO_hogarGeriatrico_Impl;
import Modelo.familiar;
import Modelo.hogar_geriatrico;





/**
 *
 * @author DeividAlexander
 */
@WebServlet("/mostrarTodo_hogarGeriatrico")
public class mostrarTodo_hogarGeriatrico extends HttpServlet {

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
	session.setAttribute("serviciosAñadidos", null);	
    
    DAO_hogarGeriatrico_Impl a = new DAO_hogarGeriatrico_Impl ();
    List <hogar_geriatrico> hogares= null;
    
    List<familiar> Dfamiliar = (ArrayList<familiar>)session.getAttribute("datosF");
    
        try {
        
        hogares = new ArrayList(a.listar());
        	
            //String n=hogares.get(0).getNom_Residencia();
        } catch (Exception e) {
            System.out.println("error en servlet "+e.getMessage());
        }
        
        if(Dfamiliar==null) {
        	String alert="Debe iniciar sesión como FAMILIAR para continuar";
        	session.setAttribute("alertA", alert);
        	RequestDispatcher r = request.getRequestDispatcher("/Principal.jsp");
            r.forward(request, response);
        }else {
        	session.setAttribute("ALLhogares", hogares);
            RequestDispatcher r = request.getRequestDispatcher("/D_Hogares.jsp");
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
