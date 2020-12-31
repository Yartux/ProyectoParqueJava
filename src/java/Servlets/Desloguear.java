/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lyart
 */
@WebServlet(name = "Desloguear", urlPatterns = {"/Desloguear"})
public class Desloguear extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("username", null);
        request.getSession().setAttribute("pass", null);

        response.sendRedirect("Login.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
