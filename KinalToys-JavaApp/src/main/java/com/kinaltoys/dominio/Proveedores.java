
package com.kinaltoys.dominio;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class Proveedores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoProveedor")
    private Integer codigoProveedor;

    @Column(name = "nombreProveedor")
    private String nombreProveedor;

    @Column(name = "telefonoProveedor")
    private String telefonoProveedor;
    
    @Column(name = "correoProveedor")
    private String correoProveedor;
    
    @Column(name = "direccionProveedor")
    private String direccionProveedor;

    public Proveedores() {
        
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "codigoProveedor=" + codigoProveedor + ", nombreProveedor=" + nombreProveedor + ", telefonoProveedor=" + telefonoProveedor + ", correoProveedor=" + correoProveedor + ", direccionProveedor=" + direccionProveedor + '}';
    }
}