/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lyart
 */
@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Temporal(TemporalType.TIME)
    private Date horaInicio, horaFin;

    public Horario() {
    }

    public Horario(int id, Date horaInicio, Date horaFin) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public String getHoraInicioFormateada(){
    DateFormat formato = new SimpleDateFormat("HH:mm");
        return formato.format(horaInicio);
    }
    
    public String getHoraFinFormateada(){
    DateFormat formato = new SimpleDateFormat("HH:mm");
        return formato.format(horaFin);
    }
    
    public void setAllHorario(Date horaInicio, Date horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
    
    
}
