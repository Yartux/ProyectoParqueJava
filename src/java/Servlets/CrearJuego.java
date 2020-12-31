/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Entrada;
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
@WebServlet(name = "CrearJuego", urlPatterns = {"/CrearJuego"})
public class CrearJuego extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        
        Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
        if(sesion.getAttribute("username") != null){

        String edadstring = request.getParameter("edad");
        int edad = Integer.parseInt(edadstring);
        String nombre = request.getParameter("nombre");
        String entrada = request.getParameter("entrada");
        String empleado = request.getParameter("empleado");
        String horario = request.getParameter("horario");
        
        Juego juego = new Juego();
        
        List<Empleado> listaEmpleado = new ArrayList<>();
        List<Horario> listaHorario = new ArrayList<>();
        List<Entrada> listaEntrada = new ArrayList<>();
        
        if(!(empleado.equals(""))){
        listaEmpleado.add(ctrl.traerEmpleado(Integer.parseInt(empleado)));
        juego.setListaEmpleados(listaEmpleado);
        }else{juego.setListaEmpleados(null);}
        
        if(!(horario.equals(""))){
        listaHorario.add(ctrl.traerHorario(Integer.parseInt(horario)));
        juego.setListaHorarios(listaHorario);
        }else{juego.setListaHorarios(null);}
        
        if(!(entrada.equals(""))){
        listaEntrada.add(ctrl.traerEntrada(Integer.parseInt(entrada)));
        juego.setListaEntradas(listaEntrada);
        }else{juego.setListaEntradas(null);}
        
        juego.setNombre(nombre);
        juego.setEdadMinima(edad);
        
        
        ctrl.crearJuego(juego);
        
        response.sendRedirect("CrearJuego.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
