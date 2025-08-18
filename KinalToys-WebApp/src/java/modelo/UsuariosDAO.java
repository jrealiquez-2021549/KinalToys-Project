package modelo;
 
import config.Conexion;
import enums.MetodoPago;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
 
public class UsuariosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    public List listar() {
        String sql = "call sp_ListarUsuarios()";
        List<Usuarios> listaUsuarios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setCodigoUsuario(rs.getInt(1));
                usuario.setNombreUsuario(rs.getString(2));
                usuario.setApellidoUsuario(rs.getString(3));
                usuario.setDireccionUsuario(rs.getString(4));
                usuario.setTelefonoUsuario(rs.getString(5));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    public int agregar(Usuarios usuario) {
        String sql = "call sp_AgregarUsuario( ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getApellidoUsuario());
            ps.setString(3, usuario.getDireccionUsuario());
            ps.setString(4, usuario.getTelefonoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    // Método para listar una factura por su ID utilizando el procedimiento almacenado sp_BuscarFactura
    public Usuarios listarId(int id) {
        String sql = "call sp_BuscarUsuario(?)";
        Usuarios usuario = new Usuarios();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setCodigoUsuario(rs.getInt(1));
                usuario.setNombreUsuario(rs.getString(2));
                usuario.setApellidoUsuario(rs.getString(2));
                usuario.setDireccionUsuario(rs.getString(2));
                usuario.setTelefonoUsuario(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    // Método para actualizar una factura existente utilizando el procedimiento almacenado sp_EditarFactura
    public int actualizar(Usuarios usuario) {
        String sql = "call sp_EditarUsuario(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getCodigoUsuario());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getApellidoUsuario());
            ps.setString(4, usuario.getDireccionUsuario());
            ps.setString(5, usuario.getTelefonoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
 
    
    public void eliminar(int id) {
        String sql = "call sp_EliminarUsuario(?)";
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