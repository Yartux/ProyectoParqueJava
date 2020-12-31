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
@WebServlet(name = "BorrarHorario", urlPatterns = {"/BorrarHorario"})
public class BorrarHorario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if (sesion.getAttribute("username") != null) {

            String horarioid = (String) request.getParameter("horario");

            if (!"".equals(horarioid)) {
                Horario horario = ctrl.traerHorario(Integer.parseInt(horarioid));
                for (Juego traerJuego : ctrl.traerJuegos()) {
                    if (traerJuego.getIndexHorario(horario) != -1 ) {
                        for (Horario listaHorario : traerJuego.getListaHorarios()) {
                            if (listaHorario.getId() == horario.getId()) {
                                    traerJuego.getListaHorarios().remove(traerJuego.getIndexHorario(horario));
                            }
                        }
                    }
                }
            }
            ctrl.eliminarHorario(Integer.parseInt(horarioid));

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
