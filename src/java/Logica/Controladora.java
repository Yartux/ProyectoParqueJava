/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyart
 */
public class Controladora {
    ControladoraPers ctrl = new ControladoraPers();
    
    public void crearCliente(Cliente cliente){
        ctrl.crearCliente(cliente);
    }
    
    public Cliente traerCliente(int id){
       return ctrl.traerCliente(id);
    }
    
    public List<Cliente> traerClientes(){
        return ctrl.traerClientes();
    }
    
    public void eliminarCliente(int id){
        ctrl.eliminarCliente(id);
    }
    
    public void editarCliente(Cliente cliente){
        ctrl.editarCliente(cliente);
    }
    
    public void crearEmpleado(Empleado empleado){
        ctrl.crearEmpleado(empleado);
    }
    
    public void eliminarEmpleado(int id){
        ctrl.eliminarEmpleado(id);
    }
    
    public void editarEmpleado(Empleado empleado){
        ctrl.editarEmpleado(empleado);
    }
    
    public Empleado traerEmpleado(int id){
        return ctrl.traerEmpleado(id);
    }
    
    public List<Empleado> traerEmpleados(){
        return ctrl.traerEmpleados();
    }
    
    public void crearEntrada(Entrada entrada){
        ctrl.crearEntrada(entrada);
    }
    
    public void editarEntrada(Entrada entrada){
        ctrl.editarEntrada(entrada);
    }
    
    public void eliminarEntrada(int id){
        ctrl.eliminarEntrada(id);
    }
    
    public Entrada traerEntrada(int id){
        return ctrl.traerEntrada(id);
    }
    
    public List<Entrada> traerEntradas(){
        return ctrl.traerEntradas();
    }
    
    public void crearHorario(Horario horario){
        ctrl.crearHorario(horario);
    }
    
    public void eliminarHorario(int id){
        ctrl.eliminarHorario(id);
    }
    
    public void editarHorario(Horario horario){
        ctrl.editarHorario(horario);
    }
    
    public Horario traerHorario(int id){
        return ctrl.traerHorario(id);
    }
    
    public List<Horario> traerHorarios(){
        return ctrl.traerHorarios();
    }
    
    public void crearJuego(Juego juego){
        ctrl.crearJuego(juego);
    }
    
    public void eliminarJuego(int id){
        ctrl.eliminarJuego(id);
    }
    
    public void editarJuego(Juego juego){
        ctrl.editarJuego(juego);
    }
    
    public Juego traerJuego(int id){
        return ctrl.traerJuego(id);
    }
    
    public List<Juego> traerJuegos(){
        return ctrl.traerJuegos();
    }
    
    public void crearUsuario(Usuario usuario){
        ctrl.crearUsuario(usuario);
    }
    
    public void editarUsuario(Usuario usuario){
        ctrl.editarUsuario(usuario);
    }
    
    public void eliminarUsuario(String id){
        ctrl.eliminarUsuario(id);
    }
    
    public Usuario traerUsuario(String id){
        return ctrl.traerUsuario(id);
    }
    
    public List<Usuario> traerUsuarios(){
        return ctrl.traerUsuarios();
    }
    
    public boolean setearUsuarioAdministrador(String username, boolean admin_o_desAdmin){
        List<Usuario> lista = traerUsuarios();
        for (Usuario usuario : lista) {
            if(usuario.getName().equals(username)){
                usuario.setAdmin(admin_o_desAdmin);
                return true;
            }
        }
        return false;
    }
    
    public boolean logearUsuario(String username, String pass){
        List<Usuario> lista = traerUsuarios();
        //busco a mi usuario pasado en parametros
        for (Usuario usuario : lista) {
            if(usuario.getName().equals(username) && usuario.getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public Date DeStringHoraADate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("HH:mm"); //formato barra
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaEnviar;
    }
    
    public Date DeStringADate(String fecha) {                 
        String[] parametroSplit = fecha.split("T");
        String fecha2 = parametroSplit[0] + "/" + parametroSplit[1];
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd/HH:mm"); //formato barra
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha2);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }


}
