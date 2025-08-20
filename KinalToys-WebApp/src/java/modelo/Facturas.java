package modelo;

import enums.MetodoPago;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @Column(name = "codigoCliente")
    private Integer codigoCliente;
    
    public Facturas() {
    }

    // Este es el metodo para formatear la fecha - jaquino
    public String getFechaEmisionHTML() {
        if (fechaEmision == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaEmision.format(formatter);
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

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return "Facturas{" + "codigoFactura=" + codigoFactura + ", fechaEmision=" + fechaEmision + ", metodoPago=" + metodoPago + ", total=" + total + ", codigoCliente=" + codigoCliente + '}';
    }
}