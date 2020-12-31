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
@WebServlet(name = "BorrarEmpleado", urlPatterns = {"/BorrarEmpleado"})
public class BorrarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){

        String empleado = request.getParameter("empleado");
        Empleado empleadoAEliminar = ctrl.traerEmpleado(Integer.parseInt(empleado));
            for (Usuario user : ctrl.traerUsuarios()) {
                if (empleadoAEliminar.getId()==user.getEmpleado().getId()) {
                    Usuario user2 = ctrl.traerUsuario(user.getName());
                    user2.setEmpleado(null);
                    ctrl.editarUsuario(user2);
                }
            }
        ctrl.eliminarEmpleado(Integer.parseInt(empleado));
        
        response.sendRedirect("EditarEmpleado.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
