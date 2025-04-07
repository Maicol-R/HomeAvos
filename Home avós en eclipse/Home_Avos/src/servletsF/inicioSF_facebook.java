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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_HG.DAO_hogarGeriatrico_Impl;
import Modelo.hogar_geriatrico;
import rest_fb.User_Profile;
import rest_fb.Get_User_Details;




/**
 *
 * @author DeividAlexander
 */
@WebServlet("/inicioSF_facebook")
public class inicioSF_facebook extends HttpServlet {

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
    
	String access_token=(String)request.getParameter("access_token");

	Get_User_Details obj_Get_User_Details=new Get_User_Details();
	
	User_Profile obj_User_Profile=obj_Get_User_Details.Get_Profile_info(access_token);
	
	String nombre= obj_User_Profile.getUser_name();
    
        String name="", image="";
        
            try {
            	
          	  image=(String)request.getParameter("imgs");
           
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
              session.setAttribute("imgs", image);
              session.setAttribute("nombre", nombre);
          	//session.setAttribute("correo", email);
              RequestDispatcher r = request.getRequestDispatcher("/F_index_CRUD.jsp");
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
