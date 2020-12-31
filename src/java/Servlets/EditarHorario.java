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
@WebServlet(name = "EditarHorario", urlPatterns = {"/EditarHorario"})
public class EditarHorario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){
                String horarioid = request.getParameter("horario");
                String horainicio = request.getParameter("horainicio");
                String horafin = request.getParameter("horafin");
                String juego = request.getParameter("juego");
                
                Horario horario = ctrl.traerHorario(Integer.parseInt(horarioid));
                if (!"".equals(horainicio)) {
                horario.setHoraInicio(ctrl.DeStringHoraADate(horainicio));
                }if (!"".equals(horafin)) {
                horario.setHoraFin(ctrl.DeStringHoraADate(horafin));
                }
                ctrl.editarHorario(horario);
                if (!"".equals(juego)) {
                    Juego jueg = ctrl.traerJuego(Integer.parseInt(juego));
                    if (jueg.getListaHorarios().contains(horario)){
                    } else{
                    jueg.añadirUnHorario(horario);
                    ctrl.editarJuego(jueg);
                }}
            response.sendRedirect("EditarHorario.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
