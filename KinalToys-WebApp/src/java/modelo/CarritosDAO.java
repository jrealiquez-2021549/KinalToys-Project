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
                cr.setCodigoCliente(rs.getInt(5));
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
            ps.setInt(4, cr.getCodigoCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Carritos listarCodigoCarrito(int id) {
        // Instanciar un objeto de tipo Carrito
        Carritos car = new Carritos();
        String sql = "{call sp_listarCodigoCarrito(?)}";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                car.setCodigoCarrito(rs.getInt(1));
                car.setFechaCreacion(rs.getTimestamp(2).toLocalDateTime());
                car.setEstado(rs.getString(3));
                car.setTotal(rs.getDouble(4));
                car.setCodigoCliente(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    public int actualizar(Carritos car) {
        String sql = "{call sp_EditarCarrito(?, ?, ?, ?, ?)}";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, car.getCodigoCarrito());
            ps.setTimestamp(2, Timestamp.valueOf(car.getFechaCreacion()));
            ps.setString(3, car.getEstado());
            ps.setBigDecimal(4, new BigDecimal(car.getTotal()));
            ps.setInt(5, car.getCodigoCliente());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "{call sp_EliminarCarrito(?)}";
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
