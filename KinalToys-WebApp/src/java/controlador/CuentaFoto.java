
package controlador;

import config.Conexion;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cuentas;

@WebServlet(name = "CuentaFoto", urlPatterns = {"/CuentaFoto"})
public class CuentaFoto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CuentaFoto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CuentaFoto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cuentas cuentas = (Cuentas) session.getAttribute("cuentas");

        // Ruta a la imagen por defecto en el sistema de archivos del servidor
        String defaultImagePath = request.getServletContext().getRealPath("/img/default-profile.png");

        if (cuentas != null) {
            int codigoCuenta = cuentas.getCodigoCuenta();
            Conexion cn = new Conexion();
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            InputStream inputStream = null;

            try {
                con = cn.Conexion();
                String sql = "SELECT fotoCuenta FROM Cuentas WHERE codigoCuenta = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, codigoCuenta);
                rs = ps.executeQuery();

                if (rs.next()) {
                    inputStream = rs.getBinaryStream("fotoCuenta");
                }

                // Verifica si se obtuvo una imagen de la base de datos
                if (inputStream != null && inputStream.available() > 0) {
                    // Si la imagen existe, la muestra
                    response.setContentType("image/jpeg");
                    OutputStream outputStream = response.getOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                } else {
                    // Si no existe, muestra la imagen por defecto
                    response.setContentType("image/png"); // O el tipo de la imagen por defecto
                    InputStream defaultImageStream = new FileInputStream(defaultImagePath);
                    OutputStream outputStream = response.getOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = defaultImageStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    defaultImageStream.close();
                    outputStream.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
                // En caso de error, también muestra la imagen por defecto
                try {
                    response.setContentType("image/png");
                    InputStream defaultImageStream = new FileInputStream(defaultImagePath);
                    OutputStream outputStream = response.getOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = defaultImageStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    defaultImageStream.close();
                    outputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            } finally {
                try {
                    if (inputStream != null) inputStream.close();
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
