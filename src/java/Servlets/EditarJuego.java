/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
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
@WebServlet(name = "EditarJuego", urlPatterns = {"/EditarJuego"})
public class EditarJuego extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(true);
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
                if(sesion.getAttribute("username") != null){

        String edad = request.getParameter("edad");
        String nombre = request.getParameter("nombre");
        String entrada = request.getParameter("entrada");
        String empleado = request.getParameter("empleado");
        String horario = request.getParameter("horario");
        
        String jueg = request.getParameter("juego");
        
        Juego juego = ctrl.traerJuego(Integer.parseInt(jueg));
        


        if(!(empleado.equals(""))){
        juego.getListaEmpleados().add(ctrl.traerEmpleado(Integer.parseInt(empleado)));
        }
        
        if(!(horario.equals(""))){
        juego.getListaHorarios().add(ctrl.traerHorario(Integer.parseInt(horario)));
        }
        
        if(!(entrada.equals(""))){
        juego.getListaEntradas().add(ctrl.traerEntrada(Integer.parseInt(entrada)));
        }
        
        if (!(nombre.equals(""))) {
        juego.setNombre(nombre);
        }
        
        if (!(edad.equals(""))){
        juego.setEdadMinima(Integer.parseInt(edad));
        }
        
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
