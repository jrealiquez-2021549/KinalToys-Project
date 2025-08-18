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
        }
        return resp;
    }

}