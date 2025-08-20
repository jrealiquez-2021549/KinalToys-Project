/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author edvin
 */
@Entity
@Table(name = "Empleados")
public class Empleados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoEmpleado")
    private Integer codigoEmpleado;

    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;

    @Column(name = "apellidoEmpleado")
    private String apellidoEmpleado;

    @Column(name = "direccionEmpleado")
    private String direccionEmpleado;

    @Column(name = "telefonoEmpleado")
    private String telefonoEmpleado;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private Double salario;
    
    @Column(name = "dpiEmpleado")
    private String dpiEmpleado;

    public Empleados() {
    }

    public String getDpiEmpleado() {
        return dpiEmpleado;
    }

    public void setDpiEmpleado(String dpiEmpledo) {
        this.dpiEmpleado = dpiEmpledo;
    }
    
    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}