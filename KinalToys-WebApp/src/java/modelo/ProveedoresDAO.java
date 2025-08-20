package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List<Proveedores> listar() {
        String sql = "call sp_ListarProveedores()";
        List<Proveedores> listaProveedores = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedores prov = new Proveedores();
                prov.setCodigoProveedor(rs.getInt("codigoProveedor"));
                prov.setNombreProveedor(rs.getString("nombreProveedor"));
                prov.setTelefonoProveedor(rs.getString("telefonoProveedor"));
                prov.setCorreoProveedor(rs.getString("correoProveedor"));
                prov.setDireccionProveedor(rs.getString("direccionProveedor"));
                listaProveedores.add(prov);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaProveedores;
    }
    
    public int agregar(Proveedores prov) {
        String sql = "call sp_AgregarProveedor(?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getTelefonoProveedor());
            ps.setString(3, prov.getCorreoProveedor());
            ps.setString(4, prov.getDireccionProveedor());
            resp = ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            resp = 0; 
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
    
    public Proveedores listarCodigoProveedor(int id) {
        Proveedores prov = null;
        // Corrección: usar un stored procedure específico para obtener por ID
        String sql = "SELECT * FROM Proveedores WHERE codigoProveedor = ?"; 
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); 
            rs = ps.executeQuery();
            if (rs.next()) { 
                prov = new Proveedores(); 
                prov.setCodigoProveedor(rs.getInt("codigoProveedor"));
                prov.setNombreProveedor(rs.getString("nombreProveedor"));
                prov.setTelefonoProveedor(rs.getString("telefonoProveedor"));
                prov.setCorreoProveedor(rs.getString("correoProveedor"));
                prov.setDireccionProveedor(rs.getString("direccionProveedor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prov; 
    }
    
    public int actualizar(Proveedores prov) {
        String sql = "call sp_EditarProveedor(?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getCodigoProveedor()); // Parámetro 1: código
            ps.setString(2, prov.getNombreProveedor()); // Parámetro 2: nombre
            ps.setString(3, prov.getTelefonoProveedor()); // Parámetro 3: teléfono
            ps.setString(4, prov.getCorreoProveedor()); // Parámetro 4: correo
            ps.setString(5, prov.getDireccionProveedor()); // Parámetro 5: dirección
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resp = 0;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
 
    public int eliminar(int id) { // Corrección: retornar int
        String sql = "call sp_EliminarProveedor(?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Corrección: agregar parámetro
            resp = ps.executeUpdate(); // Corrección: capturar resultado
        } catch (Exception e) {
            e.printStackTrace();
            resp = 0;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
}
