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
@WebServlet(name = "EditarCliente", urlPatterns = {"/EditarCliente"})
public class EditarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){
            String client = request.getParameter("cliente");
        if(!"".equals(client)){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String edad = request.getParameter("edad");
            String entrada = request.getParameter("entrada");
            
            Cliente cliente = ctrl.traerCliente(Integer.parseInt(client));
            
            if (!"".equals(nombre)) {
                cliente.setNombre(nombre);
            }
            if (!"".equals(apellido)) {
                cliente.setApellido(apellido);
            }
            if (!"".equals(edad)) {
                cliente.setEdad(Integer.parseInt(edad));
            }
            ctrl.editarCliente(cliente);
            if (!"".equals(entrada)) {
                Entrada entr = ctrl.traerEntrada(Integer.parseInt(entrada));
                entr.setCliente(cliente);
                ctrl.editarEntrada(entr);
            }}
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
