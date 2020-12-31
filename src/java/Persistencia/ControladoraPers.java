/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Empleado;
import Logica.Entrada;
import Logica.Horario;
import Logica.Juego;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyart
 */
public class ControladoraPers {
    ClienteJpaController clienteJpa = new ClienteJpaController();
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();  
    EntradaJpaController entradaJpa = new EntradaJpaController();
    HorarioJpaController horarioJpa = new HorarioJpaController();
    JuegoJpaController juegoJpa = new JuegoJpaController();

    
    public void crearCliente(Cliente cliente){
        try {
            clienteJpa.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente traerCliente(int id){
       return clienteJpa.findCliente(id);
    }
    
    public List<Cliente> traerClientes(){
        return clienteJpa.findClienteEntities();
    }
    
    public void eliminarCliente(int id){
        try {
            clienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarCliente(Cliente cliente){
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearEmpleado(Empleado empleado){
        try {
            empleadoJpa.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarEmpleado(int id){
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarEmpleado(Empleado empleado){
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Empleado traerEmpleado(int id){
        return empleadoJpa.findEmpleado(id);
    }
    
    public List<Empleado> traerEmpleados(){
        return empleadoJpa.findEmpleadoEntities();
    }
    
    public void crearEntrada(Entrada entrada){
        entradaJpa.create(entrada);
    }
    
    public void editarEntrada(Entrada entrada){
        try {
            entradaJpa.edit(entrada);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarEntrada(int id){
        try {
            entradaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Entrada traerEntrada(int id){
        return entradaJpa.findEntrada(id);
    }
    
    public List<Entrada> traerEntradas(){
        return entradaJpa.findEntradaEntities();
    }
    
    public void crearHorario(Horario horario){
        horarioJpa.create(horario);
    }
    
    public void eliminarHorario(int id){
        try {
            horarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarHorario(Horario horario){
        try {
            horarioJpa.edit(horario);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Horario traerHorario(int id){
        return horarioJpa.findHorario(id);
    }
    
    public List<Horario> traerHorarios(){
        return horarioJpa.findHorarioEntities();
    }
    
    public void crearJuego(Juego juego){
        juegoJpa.create(juego);
    }
    
    public void eliminarJuego(int id){
        try {
            juegoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarJuego(Juego juego){
        try {
            juegoJpa.edit(juego);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Juego traerJuego(int id){
        return juegoJpa.findJuego(id);
    }
    
    public List<Juego> traerJuegos(){
        return juegoJpa.findJuegoEntities();
    }
    
    public void crearUsuario(Usuario usuario){
        try {
            usuarioJpa.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarUsuario(Usuario usuario){
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarUsuario(String id){
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario traerUsuario(String id){
        return usuarioJpa.findUsuario(id);
    }
    
    public List<Usuario> traerUsuarios(){
        return usuarioJpa.findUsuarioEntities();
    }
}
