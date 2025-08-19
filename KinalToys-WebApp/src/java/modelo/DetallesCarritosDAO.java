package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetallesCarritosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<DetallesCarritos> listar() {
        String sql = "call sp_ListarDetallesCarritos()";
        List<DetallesCarritos> listaDetalles = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
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
        String sql = "call sp_AgregarDetalleCarrito(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
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
    
    public DetallesCarritos listaCodigoDetallesCarritos(int codigo){
        DetallesCarritos dc = new DetallesCarritos();
        
            String sql = "call sp_ListarDetallesCarritosPorCodigo(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                dc.setCodigoDetalleC(rs.getInt(1));
                dc.setCantidad(rs.getInt(2));
                dc.setSubTotal(rs.getBigDecimal(3));
                dc.setDescuentoAplicado(rs.getBigDecimal(4));
                dc.setCodigoCarrito(rs.getInt(5));
                dc.setCodigoJuguete(rs.getInt(6));
            }
            
        } catch (Exception e) {
        }
        return dc;
    }
    
    public int actualizar(DetallesCarritos dc) {
        String sql = "call sp_EditarDetalleCarrito(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, dc.getCodigoDetalleC());
            ps.setInt(2, dc.getCantidad());
            ps.setBigDecimal(3, dc.getSubTotal());
            ps.setBigDecimal(4, dc.getDescuentoAplicado());
            ps.setInt(5, dc.getCodigoCarrito());
            ps.setInt(6, dc.getCodigoJuguete());

            resp = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en actualizar detalle: " + e.getMessage());
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int codigo) {
        String sql = "call sp_EliminarDetalleCarrito(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, codigo); 
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
        
    public DetallesCarritos buscar(int codigo) {
        DetallesCarritos dc = null;
        String sql = "call sp_BuscarDetalleCarrito(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                dc = new DetallesCarritos();
                dc.setCodigoDetalleC(rs.getInt("codigoDetalleC"));
                dc.setCantidad(rs.getInt("cantidad"));
                dc.setSubTotal(rs.getBigDecimal("subTotal"));
                dc.setDescuentoAplicado(rs.getBigDecimal("descuentoAplicado"));
                dc.setCodigoCarrito(rs.getInt("codigoCarrito"));
                dc.setCodigoJuguete(rs.getInt("codigoJuguete"));
            }
        } catch (Exception e) {
        System.out.println("Error en buscar detalle: " + e.getMessage());
        e.printStackTrace();
        }
    return dc;
    }

}