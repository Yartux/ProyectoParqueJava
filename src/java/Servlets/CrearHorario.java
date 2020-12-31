/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Horario;
import Logica.Juego;
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
@WebServlet(name = "CrearHorario", urlPatterns = {"/CrearHorario"})
public class CrearHorario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){
                String horainicio = request.getParameter("horainicio");
                String horafin = request.getParameter("horafin");
                String juego = request.getParameter("juego");
                
                Horario horario = new Horario();
                if (!"".equals(horainicio)) {
                horario.setHoraInicio(ctrl.DeStringHoraADate(horainicio));
                }if (!"".equals(horafin)) {
                horario.setHoraFin(ctrl.DeStringHoraADate(horafin));
                }
                ctrl.crearHorario(horario);
                if (!"".equals(juego)) {
                    Juego jueg = ctrl.traerJuego(Integer.parseInt(juego));
                    jueg.añadirUnHorario(horario);
                    ctrl.editarJuego(jueg);
                }
            response.sendRedirect("CrearHorario.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
