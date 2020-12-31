/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author lyart
 */
@Entity
public class Usuario implements Serializable {
    @Id
    private String name;
    @Basic
    private String pass;
    private boolean admin;
    @OneToOne
    private Empleado empleado;
    
    public Usuario() {
    }

    public Usuario(String name, String pass, boolean admin, Empleado empleado) {
        this.name = name;
        this.pass = pass;
        this.admin = admin;
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public void setAllUsuario(String name, String pass, boolean admin) {
        this.name = name;
        this.pass = pass;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
