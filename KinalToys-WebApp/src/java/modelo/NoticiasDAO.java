package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
public class NoticiasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
 
    public List<Noticias> listar() {
        String sql = "call sp_ListarNoticias()";
        List<Noticias> listaNoticias = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
 
            while (rs.next()) {
                Noticias nt = new Noticias();
                nt.setCodigoNoticia(rs.getInt(1));
                nt.setEncabezado(rs.getString(2));
                nt.setInformacion(rs.getString(3));
                nt.setCategoria(rs.getString(4));
                nt.setFechaNoticia(rs.getDate(5).toLocalDate());
 
                listaNoticias.add(nt);
            }
 
        } catch (Exception e) {
            System.out.println("Error en NoticiasDAO.listar(): " + e.getMessage());
            e.printStackTrace();
        }
 
        return listaNoticias;
    }
 
    public int agregar(Noticias noticia) {
        String sql = "call sp_AgregarNoticia(?, ?, ?, ?)"; 
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, noticia.getEncabezado());
            ps.setString(2, noticia.getInformacion());
            ps.setString(3, noticia.getCategoria());
            ps.setDate(4, Date.valueOf(noticia.getFechaNoticia())); 
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}