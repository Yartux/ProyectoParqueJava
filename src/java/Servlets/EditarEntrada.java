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
@WebServlet(name = "EditarEntrada", urlPatterns = {"/EditarEntrada"})
public class EditarEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession sesion = request.getSession(true);
        
        if(sesion.getAttribute("username") != null){
            Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
            
            String entradaid = request.getParameter("entrada");
            String clienteid = request.getParameter("cliente");
            String parametroHorario = request.getParameter("horario");
            
            if (entradaid != null) {
                int entr = Integer.parseInt(entradaid);
                Entrada entrada = ctrl.traerEntrada(entr);
                
                if (!"".equals(parametroHorario)) {
                    Date fechahora = ctrl.DeStringADate(parametroHorario);
                    entrada.setHorario(fechahora);
                } else {
                }
                if (!"".equals(clienteid)) {
                    Cliente cliente = ctrl.traerCliente(Integer.parseInt(clienteid));
                    entrada.setCliente(cliente);
                }
                
                ctrl.editarEntrada(entrada);
                
            }
            response.sendRedirect("EditarEntrada.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
