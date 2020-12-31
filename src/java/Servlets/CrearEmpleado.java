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
@WebServlet(name = "CrearEmpleado", urlPatterns = {"/CrearEmpleado"})
public class CrearEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){
            Empleado emple = new Empleado();
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String username = request.getParameter("usuario");
            
            if (!"".equals(nombre)) {
                emple.setNombre(nombre);
            }
            if (!"".equals(apellido)) {
                emple.setApellido(apellido);
            }
            ctrl.crearEmpleado(emple);
            if (!"".equals(username)) {
                Usuario user = ctrl.traerUsuario(username);
                user.setEmpleado(emple);
                ctrl.editarUsuario(user);
            }
            response.sendRedirect("CrearEmpleado.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
