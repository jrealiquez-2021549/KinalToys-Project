package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<Empleados> listar() {
        List<Empleados> listaEmpleado = new ArrayList<>();
        String sql = "call sp_ListarEmpleados()";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleados em = new Empleados();
                em.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                em.setNombreEmpleado(rs.getString("nombreEmpleado"));
                em.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                em.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                em.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
                em.setCargo(rs.getString("cargo"));
                em.setSalario(rs.getDouble("salario"));
                em.setDpiEmpleado(rs.getString("dpiEmpleado"));

                listaEmpleado.add(em);
            }
        } catch (Exception e) {
            System.out.println("Error en listar empleados: " + e.getMessage());
            e.printStackTrace();
        }
        return listaEmpleado;
    }

    public int agregar(Empleados emp) {
        String sql = "call sp_AgregarEmpleados(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidoEmpleado());
            ps.setString(3, emp.getDireccionEmpleado());
            ps.setString(4, emp.getTelefonoEmpleado());
            ps.setString(5, emp.getCargo());
            ps.setDouble(6, emp.getSalario());
            ps.setString(7, emp.getDpiEmpleado());

            resp = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en agregar empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizar(Empleados emp) {
        String sql = "call sp_EditarEmpleado(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, emp.getCodigoEmpleado());
            ps.setString(2, emp.getNombreEmpleado());
            ps.setString(3, emp.getApellidoEmpleado());
            ps.setString(4, emp.getDireccionEmpleado());
            ps.setString(5, emp.getTelefonoEmpleado());
            ps.setString(6, emp.getCargo());
            ps.setDouble(7, emp.getSalario());
            ps.setString(8, emp.getDpiEmpleado());

            resp = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en actualizar empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return resp;
    }

    public int eliminar(int codigoEmpleado) {
        String sql = "call sp_EliminarEmpleado(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoEmpleado);

            resp = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en eliminar empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return resp;
    }

    public Empleados listarId(int codigoEmpleado) {
        Empleados em = null;
        String sql = "call sp_ListarEmpleadoPorCodigo(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoEmpleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                em = new Empleados();
                em.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                em.setNombreEmpleado(rs.getString("nombreEmpleado"));
                em.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                em.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                em.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
                em.setCargo(rs.getString("cargo"));
                em.setSalario(rs.getDouble("salario"));
                em.setDpiEmpleado(rs.getString("dpiEmpleado"));
            }
        } catch (Exception e) {
            System.out.println("Error en listarId empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return em;
    }
}
