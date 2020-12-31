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
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){
            Usuario user = new Usuario();
                String username = request.getParameter("username");
                String pass = request.getParameter("pass");
                String administrador = request.getParameter("boolean-admin");
                String empleado = request.getParameter("empleado");

                if (!"".equals(username)) {
                    user.setName(username);
                }
                if (!"".equals(pass)) {
                    user.setPass(pass);
                }
                if (!"".equals(administrador)) {
                    if (administrador.equals("0")) {
                    user.setAdmin(false);
                    }else if(administrador.equals("1")){
                    user.setAdmin(true);
                    }
                }
                if (!"".equals(empleado)) {
                    user.setEmpleado(ctrl.traerEmpleado(Integer.parseInt(empleado)));
                }
                ctrl.crearUsuario(user);
            response.sendRedirect("CrearUsuario.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
