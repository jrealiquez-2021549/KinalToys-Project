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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import modelo.Carritos;
import modelo.CarritosDAO;
import modelo.DetallesCarritos;
import modelo.DetallesCarritosDAO;
import modelo.Juguetes;
import modelo.JuguetesDAO;
import modelo.Noticias;
import modelo.NoticiasDAO;
import modelo.Proveedores;
import modelo.ProveedoresDAO;
import modelo.Usuarios;
import modelo.UsuariosDAO;

@MultipartConfig
public class Controlador extends HttpServlet {

    Cuentas cuentas = new Cuentas();
    CuentasDAO cuentasDAO = new CuentasDAO();
    int codCuenta;

    Proveedores proveedores = new Proveedores();
    ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
    int codProveedores;

    Facturas facturas = new Facturas();
    FacturasDAO facturasDAO = new FacturasDAO();
    int codFactura;

    NoticiasDAO noticiasDAO = new NoticiasDAO();
    Noticias noticias = new Noticias();
    int codNoticia;

    CarritosDAO carritosDAO = new CarritosDAO();
    Carritos carritos = new Carritos();
    int codCarrito;

    JuguetesDAO jugueteDAO = new JuguetesDAO();
    Juguetes juguete = new Juguetes();
    int codJuguete;
    UsuariosDAO usuariosDAO = new UsuariosDAO();
    Usuarios usuarios = new Usuarios();
    int codUsuario;

    DetallesCarritos detalleCarrito = new DetallesCarritos();
    DetallesCarritosDAO detallesCarritosDAO = new DetallesCarritosDAO();
    int codDetalles;

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

            switch (accion) {
                case "Listar":
                    List<Usuarios> listaUsuarios = usuariosDAO.listar();
                    request.setAttribute("usuarios", listaUsuarios);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String nombreUsuario = request.getParameter("nombre-usuario");
                    String apellidoUsuario = request.getParameter("apellido-usuario");
                    String direccionUsuario = request.getParameter("direccion-usuario");
                    String telefonoUsuario = request.getParameter("telefono-usuario");

                    usuarios.setNombreUsuario(nombreUsuario);
                    usuarios.setApellidoUsuario(apellidoUsuario);
                    usuarios.setDireccionUsuario(direccionUsuario);
                    usuarios.setTelefonoUsuario(telefonoUsuario);

                    usuariosDAO.agregar(usuarios);

                    response.sendRedirect("Controlador?menu=Usuarios&accion=Listar");
                    break;

                default:
                    List<Usuarios> lista = usuariosDAO.listar();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
            }
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
            switch (accion) {
                case "Listar":
                    List<Noticias> listaNoticias = noticiasDAO.listar();
                    request.setAttribute("noticias", listaNoticias);
                    request.getRequestDispatcher("noticia.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String encabezado = request.getParameter("encabezado");
                    String informacion = request.getParameter("informacion");
                    String categoria = request.getParameter("categoria");
                    String fechaStr = request.getParameter("fecha-noticia");
                    LocalDate fechaNoticia = LocalDate.parse(fechaStr);

                    noticias.setEncabezado(encabezado);
                    noticias.setInformacion(informacion);
                    noticias.setCategoria(categoria);
                    noticias.setFechaNoticia(fechaNoticia);

                    noticiasDAO.agregar(noticias);

                    response.sendRedirect("Controlador?menu=Noticias&accion=Listar");
                    break;

                case "Eliminar":
                    int codigoNoticia = Integer.parseInt(request.getParameter("id"));
                    noticiasDAO.eliminar(codigoNoticia);
                    response.sendRedirect("Controlador?menu=Noticias&accion=Listar");
                    break;

                case "Cargar":
                    int codNoticia = Integer.parseInt(request.getParameter("id"));
                    Noticias noticiaSeleccionada = noticiasDAO.listarId(codNoticia);
                    request.setAttribute("noticiaSeleccionada", noticiaSeleccionada);
                    request.getRequestDispatcher("Controlador?menu=Noticias&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    int codigoActualizar = Integer.parseInt(request.getParameter("codigo-noticia"));
                    String enc = request.getParameter("encabezado");
                    String info = request.getParameter("informacion");
                    String cat = request.getParameter("categoria");
                    String fechaActualizarStr = request.getParameter("fecha-noticia");
                    LocalDate fechaActualizar = LocalDate.parse(fechaActualizarStr);

                    noticias.setCodigoNoticia(codigoActualizar);
                    noticias.setEncabezado(enc);
                    noticias.setInformacion(info);
                    noticias.setCategoria(cat);
                    noticias.setFechaNoticia(fechaActualizar);

                    noticiasDAO.actualizar(noticias);

                    response.sendRedirect("Controlador?menu=Noticias&accion=Listar");
                    break;

                case "Buscar":
                    String idParam = request.getParameter("id");
                    if (idParam != null && !idParam.isEmpty()) {
                        try {
                            int idBuscar = Integer.parseInt(idParam);
                            Noticias noticiaEncontrada = noticiasDAO.listarId(idBuscar);
                            List<Noticias> listaEncontrada = new ArrayList<>();
                            if (noticiaEncontrada.getEncabezado() != null) {
                                listaEncontrada.add(noticiaEncontrada);
                            }
                            request.setAttribute("noticias", listaEncontrada);
                        } catch (NumberFormatException e) {
                            request.setAttribute("noticias", noticiasDAO.listar());
                        }
                    } else {
                        request.setAttribute("noticias", noticiasDAO.listar());
                    }
                    request.getRequestDispatcher("noticia.jsp").forward(request, response);
                    break;

                default:
                    List<Noticias> lista = noticiasDAO.listar();
                    request.setAttribute("noticias", lista);
                    request.getRequestDispatcher("noticia.jsp").forward(request, response);
            }

        } else if (menu.equals("Proveedores")) {
            if (accion == null) {
                accion = "Listar";
            }
            switch (accion) {
                case "Listar":
                    try {
                        List<Proveedores> listaProveedores = proveedoresDAO.listar();
                        request.setAttribute("proveedores", listaProveedores);
                        request.getRequestDispatcher("/proveedor.jsp").forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "Agregar":
                    String nombreProv = request.getParameter("nombre-proveedor");
                    String telefonoProv = request.getParameter("telefono-proveedor");
                    String correoProv = request.getParameter("correo-proveedor");
                    String direccionProv = request.getParameter("direccion-proveedor");

                    Proveedores proveedores = new Proveedores();
                    proveedores.setNombreProveedor(nombreProv);
                    proveedores.setTelefonoProveedor(telefonoProv);
                    proveedores.setCorreoProveedor(correoProv);
                    proveedores.setDireccionProveedor(direccionProv);

                    proveedoresDAO.agregar(proveedores);
                    response.sendRedirect("Controlador?menu=Proveedores&accion=Listar");
                    break;

                case "Editar":
                    System.out.println("LIST");
                    break;
                case "Actualizar":
                    System.out.println("LIST");
                    break;
                case "Eliminar":
                    System.out.println("LIST");
                    break;
                case "Cargar":
                    System.out.println("LIST");
                    break;
                case "Buscar":
                    System.out.println("LIST");
                    break;
                default:
            }
        } else if (menu.equals("Juguetes")) {

            switch (accion) {
                case "Listar":
                    List<Juguetes> listaJuguetes = jugueteDAO.listarJu();
                    request.setAttribute("juguetes", listaJuguetes);
                    request.getRequestDispatcher("juguete.jsp").forward(request, response);

                    break;
                case "Agregar":

                    String nombrej = request.getParameter("nombre-juguete");
                    String precioj = request.getParameter("precio-juguete");
                    String categoriaj = request.getParameter("categoria-juguete");
                    String marcaj = request.getParameter("marca-juguete");
                    int stockj = Integer.parseInt(request.getParameter("stock-juguete"));
                    int codigonoticiaj = Integer.parseInt(request.getParameter("codigo-noticia"));
                    juguete.setNombreJuguete(nombrej);
                    juguete.setPrecio(new BigDecimal(precioj)); // 👈 conversión String -> BigDecimal
                    juguete.setCategoria(categoriaj);
                    juguete.setMarca(marcaj);
                    juguete.setStock(stockj);
                    juguete.setCodigoNoticia(codigonoticiaj);
                    jugueteDAO.agregarJu(juguete);
                    request.getSession().setAttribute("mensaje", "Se agregó correctamente");

                    request.getRequestDispatcher("Controlador?menu=Juguetes&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    System.out.println("LIST");
                    break;
                case "Actualizar":
                    System.out.println("LIST");
                    break;
                case "Eliminar":
                    System.out.println("LIST");
                    break;
                default:

            }

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
            switch (accion) {
                case "Listar":
                    List<Carritos> listarCarritos = carritosDAO.listar();
                    request.setAttribute("carritos", listarCarritos);

                    // mensaje
                    String mensajeSesion = (String) request.getSession().getAttribute("mensaje");
                    if (mensajeSesion != null) {
                        request.setAttribute("mensaje", mensajeSesion);
                        request.getSession().removeAttribute("mensaje");
                    }
                    break;

                case "Agregar":
                    String fechaCr = request.getParameter("fecha-creacion");
                    String estado = request.getParameter("estado");
                    String totalStr = request.getParameter("total");
                    String codigoUsuarioStr = request.getParameter("codigo-usuario");

                    //Se agregan validaciones != null en los case "Agregar" para evitar NullPointerException
                    if (fechaCr != null && estado != null && totalStr != null && codigoUsuarioStr != null) {
                        try {
                            double total = Double.parseDouble(totalStr);
                            int codigoUsuario = Integer.parseInt(codigoUsuarioStr);

                            LocalDateTime fechaCreacion = LocalDateTime.parse(fechaCr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

                            carritos.setFechaCreacion(fechaCreacion);
                            carritos.setEstado(estado);
                            carritos.setTotal(total);
                            carritos.setCodigoUsuario(codigoUsuario);

                            carritosDAO.agregar(carritos);
                            request.getSession().setAttribute("mensaje", "Se agregó correctamente");
                        } catch (NumberFormatException e) {
                            request.getSession().setAttribute("mensaje", "Error: Los datos numéricos no son válidos");
                        } catch (Exception e) {
                            request.getSession().setAttribute("mensaje", "Error: El formato de fecha es incorrecto");
                        }
                    } else {
                        request.getSession().setAttribute("mensaje", "Error: Debe llenar todos los campos");
                    }
                    response.sendRedirect("Controlador?menu=Carritos&accion=Listar");
                    return;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
                default:
                    request.getRequestDispatcher("Controlador?menu=Carritos&accion=Listar").forward(request, response);
            }
            request.getRequestDispatcher("carrito.jsp").forward(request, response);
        } else if ("DetallesCarritos".equals(menu)) {
            try {
                if (accion == null) {
                    accion = "Listar";
                }

                switch (accion) {
                    case "Listar":
                        try {
                            
                            List<DetallesCarritos> listaDetalles = detallesCarritosDAO.listar();
                            request.setAttribute("detallesCarritos", listaDetalles);
                            request.getRequestDispatcher("/detalles-carritos.jsp").forward(request, response);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            e.getMessage();
                        }

                    case "Agregar":
                        String cantidadStr = request.getParameter("txtCantidad");
                        String subTotalStr = request.getParameter("txtSubTotal");
                        String descuentoStr = request.getParameter("txtDescuento");
                        String codigoCarritoStr = request.getParameter("txtCodigoCarrito");
                        String codigoJugueteStr = request.getParameter("txtCodigoJuguete");

                        int cantidad = Integer.parseInt(cantidadStr);
                        BigDecimal subTotal = new BigDecimal(subTotalStr);
                        BigDecimal descuento = new BigDecimal(descuentoStr);
                        int codigoCarrito = Integer.parseInt(codigoCarritoStr);
                        int codigoJuguete = Integer.parseInt(codigoJugueteStr);

                        detalleCarrito.setCantidad(cantidad);
                        detalleCarrito.setSubTotal(subTotal);
                        detalleCarrito.setDescuentoAplicado(descuento);
                        detalleCarrito.setCodigoCarrito(codigoCarrito);
                        detalleCarrito.setCodigoJuguete(codigoJuguete);

                        detallesCarritosDAO.agregar(detalleCarrito);

                        response.sendRedirect("Controlador?menu=DetallesCarritos&accion=Listar");
                        return;
                    case "Editar":
                        System.out.println("entro a editar");
                        codDetalles = Integer.parseInt(request.getParameter("codigoDetalleC"));
                        DetallesCarritos dc = detallesCarritosDAO.listaCodigoDetallesCarritos(codDetalles);
                        System.out.println(codDetalles);
                        request.setAttribute("detalle", dc);
                        request.getRequestDispatcher("Controlador?menu=DetallesCarritos&accion=Listar").forward(request,response);
                        break;

                    case "Actualizar":
                        String codigoDetalleCS = request.getParameter("txtCodigoDetalleC");
                        String cantidadS = request.getParameter("txtCantidad");
                        String subTotalS = request.getParameter("txtSubTotal");
                        String descuentoS = request.getParameter("txtDescuento");
                        String codigoCarritoS = request.getParameter("txtCodigoCarrito");
                        String codigoJugueteS = request.getParameter("txtCodigoJuguete");

                        int codigoDetalleCI = Integer.parseInt(codigoDetalleCS);
                        int cantidadI = Integer.parseInt(cantidadS);
                        BigDecimal subTotalB = new BigDecimal(subTotalS);
                        BigDecimal descuentoB = new BigDecimal(descuentoS);
                        int codigoCarritoI = Integer.parseInt(codigoCarritoS);
                        int codigoJugueteI = Integer.parseInt(codigoJugueteS);

                        DetallesCarritos detalleCarrito = new DetallesCarritos();
                        detalleCarrito.setCodigoDetalleC(codigoDetalleCI);
                        detalleCarrito.setCantidad(cantidadI);
                        detalleCarrito.setSubTotal(subTotalB);
                        detalleCarrito.setDescuentoAplicado(descuentoB);
                        detalleCarrito.setCodigoCarrito(codigoCarritoI);
                        detalleCarrito.setCodigoJuguete(codigoJugueteI);

                        detallesCarritosDAO.actualizar(detalleCarrito);

                        request.getRequestDispatcher("Controlador?menu=DetallesCarritos&accion=Listar").forward(request, response);
                        break;

                    case "Eliminar":
                        System.out.println("entro en eliminar");
                        codDetalles = Integer.parseInt(request.getParameter("codigoDetalle")); 
                        System.out.println("Código a eliminar: " + codDetalles);
                        detallesCarritosDAO.eliminar(codDetalles);
                        response.sendRedirect("Controlador?menu=DetallesCarritos&accion=Listar");
                        break;
                    
                    case "Buscar":
                        String idS = request.getParameter("txtid");
                        if (idS != null && !idS.isEmpty()) {
                            int id = Integer.parseInt(idS);
                            DetallesCarritos dcBuscado = detallesCarritosDAO.buscar(id);

                            List<DetallesCarritos> lista = new ArrayList<>();
                            if (dcBuscado != null) {
                                lista.add(dcBuscado);
                            }
                            request.setAttribute("detallesCarritos", lista);
                        } else {
                            List<DetallesCarritos> listaDetalles = detallesCarritosDAO.listar();
                            request.setAttribute("detallesCarritos", listaDetalles);
                        }
                        request.getRequestDispatcher("/detalles-carritos.jsp").forward(request, response);
                        break;
                    default:
                        throw new AssertionError("Acción no reconocida: " + accion);
                }
            } catch (Exception e) {
                System.out.println("Error en controlador de detalles-carritos: " + e.getMessage());
                e.printStackTrace();
            }
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
