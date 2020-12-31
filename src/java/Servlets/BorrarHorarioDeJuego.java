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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "BorrarHorarioDeJuego", urlPatterns = {"/BorrarHorarioDeJuego"})
public class BorrarHorarioDeJuego extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){

        String idstring = (String) sesion.getAttribute("juego");
        int id = Integer.parseInt(idstring);
        Juego juego = ctrl.traerJuego(id);
        
        String entr = (String) request.getParameter("horario");
        int entradaId = Integer.parseInt(entr);
        Horario entradaTraida = ctrl.traerHorario(entradaId);
        List<Horario> lista2 = new ArrayList<>();
        List<Horario> lista = juego.getListaHorarios();
        for (Horario entrada : lista) {
            if (entrada.getId() == entradaTraida.getId()) {} else {
                lista2.add(entrada);
            }
        }
        
            juego.setListaHorarios(lista2);
                ctrl.editarJuego(juego);
        
        response.sendRedirect("EditarJuego.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
