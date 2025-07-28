<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Mi Cuenta - Kinal Toys</title>
        <!-- Icons -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
            integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!-- Icono -->
        <link rel="icon" href="img/kinal toys.png" />
        <!-- CSS -->
        <link rel="stylesheet" href="css/principal.css" />
        <link rel="stylesheet" href="css/cuenta.css" />
        <link rel="stylesheet" href="css/administrador.css">
        <style>
            .container-user a {
                color: inherit;
                text-decoration: none;
                position: relative;
                display: inline-flex;
                align-items: center;
                margin-left: 1rem;
                cursor: pointer;
            }
            .container-user a:hover {
                color: #007bff;
            }
            .content-shopping-cart {
                margin-left: 0.5rem;
                font-weight: 600;
                font-size: 0.9rem;
                display: inline-block;
            }
        </style>
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
                            <h2>Mi Carrito</h2>
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

        <!-- Contenido principal -->
        <main class="container main-content" style="padding: 3rem;">
            <h2 class="heading-1">Mi Cuenta</h2>

            <section class="mi-cuenta">
                <!-- Detalles de la cuenta a la izquierda -->
                <div class="mi-cuenta-card detalles-cuenta">
                    <h3>Detalles de la cuenta</h3>
                    <p><strong>Nombre:</strong> Santiago Quezada</p>
                    <p><strong>Correo electrónico:</strong> squezada-2021262@kin...</p>
                    <p><strong>Dirección de envío preferida:</strong> No se seleccionó ninguna dirección de envío preferida.</p>
                    <p><strong>Método de pago preferido:</strong> No se seleccionó ningún método de pago preferido.</p>
                </div>

                <!-- Pedidos, carrito, crédito a la derecha -->
                <div class="mi-cuenta-right">
                    <div class="mi-cuenta-card pedidos-recientes">
                        <h3>Pedidos recientes</h3>
                        <p>Ha realizado <strong>0</strong> pedidos en los últimos 30 días.</p>
                        <button onclick="location.href = 'historial-pedidos.html'">Ver historial de pedidos</button>
                    </div>

                    <div class="mi-cuenta-card pedidos-carrito">
                        <h3>Pedidos en carrito</h3>
                        <p>Tienes <strong>0</strong> artículos en carrito.</p>
                        <button onclick="location.href = 'pedidos-anticipados.html'">Ver pedidos anticipados</button>
                    </div>

                    <div class="mi-cuenta-card credito-tienda">
                        <h3>Crédito de la tienda</h3>
                        <p>Actualmente tienes <strong>$0.00</strong> en crédito de la tienda BBTS.</p>
                    </div>
                </div>
            </section>
        </main>

        <!-- Pie de página -->
        <footer class="footer">
            <div class="container container-footer">
                <div class="menu-footer">
                    <div class="contact-info">
                        <p class="title-footer">Información de Contacto</p>
                        <ul>
                            <li>
                                Dirección: 71 Pennington Lane Vernon Rockville, CT
                                06066
                            </li>
                            <li>Teléfono: 123-456-7890</li>
                            <li>Fax: 55555300</li>
                            <li>EmaiL: baristas@support.com</li>
                        </ul>
                        <div class="social-icons">
                            <span class="facebook">
                                <i class="fa-brands fa-facebook-f"></i>
                            </span>
                            <span class="twitter">
                                <i class="fa-brands fa-twitter"></i>
                            </span>
                            <span class="youtube">
                                <i class="fa-brands fa-youtube"></i>
                            </span>
                            <span class="pinterest">
                                <i class="fa-brands fa-pinterest-p"></i>
                            </span>
                            <span class="instagram">
                                <i class="fa-brands fa-instagram"></i>
                            </span>
                        </div>
                    </div>

                    <div class="information">
                        <p class="title-footer">Información</p>
                        <ul>
                            <li><a href="#">Acerca de Nosotros</a></li>
                            <li><a href="#">Información Delivery</a></li>
                            <li><a href="#">Politicas de Privacidad</a></li>
                            <li><a href="#">Términos y condiciones</a></li>
                            <li><a href="#">Contactános</a></li>
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
                                Suscríbete a nuestros boletines ahora y mantente al
                                día con nuevas colecciones y ofertas exclusivas.
                            </p>
                            <input type="email" placeholder="Ingresa el correo aquí...">
                            <button>Suscríbete</button>
                        </div>
                    </div>
                </div>

                <div class="copyright">
                    <p>
                        Kinal Toy's &copy; 2025
                    </p>

                    <img src="img/payment.png" alt="Pagos">
                </div>
            </div>
        </footer>
    </body>
</html>
