package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentasDAO extends Conexion {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public Cuentas validar(String email, String password) {
        // Se mantiene el método para el login antiguo si lo necesitas, pero se recomienda usar el nuevo con DPI
        Cuentas cuentas = new Cuentas();
        String sql = "call sp_validarCuentas(?,?,?)";
        try {
            con = Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuentas.setCodigoCuenta(rs.getInt("codigoCuenta"));
                cuentas.setRol(rs.getString("rol"));
                cuentas.setNombreCuenta(rs.getString("nombreCuenta"));
                cuentas.setCorreoCuenta(rs.getString("correoCuenta"));
                cuentas.setContrasenaCuenta(rs.getString("contrasenaCuenta"));
                cuentas.setFotoCuenta(rs.getBytes("fotoCuenta"));
                cuentas.setCodigoCliente(rs.getInt("codigoCliente"));
                cuentas.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
            }
        } catch (SQLException e) {
            System.out.println("El correo o contraseña son incorrectos");
            e.printStackTrace();
        }
        return cuentas;
    }
    
    // Este es el método validar que usaremos con el DPI
    public Cuentas validar(String dpi, String email, String password) {
        Cuentas cuentas = new Cuentas();
        String sql = "{CALL sp_ValidarCuentas(?, ?, ?)}"; 
        
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, dpi);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cuentas.setCodigoCuenta(rs.getInt("codigoCuenta"));
                cuentas.setRol(rs.getString("rol"));
                cuentas.setNombreCuenta(rs.getString("nombreCuenta"));
                cuentas.setCorreoCuenta(rs.getString("correoCuenta"));
                cuentas.setContrasenaCuenta(rs.getString("contrasenaCuenta"));
                cuentas.setCodigoCliente(rs.getInt("codigoCliente"));
                cuentas.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return cuentas;
    }
    
    public List listar() {
        String sql = "call sp_ListarCuentas()";
        List<Cuentas> listaCuentas = new ArrayList<>();
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuentas cu = new Cuentas();
                cu.setCodigoCuenta(rs.getInt(1));
                cu.setRol(rs.getString(2)); // Nuevo campo 'rol'
                cu.setNombreCuenta(rs.getString(3));
                cu.setCorreoCuenta(rs.getString(4));
                cu.setContrasenaCuenta(rs.getString(5));
                cu.setFotoCuenta(rs.getBytes(6));
                cu.setCodigoCliente(rs.getInt(7));
                cu.setCodigoEmpleado(rs.getInt(8));
                listaCuentas.add(cu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCuentas;
    }

    public Cuentas listarId(int id) {
        String sql = "call sp_BuscarCuenta(?)";
        Cuentas cuenta = new Cuentas();
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cuenta.setCodigoCuenta(rs.getInt(1));
                cuenta.setRol(rs.getString(2)); // Nuevo campo 'rol'
                cuenta.setNombreCuenta(rs.getString(3));
                cuenta.setCorreoCuenta(rs.getString(4));
                cuenta.setContrasenaCuenta(rs.getString(5));
                cuenta.setFotoCuenta(rs.getBytes(6));
                cuenta.setCodigoCliente(rs.getInt(7));
                cuenta.setCodigoEmpleado(rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuenta;
    }
    
    // Dentro de la clase CuentasDAO.java
    public byte[] listarFotoPorId(int id) {
        String sql = "SELECT fotoCuenta FROM Cuentas WHERE codigoCuenta = ?";
        byte[] foto = null;
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                foto = rs.getBytes("fotoCuenta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foto;
    }

    public int agregar(Cuentas cuenta) {
        String sql = "call sp_AgregarCuenta(?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getNombreCuenta());
            ps.setString(2, cuenta.getCorreoCuenta());
            ps.setString(3, cuenta.getContrasenaCuenta());
            ps.setBytes(4, cuenta.getFotoCuenta());
            ps.setObject(5, cuenta.getCodigoCliente());
            ps.setObject(6, cuenta.getCodigoEmpleado());
            ps.setString(7, cuenta.getRol());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizar(Cuentas cu, byte[] fotoBytes) {
        String sql = "call sp_EditarCuenta(?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cu.getCodigoCuenta());
            ps.setString(2, cu.getNombreCuenta());
            ps.setString(3, cu.getCorreoCuenta());
            ps.setBytes(4, fotoBytes);
            ps.setObject(5, cu.getCodigoCliente());
            ps.setObject(6, cu.getCodigoEmpleado());
            ps.setString(7, cu.getRol());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "call sp_EliminarCuenta(?)";
        try {
            con = Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}