
package com.kinaltoys.dominio;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Juguetes")
public class Juguetes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoJuguete")
    private Integer codigoJuguete;

    @Column(name = "nombreJuguete")
    private String nombreJuguete;

    @Column(name = "precio")
    private BigDecimal precio;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "stock")
    private Integer stock;
    
    @Column(name = "codigoNoticia")
    private Integer codigoNoticia;
    
    public Juguetes() {
        
    }

    public Integer getCodigoJuguete() {
        return codigoJuguete;
    }

    public void setCodigoJuguete(Integer codigoJuguete) {
        this.codigoJuguete = codigoJuguete;
    }

    public String getNombreJuguete() {
        return nombreJuguete;
    }

    public void setNombreJuguete(String nombreJuguete) {
        this.nombreJuguete = nombreJuguete;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCodigoNoticia() {
        return codigoNoticia;
    }

    public void setCodigoNoticia(Integer codigoNoticia) {
        this.codigoNoticia = codigoNoticia;
    }

    @Override
    public String toString() {
        return "Juguetes{" + "codigoJuguete=" + codigoJuguete + ", nombreJuguete=" + nombreJuguete + ", precio=" + precio + ", categoria=" + categoria + ", marca=" + marca + ", stock=" + stock + ", codigoNoticia=" + codigoNoticia + '}';
    }
}