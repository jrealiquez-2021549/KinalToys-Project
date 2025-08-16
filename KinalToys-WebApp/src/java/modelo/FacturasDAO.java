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
 
public class FacturasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    public List listar() {
        String sql = "call sp_ListarFacturas()";
        List<Facturas> listaFacturas = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Facturas factura = new Facturas();
                factura.setCodigoFactura(rs.getInt(1));
                // Convertir Timestamp a LocalDateTime
                Timestamp timestamp = rs.getTimestamp(2);
                if (timestamp != null) {
                    factura.setFechaEmision(timestamp.toLocalDateTime());
                }
                // Convertir String a enum MetodoPago
                String metodoPagoStr = rs.getString(3);
                if (metodoPagoStr != null) {
                    factura.setMetodoPago(MetodoPago.valueOf(metodoPagoStr));
                }
                factura.setTotal(rs.getBigDecimal(4));
                factura.setCodigoUsuario(rs.getInt(5));
                listaFacturas.add(factura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFacturas;
    }
    public int agregar(Facturas factura) {
        String sql = "call sp_AgregarFactura(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            // Convertir LocalDateTime a Timestamp
            ps.setTimestamp(1, Timestamp.valueOf(factura.getFechaEmision()));
            // Convertir enum a String
            ps.setString(2, factura.getMetodoPago().name());
            ps.setBigDecimal(3, factura.getTotal());
            ps.setInt(4, factura.getCodigoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    // Método para listar una factura por su ID utilizando el procedimiento almacenado sp_BuscarFactura
    public Facturas listarId(int id) {
        String sql = "call sp_BuscarFactura(?)";
        Facturas factura = new Facturas();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                factura.setCodigoFactura(rs.getInt(1));
                // Convertir Timestamp a LocalDateTime
                Timestamp timestamp = rs.getTimestamp(2);
                if (timestamp != null) {
                    factura.setFechaEmision(timestamp.toLocalDateTime());
                }
                // Convertir String a enum MetodoPago
                String metodoPagoStr = rs.getString(3);
                if (metodoPagoStr != null) {
                    factura.setMetodoPago(MetodoPago.valueOf(metodoPagoStr));
                }
                factura.setTotal(rs.getBigDecimal(4));
                factura.setCodigoUsuario(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factura;
    }
    // Método para actualizar una factura existente utilizando el procedimiento almacenado sp_EditarFactura
    public int actualizar(Facturas factura) {
        String sql = "call sp_EditarFactura(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, factura.getCodigoFactura());
            // Convertir LocalDateTime a Timestamp
            ps.setTimestamp(2, Timestamp.valueOf(factura.getFechaEmision()));
            // Convertir enum a String
            ps.setString(3, factura.getMetodoPago().name());
            ps.setBigDecimal(4, factura.getTotal());
            ps.setInt(5, factura.getCodigoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
 
    // Método para eliminar una factura por su ID utilizando el procedimiento almacenado sp_EliminarFactura
    public void eliminar(int id) {
        String sql = "call sp_EliminarFactura(?)";
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