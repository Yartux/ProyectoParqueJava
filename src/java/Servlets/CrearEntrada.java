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
import java.util.Date;
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
@WebServlet(name = "CrearEntrada", urlPatterns = {"/CrearEntrada"})
public class CrearEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){
        Entrada entrada = new Entrada();
        String parametroHorario = request.getParameter("horario");
        String idcliente = request.getParameter("cliente");
        if (!"".equals(parametroHorario)) {
            Date fechahora = ctrl.DeStringADate(parametroHorario);
            entrada.setHorario(fechahora);
        }
        if (!"".equals(idcliente)) {
            Cliente cliente = ctrl.traerCliente(Integer.parseInt(idcliente));
            entrada.setCliente(cliente);
        }
        ctrl.crearEntrada(entrada);
        response.sendRedirect("CrearEntrada.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
