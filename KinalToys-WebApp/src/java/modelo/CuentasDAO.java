
package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Cuentas validar(String email, String password) {
        //Instanciar el objeto de la entidad Cuentas
        Cuentas cuentas = new Cuentas();
        String sql = "select * from Cuentas where correoCuenta = ? and contrasenaCuenta = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuentas.setCodigoCuenta(rs.getInt("codigoCuenta"));
                cuentas.setNombreCuenta(rs.getString("nombreCuenta"));
                cuentas.setCorreoCuenta(rs.getString("correoCuenta"));
                cuentas.setContrasenaCuenta(rs.getString("contrasenaCuenta"));
                cuentas.setFotoCuenta(rs.getBytes("fotoCuenta"));
                cuentas.setCodigoUsuario(rs.getInt("codigoUsuario"));
            }
        } catch (Exception e) {
            System.out.println("El correo o contraseña son incorrectos");
            e.printStackTrace();
        }
        return cuentas; //Cuenta encontrada
    }
    
    public List listar() {
        String sql = "call sp_ListarCuentas()";
        List<Cuentas> listaCuentas = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuentas cu = new Cuentas();
                cu.setCodigoCuenta(rs.getInt(1));
                cu.setNombreCuenta(rs.getString(2));
                cu.setCorreoCuenta(rs.getString(3));
                cu.setContrasenaCuenta(rs.getString(4));
                cu.setFotoCuenta(rs.getBytes(5));
                cu.setCodigoUsuario(rs.getInt(6));
                listaCuentas.add(cu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCuentas;
    }
    
    public Cuentas listarPorId(int id) {
        String sql = "select * from Cuentas where codigoCuenta = ?";
        Cuentas cuenta = new Cuentas();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cuenta.setCodigoCuenta(rs.getInt(1));
                cuenta.setNombreCuenta(rs.getString(2));
                cuenta.setCorreoCuenta(rs.getString(3));
                cuenta.setContrasenaCuenta(rs.getString(4));
                cuenta.setFotoCuenta(rs.getBytes(5));
                cuenta.setCodigoUsuario(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuenta;
    }
    
    public int agregar(Cuentas cuenta) {
        String sql = "call sp_AgregarCuenta(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getNombreCuenta());
            ps.setString(2, cuenta.getCorreoCuenta());
            ps.setString(3, cuenta.getContrasenaCuenta());
            ps.setBytes(4, cuenta.getFotoCuenta());
            ps.setInt(5, cuenta.getCodigoUsuario());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // Método para listar una cuenta por su ID utilizando el procedimiento almacenado sp_BuscarCuenta
    public Cuentas listarId(int id) {
        String sql = "call sp_BuscarCuenta(?)";
        Cuentas cuenta = new Cuentas();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cuenta.setCodigoCuenta(rs.getInt(1));
                cuenta.setNombreCuenta(rs.getString(2));
                cuenta.setCorreoCuenta(rs.getString(3));
                cuenta.setContrasenaCuenta(rs.getString(4));
                cuenta.setFotoCuenta(rs.getBytes(5));
                cuenta.setCodigoUsuario(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuenta;
    }
    
    // Método para actualizar una cuenta existente utilizando el procedimiento almacenado sp_EditarCuenta
    public int actualizar(Cuentas cu, byte[] fotoBytes) {
        String sql = "call sp_EditarCuenta(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cu.getCodigoCuenta());
            ps.setString(2, cu.getNombreCuenta());
            ps.setString(3, cu.getCorreoCuenta());
            ps.setBytes(4, fotoBytes);
            ps.setInt(5, cu.getCodigoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Método para eliminar una cuenta por su ID utilizando el procedimiento almacenado sp_EliminarCuenta
    public void eliminar(int id) {
        String sql = "call sp_EliminarCuenta(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}