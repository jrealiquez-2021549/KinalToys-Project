<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Kinal Toy's (Menú Principal)</title>
        <!-- Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Icono -->
        <link rel="icon" href="img/kinal toys.png" />
        <!-- CSS -->
        <link rel="stylesheet" href="css/principal.css" />
        <link rel="stylesheet" href="css/factura.css" />
        <link rel="stylesheet" href="css/administrador.css">
    </head>

    <body>
        <header>
            <div class="container-hero">
                <div class="container hero">
                    <div class="customer-support">
                        <i class="fa-solid fa-headset"></i>
                        <div class="content-customer-support">
                            <span class="text">Soporte al cliente</span>
                            <span class="number">502-3110-0319</span>
                        </div>
                    </div>

                    <div class="container-logo">
                        <h1 class="logo"><a href="/">Kinal Toy's</a></h1>
                    </div>
                    
                    <div class="container-user">
                    <div class="user-menu">
                        <i class="fa-solid fa-user"></i>
                        <ul class="user-dropdown">
                            <li><a href="cuenta-user.jsp">Mi cuenta</a></li>
                            <li><a href="#">Cambiar cuenta</a></li>
                            <li>
                                <a href="#">
                                    <i class="fa-solid fa-right-from-bracket"></i> Salir
                                </a>
                            </li>
                        </ul>
                    </div>

                    <input type="checkbox" id="toggle-cart" hidden>
                    <label for="toggle-cart" class="fa-solid fa-basket-shopping"></label>
                    <div class="carrito-items">
                        <div class="carrito-header">
                            <h3>Mi Carrito</h3>
                            <label for="toggle-cart" class="cerrar-carrito">&times;</label>
                        </div>

                        <div class="resumen-carrito">
                            <a href="carrito-user.jsp" class="btn-comprar">VER CARRITO Y PAGAR</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-navbar">
                <nav class="navbar container">
                    <i class="fa-solid fa-bars"></i>
                    <ul class="menu">
                        <li><a href="principal-usuario.jsp">Inicio</a></li>
                        <li><a href="categorias.jsp">Catalogo</a></li>
                        <li><a href="noticia-user.jsp">Noticias</a></li>
                        <li><a href="#">Pre-Orden</a></li>
                        <li><a href="categorias.jsp">Nuevos Productos</a></li>
                        <li><a href="categorias.jsp">Categorias</a></li>
                    </ul>

                    <form class="search-form">
                        <input type="search" placeholder="Buscar..." />
                        <button class="btn-search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </nav>
            </div>
        </header>

        <div class="container">
            <h2>FACTURA</h2>

            <div class="factura-info">
                <form>
                    <div class="form-group">
                        <label for="nombre-usuario">Nombre Usuario:</label>
                        <input type="text" id="nombre-usuario" name="nombre-usuario" placeholder="Ej. Jorge" required />
                    </div>

                    <div class="form-group">
                        <label for="apellido-usuario">Apellido Usuario:</label>
                        <input type="text" id="apellido-usuario" name="apellido-usuario" placeholder="Ej. Aquino"
                               required />
                    </div>

                    <div class="form-group">
                        <label for="direccion-usuario">Dirección Usuario:</label>
                        <input type="text" id="direccion-usuario" name="direccion-usuario" placeholder="Ej. 12 avenida"
                               required />
                    </div>

                    <div class="form-group">
                        <label for="telefono-usuario">Teléfono Usuario:</label>
                        <input type="text" id="telefono-usuario" name="telefono-usuario" placeholder="Ej. 12324-5343"
                               required />
                    </div>

                    <div class="form-group">
                        <label for="fecha-emision">Fecha Emisión:</label>
                        <input type="date" id="fecha-emision" name="fecha-emision" required />
                    </div>

                    <div class="form-group">
                        <label for="metodo-pago">Método de Pago:</label>
                        <select id="metodo-pago" name="metodo-pago" required>
                            <option value="">Seleccione...</option>
                            <option value="efectivo">Efectivo</option>
                            <option value="credito">Crédito</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="total">Total:</label>
                        <input type="number" id="total" name="total" step="0.01" placeholder="Ej. 150.00" required />
                    </div>
                </form>
            </div>

            <div class="table-wrapper">
                <table class="users-table">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Envío</th>
                            <th>Precio</th>
                            <th>Descuento</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody id="detalle-factura">
                        <tr>
                            <td>Juguete de Spider-Man</td>
                            <td>1</td>
                            <td>Q125.73</td>
                            <td>Q125.73</td>
                            <td>Q125.73</td>
                            <td>Q125.73</td>
                        </tr>
                        <tr>
                            <td>Rem</td>
                            <td>2</td>
                            <td>Q118.85</td>
                            <td>Q237.70</td>
                            <td>Q237.70</td>
                            <td>Q237.70</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="summary-wrapper">
                <div class="summary">
                    <p>Subtotal: Q363.43</p>
                    <p>Descuento: Q43.61</p>
                    <p2>Total a Pagar: Q407.04</p2>
                </div>
                <button id="btn-finalizar" class="btn-crud">Finalizar</button>
            </div>
        </div>


        <footer class="footer">
            <div class="container container-footer">
                <div class="menu-footer">
                    <div class="contact-info">
                        <p class="title-footer">Información de Contacto</p>
                        <ul>
                            <li>Dirección: 71 Pennington Lane Vernon Rockville, CT 06066</li>
                            <li>Teléfono: 123-456-7890</li>
                            <li>Fax: 55555300</li>
                            <li>Email: baristas@support.com</li>
                        </ul>
                        <div class="social-icons">
                            <span class="facebook"><i class="fa-brands fa-facebook-f"></i></span>
                            <span class="twitter"><i class="fa-brands fa-twitter"></i></span>
                            <span class="youtube"><i class="fa-brands fa-youtube"></i></span>
                            <span class="pinterest"><i class="fa-brands fa-pinterest-p"></i></span>
                            <span class="instagram"><i class="fa-brands fa-instagram"></i></span>
                        </div>
                    </div>

                    <div class="information">
                        <p class="title-footer">Información</p>
                        <ul>
                            <li><a href="#">Acerca de Nosotros</a></li>
                            <li><a href="#">Información Delivery</a></li>
                            <li><a href="#">Políticas de Privacidad</a></li>
                            <li><a href="#">Términos y condiciones</a></li>
                            <li><a href="#">Contáctanos</a></li>
                        </ul>
                    </div>

                    <div class="my-account">
                        <p class="title-footer">Mi cuenta</p>
                        <ul>
                            <li><a href="cuenta-user.jsp">Mi cuenta</a></li>
                            <li><a href="#">Historial de ordenes</a></li>
                            <li><a href="#">Lista de deseos</a></li>
                            <li><a href="#">Boletín</a></li>
                            <li><a href="#">Reembolsos</a></li>
                        </ul>
                    </div>

                    <div class="newsletter">
                        <p class="title-footer">Boletín informativo</p>
                        <div class="content">
                            <p>
                                Suscríbete a nuestros boletines ahora y mantente al día con nuevas colecciones y
                                ofertas exclusivas.
                            </p>
                            <input type="email" placeholder="Ingresa el correo aquí..." />
                            <button>Suscríbete</button>
                        </div>
                    </div>
                </div>

                <div class="copyright">
                    <p>Kinal Toy's &copy; 2025</p>
                    <img src="img/payment.png" alt="Pagos" />
                </div>
            </div>
        </footer>
    </body>
</html>