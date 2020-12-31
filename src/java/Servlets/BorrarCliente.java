/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Entrada;
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
@WebServlet(name = "BorrarCliente", urlPatterns = {"/BorrarCliente"})
public class BorrarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if (sesion.getAttribute("username") != null) {

            String idstring = (String) request.getParameter("cliente");
            Cliente clienteAEliminar = ctrl.traerCliente(Integer.parseInt(idstring));
            //esto elimina el cliente de una entrada si es que alguna lo tiene
            for (Entrada object : ctrl.traerEntradas()) {
                if (object.getCliente().getId()==clienteAEliminar.getId()) {
                    Entrada aux = ctrl.traerEntrada(object.getId());
                    aux.setCliente(null);
                    ctrl.editarEntrada(aux);
                }
            }
            
            ctrl.eliminarCliente(Integer.parseInt(idstring));

            response.sendRedirect("EditarCliente.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
