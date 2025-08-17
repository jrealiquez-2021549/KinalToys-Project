
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JuguetesDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    int codigoJuguete;
    

    
    public List<Juguetes> listarJu(){
        String sql = "{call sp_ListarJuguetes()}";
        List<Juguetes> listaJuguetes = new ArrayList<>();  
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Juguetes ju = new Juguetes();
                ju.setCodigoJuguete(rs.getInt(1));
                ju.setNombreJuguete(rs.getString(2));
                ju.setPrecio(rs.getBigDecimal(3));
                ju.setCategoria(rs.getString(4));
                ju.setMarca(rs.getString(5));
                ju.setStock(rs.getInt(6));
                ju.setCodigoNoticia(rs.getInt(7));
                listaJuguetes.add(ju);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return listaJuguetes;
        
    }
    public int agregarJu(Juguetes ju){
        String sql = "{call sp_AgregarJuguete(?,?,?,?,?,?)}";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,ju.getNombreJuguete());
            ps.setBigDecimal(2,ju.getPrecio());
            ps.setString(3,ju.getCategoria());
            ps.setString(4,ju.getMarca());
            ps.setInt(5,ju.getStock());
            ps.setInt(6,ju.getCodigoNoticia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
}
