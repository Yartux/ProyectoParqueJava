/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lyart
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("username");
        String password = request.getParameter("pass");

        request.getSession().setAttribute("username", nombre);
        request.getSession().setAttribute("pass", password);

        Controladora ctrl = new Controladora();
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("ctrl", ctrl);
        
//      Crear el primer usuario y no quedarse en bucle join
        if (ctrl.traerUsuarios().isEmpty()) {
        Usuario user = new Usuario("admin", "admin", true, null);
        ctrl.crearUsuario(user);
        }
        
        if (ctrl.logearUsuario(nombre, password)) {
            sesion.setAttribute("user", nombre);

            if (ctrl.traerUsuario(nombre).isAdmin()) {
                sesion.setAttribute("admin", true);
            } else {
                sesion.setAttribute("admin", false);
            }

            response.sendRedirect("index.jsp");
        } else {
            sesion.setAttribute("log", true);
            response.sendRedirect("Login_error.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
