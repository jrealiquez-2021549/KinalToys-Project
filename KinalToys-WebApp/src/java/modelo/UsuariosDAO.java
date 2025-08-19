package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class UsuariosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
 
    public List<Usuarios> listar() {
        String sql = "call sp_ListarUsuarios()";
        List<Usuarios> listaUsuarios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
 
            while (rs.next()) {
                Usuarios us = new Usuarios();
                us.setCodigoUsuario(rs.getInt(1));
                us.setNombreUsuario(rs.getString(2));
                us.setApellidoUsuario(rs.getString(3));
                us.setDireccionUsuario(rs.getString(4));
                us.setTelefonoUsuario(rs.getString(5));
 
                listaUsuarios.add(us);
            }
 
        } catch (Exception e) {
            System.out.println("Error en UsuariosDAO.listar(): " + e.getMessage());
            e.printStackTrace();
        }
 
        return listaUsuarios;
    }
 
    public int agregar(Usuarios usuario) {
        String sql = "call sp_AgregarUsuario(?, ?, ?, ?)"; 
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getApellidoUsuario());
            ps.setString(3, usuario.getDireccionUsuario());
            ps.setString(4, usuario.getTelefonoUsuario()); 
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}