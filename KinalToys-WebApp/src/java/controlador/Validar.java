
package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cuentas;
import modelo.CuentasDAO;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {
    CuentasDAO cuentasDAO = new CuentasDAO();
    Cuentas cuentas = new Cuentas();
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
            out.println("<title>Servlet Validar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String dpi = request.getParameter("dpi");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // La línea que podría generar la excepción es la siguiente,
            // si el método validar del DAO devuelve un objeto nulo.
            cuentas = cuentasDAO.validar(dpi, email, password);

            // Verificamos si la cuenta existe antes de intentar obtener su rol
            if (cuentas != null && cuentas.getCorreoCuenta() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("cuentas", cuentas);

                String rol = cuentas.getRol();

                if ("Empleado".equalsIgnoreCase(rol)) {
                    // Asegúrate de que este archivo exista
                    request.getRequestDispatcher("principal-admin.jsp").forward(request, response);
                } else if ("Cliente".equalsIgnoreCase(rol)) {
                    // Asegúrate de que este archivo exista
                    request.getRequestDispatcher("principal-usuario.jsp").forward(request, response);
                } else {
                    // Si el rol no es reconocido o es nulo, redirigimos al login
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                // Si la validación falla (cuentas es nulo o el correo es nulo), volvemos al login
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
