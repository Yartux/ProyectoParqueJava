/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import Logica.Juego;
import java.io.IOException;
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
@WebServlet(name = "BorrarEntrada", urlPatterns = {"/BorrarEntrada"})
public class BorrarEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if (sesion.getAttribute("username") != null) {

            String idstring = (String) request.getParameter("entrada");
            int id = Integer.parseInt(idstring);
            Entrada entradaaux = ctrl.traerEntrada(id);
            //elimino la entrada de su juego, si es que algun juego la tiene
            for (Juego juego2 : ctrl.traerJuegos()) {
                if (juego2.getEntrada(id)!=null) {
                if (juego2.getEntrada(id).getId()==entradaaux.getId()) {
                    Juego juego = ctrl.traerJuego(juego2.getId());
                    List<Entrada> aux = juego.getListaEntradas();
                    int buscar = juego.getIndexEntrada(entradaaux);
                    if (buscar !=-1){
                    aux.remove(buscar);}
                    juego.setListaEntradas(aux);
                    ctrl.editarJuego(juego);
                }
                }
            }
            
            ctrl.eliminarEntrada(id);

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
