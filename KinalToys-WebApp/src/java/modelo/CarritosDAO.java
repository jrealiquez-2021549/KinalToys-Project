package modelo;

import config.Conexion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CarritosDAO {

    /*CarritosDAO carritosDAO = new CarritosDAO();*/
    Carritos carritos = new Carritos();
    int codigoCarrito;

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<Carritos> listar() {
        String sql = "{call sp_ListarCarritos()}";
        List<Carritos> listarCarritos = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Carritos cr = new Carritos();
                cr.setCodigoCarrito(rs.getInt(1));
                cr.setFechaCreacion(rs.getTimestamp(2).toLocalDateTime());
                cr.setEstado(rs.getString(3));
                cr.setTotal(rs.getDouble(4));
                cr.setCodigoUsuario(rs.getInt(5));
                listarCarritos.add(cr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listarCarritos;
    }

    public int agregar(Carritos cr) {
        String sql = "{call sp_AgregarCarrito(?, ?, ?, ?)}";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(cr.getFechaCreacion()));
            ps.setString(2, cr.getEstado());
            ps.setBigDecimal(3, new BigDecimal(cr.getTotal()));
            ps.setInt(4, cr.getCodigoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}