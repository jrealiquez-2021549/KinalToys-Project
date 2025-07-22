
package com.kinaltoys.dominio;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carritos")
public class Carritos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoCarrito")
    private Integer codigoCarrito;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total")
    private String total;

    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;

    public Carritos() {

    }

    public Integer getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(Integer codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String toString() {
        return "Carritos{" + "codigoCarrito=" + codigoCarrito + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + ", total=" + total + ", codigoUsuario=" + codigoUsuario + '}';
    }
}