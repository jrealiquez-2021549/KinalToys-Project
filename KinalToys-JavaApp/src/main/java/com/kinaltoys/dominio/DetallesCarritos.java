
package com.kinaltoys.dominio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetallesCarritos")
public class DetallesCarritos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoDetalleC")
    private Integer codigoDetalleC;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subTotal")
    private BigDecimal subTotal;

    @Column(name = "descuentoAplicado")
    private BigDecimal descuentoAplicado;

    @Column(name = "codigoCarrito")
    private Integer codigoCarrito;
    
    @Column(name = "codigoJuguete")
    private Integer codigoJuguete;

    public DetallesCarritos() {
    }

    public Integer getCodigoDetalleC() {
        return codigoDetalleC;
    }

    public void setCodigoDetalleC(Integer codigoDetalleC) {
        this.codigoDetalleC = codigoDetalleC;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(BigDecimal descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public Integer getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(Integer codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
    }

    public Integer getCodigoJuguete() {
        return codigoJuguete;
    }

    public void setCodigoJuguete(Integer codigoJuguete) {
        this.codigoJuguete = codigoJuguete;
    }

    @Override
    public String toString() {
        return "DetallesCarritos{" + "codigoDetalleC=" + codigoDetalleC + ", cantidad=" + cantidad + ", subTotal=" + subTotal + ", descuentoAplicado=" + descuentoAplicado + ", codigoCarrito=" + codigoCarrito + ", codigoJuguete=" + codigoJuguete + '}';
    }
}
