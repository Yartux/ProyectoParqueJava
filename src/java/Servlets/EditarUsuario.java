/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
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
@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);

        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if (sesion.getAttribute("username") != null) {
            String user = request.getParameter("usuario");
            if (!"".equals(user)) {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String admin = request.getParameter("bool-admin");
                String empleado = request.getParameter("empleado");

                Usuario usuario = ctrl.traerUsuario(user);

                if (!"".equals(empleado)) {
                    Empleado empleado1 = ctrl.traerEmpleado(Integer.parseInt(empleado));
                    usuario.setEmpleado(empleado1);
                }

                if (!"".equals(name)) {
                    usuario.setName(name);
                }
                if (!"".equals(password)) {
                    usuario.setPass(password);
                }
                if (!"".equals(admin)) {
                    if (admin.equals("0")) {
                        usuario.setAdmin(true);
                    } else if (admin.equals("1")) {
                        usuario.setAdmin(false);
                    }
                }
                ctrl.editarUsuario(usuario);
            }
            response.sendRedirect("EditarUsuario.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
