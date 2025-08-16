package controlador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Cuentas;
import modelo.CuentasDAO;
import modelo.Facturas;
import modelo.FacturasDAO;
import enums.MetodoPago;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@MultipartConfig
public class Controlador extends HttpServlet {

    Cuentas cuentas = new Cuentas();
    CuentasDAO cuentasDAO = new CuentasDAO();
    int codCuenta;

    Facturas facturas = new Facturas();
    FacturasDAO facturasDAO = new FacturasDAO();
    int codFactura;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        // Si el menú es "Salir", manejamos la lógica aquí para evitar conflictos
        if (menu != null && menu.equals("Salir")) {
            // Invalida la sesión actual para "cerrar la sesión"
            if (request.getSession(false) != null) {
                request.getSession(false).invalidate();
            }
            // Redirige a la página de inicio o login para romper el bucle
            response.sendRedirect("index.jsp");
            return;
        }

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("principal-admin.jsp").forward(request, response);
        } else if (menu.equals("Usuarios")) {
            request.getRequestDispatcher("usuario.jsp").forward(request, response);
        } else if (menu.equals("Facturas")) {
            switch (accion) {
                case "Listar":
                    List<Facturas> listaFacturas = facturasDAO.listar();
                    request.setAttribute("facturas", listaFacturas);
                    request.getRequestDispatcher("factura.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String fechaEmisionStr = request.getParameter("fecha-emision");
                    String metodoPagoStr = request.getParameter("metodo-pago");
                    String totalStr = request.getParameter("total");
                    String codigoUsuarioStr = request.getParameter("codigo-usuario");

                    // Convertir fecha de String a LocalDateTime (agregar hora actual)
                    LocalDateTime fechaEmision = LocalDateTime.parse(fechaEmisionStr + "T00:00:00");

                    // Convertir String a enum MetodoPago
                    MetodoPago metodoPago = MetodoPago.valueOf(metodoPagoStr);

                    // Convertir String a BigDecimal
                    BigDecimal total = new BigDecimal(totalStr);
                    int codigoUsuario = Integer.parseInt(codigoUsuarioStr);

                    facturas.setFechaEmision(fechaEmision);
                    facturas.setMetodoPago(metodoPago);
                    facturas.setTotal(total);
                    facturas.setCodigoUsuario(codigoUsuario);

                    facturasDAO.agregar(facturas);

                    response.sendRedirect("Controlador?menu=Facturas&accion=Listar");
                    break;
                case "Eliminar":
                    codFactura = Integer.parseInt(request.getParameter("id"));
                    facturasDAO.eliminar(codFactura);
                    response.sendRedirect("Controlador?menu=Facturas&accion=Listar");
                    break;
                case "Cargar":
                    codFactura = Integer.parseInt(request.getParameter("id"));
                    Facturas facturaSeleccionada = facturasDAO.listarId(codFactura);
                    request.setAttribute("facturaSeleccionada", facturaSeleccionada);
                    request.getRequestDispatcher("Controlador?menu=Facturas&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    codFactura = Integer.parseInt(request.getParameter("codigo-factura"));
                    String fechaActualizarStr = request.getParameter("fecha-emision");
                    String metodoActualizarStr = request.getParameter("metodo-pago");
                    String totalActualizarStr = request.getParameter("total");
                    int codigoUserActualizar = Integer.parseInt(request.getParameter("codigo-usuario"));

                    // Convertir fecha de String a LocalDateTime
                    LocalDateTime fechaActualizar = LocalDateTime.parse(fechaActualizarStr + "T00:00:00");

                    // Convertir String a enum MetodoPago
                    MetodoPago metodoActualizar = MetodoPago.valueOf(metodoActualizarStr);

                    // Convertir String a BigDecimal
                    BigDecimal totalActualizar = new BigDecimal(totalActualizarStr);

                    facturas.setCodigoFactura(codFactura);
                    facturas.setFechaEmision(fechaActualizar);
                    facturas.setMetodoPago(metodoActualizar);
                    facturas.setTotal(totalActualizar);
                    facturas.setCodigoUsuario(codigoUserActualizar);

                    facturasDAO.actualizar(facturas);

                    response.sendRedirect("Controlador?menu=Facturas&accion=Listar");
                    break;
                case "Buscar":
                    String idParam = request.getParameter("id");
                    if (idParam != null && !idParam.isEmpty()) {
                        try {
                            int idBuscar = Integer.parseInt(idParam);
                            Facturas facturaEncontrada = facturasDAO.listarId(idBuscar);
                            List<Facturas> listaEncontrada = new ArrayList<>();
                            if (facturaEncontrada != null && facturaEncontrada.getCodigoFactura() != null) {
                                listaEncontrada.add(facturaEncontrada);
                            }
                            request.setAttribute("facturas", listaEncontrada);
                        } catch (NumberFormatException e) {
                            request.setAttribute("facturas", facturasDAO.listar());
                        }
                    } else {
                        request.setAttribute("facturas", facturasDAO.listar());
                    }
                    request.getRequestDispatcher("factura.jsp").forward(request, response);
                    break;
                default:
                    List<Facturas> lista = facturasDAO.listar();
                    request.setAttribute("facturas", lista);
                    request.getRequestDispatcher("factura.jsp").forward(request, response);
                    break;
            }
        } else if (menu.equals("Noticias")) {
            request.getRequestDispatcher("noticia.jsp").forward(request, response);
        } else if (menu.equals("Proveedores")) {
            request.getRequestDispatcher("proveedor.jsp").forward(request, response);
        } else if (menu.equals("Juguetes")) {
            request.getRequestDispatcher("juguete.jsp").forward(request, response);
        } else if (menu.equals("Cuentas")) {
            switch (accion) {
                case "Listar":
                    List<Cuentas> listaCuentas = cuentasDAO.listar();
                    request.setAttribute("cuentas", listaCuentas);
                    request.getRequestDispatcher("cuenta.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String nombreCuenta = request.getParameter("nombre-cuenta");
                    String correoCuenta = request.getParameter("correo-cuenta");
                    String contrasenaCuenta = request.getParameter("contrasena-cuenta");

                    byte[] fotoBytes = null;
                    Part filePart = request.getPart("foto-cuenta");
                    if (filePart != null && filePart.getSize() > 0) {
                        InputStream fotoCuentaInputStream = filePart.getInputStream();
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        int nRead;
                        byte[] data = new byte[1024];
                        while ((nRead = fotoCuentaInputStream.read(data, 0, data.length)) != -1) {
                            buffer.write(data, 0, nRead);
                        }
                        buffer.flush();
                        fotoBytes = buffer.toByteArray();
                        fotoCuentaInputStream.close();
                        buffer.close();
                    }

                    int codigoUsuario = Integer.parseInt(request.getParameter("codigo-usuario"));

                    cuentas.setNombreCuenta(nombreCuenta);
                    cuentas.setCorreoCuenta(correoCuenta);
                    cuentas.setContrasenaCuenta(contrasenaCuenta);
                    cuentas.setFotoCuenta(fotoBytes);
                    cuentas.setCodigoUsuario(codigoUsuario);

                    cuentasDAO.agregar(cuentas);

                    response.sendRedirect("Controlador?menu=Cuentas&accion=Listar");
                    break;
                case "Eliminar":
                    codCuenta = Integer.parseInt(request.getParameter("id"));
                    cuentasDAO.eliminar(codCuenta);
                    response.sendRedirect("Controlador?menu=Cuentas&accion=Listar");
                    break;
                case "Cargar":
                    codCuenta = Integer.parseInt(request.getParameter("id"));
                    Cuentas cuentaSeleccionada = cuentasDAO.listarId(codCuenta);
                    request.setAttribute("cuentaSeleccionada", cuentaSeleccionada);
                    request.getRequestDispatcher("Controlador?menu=Cuentas&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    codCuenta = Integer.parseInt(request.getParameter("codigo-cuenta"));
                    String nombre = request.getParameter("nombre-cuenta");
                    String correo = request.getParameter("correo-cuenta");
                    int codigoUser = Integer.parseInt(request.getParameter("codigo-usuario"));

                    byte[] fotoActualizar = null;
                    Part fotoPart = request.getPart("foto-cuenta");
                    if (fotoPart != null && fotoPart.getSize() > 0) {
                        InputStream fotoInputStream = fotoPart.getInputStream();
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        int nRead;
                        byte[] data = new byte[1024];
                        while ((nRead = fotoInputStream.read(data, 0, data.length)) != -1) {
                            buffer.write(data, 0, nRead);
                        }
                        buffer.flush();
                        fotoActualizar = buffer.toByteArray();
                    } else {
                        Cuentas cuentaExistente = cuentasDAO.listarId(codCuenta);
                        fotoActualizar = cuentaExistente.getFotoCuenta();
                    }

                    cuentas.setCodigoCuenta(codCuenta);
                    cuentas.setNombreCuenta(nombre);
                    cuentas.setCorreoCuenta(correo);
                    cuentas.setFotoCuenta(fotoActualizar);
                    cuentas.setCodigoUsuario(codigoUser);

                    cuentasDAO.actualizar(cuentas, fotoActualizar);

                    response.sendRedirect("Controlador?menu=Cuentas&accion=Listar");
                    break;
                case "Buscar":
                    String idParam = request.getParameter("id");
                    if (idParam != null && !idParam.isEmpty()) {
                        try {
                            int idBuscar = Integer.parseInt(idParam);
                            Cuentas cuentaEncontrada = cuentasDAO.listarId(idBuscar);
                            List<Cuentas> listaEncontrada = new ArrayList<>();
                            if (cuentaEncontrada.getNombreCuenta() != null) {
                                listaEncontrada.add(cuentaEncontrada);
                            }
                            request.setAttribute("cuentas", listaEncontrada);
                        } catch (NumberFormatException e) {
                            request.setAttribute("cuentas", cuentasDAO.listar());
                        }
                    } else {
                        request.setAttribute("cuentas", cuentasDAO.listar());
                    }
                    request.getRequestDispatcher("cuenta.jsp").forward(request, response);
                    break;
                default:
                    List<Cuentas> lista = cuentasDAO.listar();
                    request.setAttribute("cuentas", lista);
                    request.getRequestDispatcher("cuenta.jsp").forward(request, response);
            }
        } else if (menu.equals("Carritos")) {
            request.getRequestDispatcher("carrito.jsp").forward(request, response);
        } else if (menu.equals("DetallesCarritos")) {
            request.getRequestDispatcher("detalles-carritos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
