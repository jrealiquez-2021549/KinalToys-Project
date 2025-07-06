
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
@Table(name = "Noticias")
public class Noticias implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoNoticia")
    private Integer codigoNoticia;

    @Column(name = "encabezado")
    private String encabezado;

    @Column(name = "informacion")
    private String informacion;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "fechaNoticia")
    private LocalDateTime fechaNoticia;
    
    public Noticias() {
        
    } 

    public Integer getCodigoNoticia() {
        return codigoNoticia;
    }

    public void setCodigoNoticia(Integer codigoNoticia) {
        this.codigoNoticia = codigoNoticia;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaNoticia() {
        return fechaNoticia;
    }

    public void setFechaNoticia(LocalDateTime fechaNoticia) {
        this.fechaNoticia = fechaNoticia;
    }

    @Override
    public String toString() {
        return "Noticias{" + "codigoNoticia=" + codigoNoticia + ", encabezado=" + encabezado + ", informacion=" + informacion + ", categoria=" + categoria + ", fechaNoticia=" + fechaNoticia + '}';
    }    
}
