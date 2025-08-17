package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class DetallesCarritosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<DetallesCarritos> listar() {
        String sql = "CALL sp_ListarDetallesCarritos()";
        List<DetallesCarritos> listaDetalles = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetallesCarritos dc = new DetallesCarritos();
                dc.setCodigoDetalleC(rs.getInt(1));
                dc.setCantidad(rs.getInt(2));
                dc.setSubTotal(rs.getBigDecimal(3));
                dc.setDescuentoAplicado(rs.getBigDecimal(4));
                dc.setCodigoCarrito(rs.getInt(5));
                dc.setCodigoJuguete(rs.getInt(6));

                listaDetalles.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Error en listar detalles: " + e.getMessage());
            e.printStackTrace();
        }
        return listaDetalles;
    }

    public int agregar(DetallesCarritos detalle) {
        String sql = "CALL sp_AgregarDetalleCarrito(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setBigDecimal(2, detalle.getSubTotal());
            ps.setBigDecimal(3, detalle.getDescuentoAplicado());
            ps.setInt(4, detalle.getCodigoCarrito());
            ps.setInt(5, detalle.getCodigoJuguete());

            resp = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en agregar detalle: " + e.getMessage());
            e.printStackTrace();
        }
        return resp;
    }
}