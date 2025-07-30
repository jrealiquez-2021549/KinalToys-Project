
package dao;
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

    @Column(name = "nombreCuenta")
    private String nombreCuenta;

    @Column(name = "correoCuenta")
    private String correoCuenta;
    
    @Column(name = "contrasenaCuenta")
    private String contrasenaCuenta;
    
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    
    public Cuentas() {
        
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
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

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String toString() {
        return "Cuentas{" + "codigoCuenta=" + codigoCuenta + ", nombreCuenta=" + nombreCuenta + ", correoCuenta=" + correoCuenta + ", contrasenaCuenta=" + contrasenaCuenta + ", codigoUsuario=" + codigoUsuario + '}';
    }
}