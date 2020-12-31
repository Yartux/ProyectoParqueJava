/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lyart
 */
@Entity
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @OneToOne
    private Cliente cliente;

    public Entrada() {
    }
    
    public String getHorarioEnFormato(){
        SimpleDateFormat formatodia = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm"); //formato barra
        return formatodia.format(horario) + " a las " + formatohora.format(horario);
    }
    
    public Entrada(int id, Date horario, Cliente cliente) {
        this.id = id;
        this.horario = horario;
        this.cliente = cliente;
    }
    
    public void setAllEntrada(int id, Date horario, Cliente cliente) {
        this.id = id;
        this.horario = horario;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
