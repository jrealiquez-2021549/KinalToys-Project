
package dao;
import enums.MetodoPago;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Facturas")
public class Facturas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoFactura")
    private Integer codigoFactura;

    @Column(name = "fechaEmision")
    private LocalDateTime fechaEmision;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "metodoPago")
    private MetodoPago metodoPago;
    
    @Column(name = "total")
    private BigDecimal total;
    
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    
    public Facturas() {
        
    }

    public Integer getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
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
        return "Facturas{" + "codigoFactura=" + codigoFactura + ", fechaEmision=" + fechaEmision + ", metodoPago=" + metodoPago + ", total=" + total + ", codigoUsuario=" + codigoUsuario + '}';
    }
}