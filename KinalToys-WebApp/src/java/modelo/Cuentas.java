package modelo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cuentas")
public class Cuentas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoCuenta")
    private int codigoCuenta;

    @Column(name = "rol", columnDefinition = "ENUM('Cliente', 'Empleado')")
    private String rol;

    @Column(name = "nombreCuenta")
    private String nombreCuenta;

    @Column(name = "correoCuenta")
    private String correoCuenta;
    
    @Column(name = "contrasenaCuenta")
    private String contrasenaCuenta;
    
    @Column(name = "fotoCuenta")
    private byte[] fotoCuenta;
    
    @Column(name = "codigoCliente")
    private Integer codigoCliente;
    
    @Column(name = "codigoEmpleado")
    private Integer codigoEmpleado;

    // Aquí he agregado el campo del DPI para que se pueda manejar desde el modelo
    @Column(name = "dpiCliente", insertable = false, updatable = false)
    private String dpiCliente;

    @Column(name = "dpiEmpleado", insertable = false, updatable = false)
    private String dpiEmpleado;
    
    public Cuentas() {
        
    }
    
    // Getters y Setters
    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getCorreoCuenta() {
        return correoCuenta;
    }

    public void setCorreoCuenta(String correoCuenta) {
        this.correoCuenta = correoCuenta;
    }

    public String getContrasenaCuenta() {
        return contrasenaCuenta;
    }

    public void setContrasenaCuenta(String contrasenaCuenta) {
        this.contrasenaCuenta = contrasenaCuenta;
    }

    public byte[] getFotoCuenta() {
        return fotoCuenta;
    }

    public void setFotoCuenta(byte[] fotoCuenta) {
        this.fotoCuenta = fotoCuenta;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    public String getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(String dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public String getDpiEmpleado() {
        return dpiEmpleado;
    }

    public void setDpiEmpleado(String dpiEmpleado) {
        this.dpiEmpleado = dpiEmpleado;
    }
    
    @Override
    public String toString() {
        return "Cuentas{" + "codigoCuenta=" + codigoCuenta + ", rol=" + rol + ", nombreCuenta=" + nombreCuenta + ", correoCuenta=" + correoCuenta + ", contrasenaCuenta=" + contrasenaCuenta + ", fotoCuenta=" + fotoCuenta + ", codigoCliente=" + codigoCliente + ", codigoEmpleado=" + codigoEmpleado + ", dpiCliente=" + dpiCliente + ", dpiEmpleado=" + dpiEmpleado + '}';
    }
}