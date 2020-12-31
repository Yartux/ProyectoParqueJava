/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lyart
 */
 @Entity
public class Juego implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private int edadMinima;
    private String nombre;
    @OneToMany
    private List<Entrada> listaEntradas;
    @OneToMany
    private List<Empleado> listaEmpleados;
    @OneToMany
    private List<Horario> listaHorarios;

    public Juego() {
    }
    
    public void añadirUnaEntrada(Entrada entrada){
        listaEntradas.add(entrada);
    }
    
    public void añadirUnEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }
    
    public void añadirUnHorario(Horario horario){
        listaHorarios.add(horario);
    }

    public Juego(int id, int edadMinima, String nombre, List<Entrada> listaEntradas, List<Empleado> listaEmpleados, List<Horario> listaHorarios) {
        this.id = id;
        this.edadMinima = edadMinima;
        this.nombre = nombre;
        this.listaEntradas = listaEntradas;
        this.listaEmpleados = listaEmpleados;
        this.listaHorarios = listaHorarios;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
    
    public void setAllJuego(int id, String nombre, List<Entrada> listaEntradas, List<Empleado> listaEmpleados, List<Horario> listaHorarios, int edadMinima) {
        this.id = id;
        this.nombre = nombre;
        this.listaEntradas = listaEntradas;
        this.listaEmpleados = listaEmpleados;
        this.listaHorarios = listaHorarios;
        this.edadMinima = edadMinima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Entrada getEntrada(int id){
        for (Entrada entrada : listaEntradas) {
            if (entrada.getId()==id) {
                return entrada;
            }
        }
        return null;
    }
    
    public int getIndexEntrada(Entrada entrada){
        int i = 0;
        for (Entrada listaEntrada : listaEntradas) {
            if (listaEntrada.getId()==entrada.getId()) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public int getIndexHorario(Horario horario){
        int i = 0;
        for (Horario horario2 : listaHorarios) {
            if (horario2.getId()==horario.getId()) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }
    
    
}
