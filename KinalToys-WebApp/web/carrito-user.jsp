<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kinal Toy's (Carrito)</title>
        <!-- Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
              integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Icono -->
        <link rel="icon" href="img/kinal toys.png">
        <!-- CSS -->
        <link rel="stylesheet" href="css/principal.css">
        <link rel="stylesheet" href="css/carrito.css">
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
                        <h1 class="logo"><a href="#">Kinal Toy's</a></h1>
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

        <div class="carrito-container">
            <div class="carrito-header">
                <div>Producto</div>
                <div>Envío</div>
                <div>Precio</div>
                <div>Descuento</div>
                <div>Cantidad</div>
                <div>Total</div>
            </div>

            <!--Inicio del item-->
            <div class="item-carrito">
                <div class="producto-info">
                    <img src="img/spiderman.jpg" alt="Spider-Man" />
                    <p>Spider-Man Mafex 075</p>
                </div>
                <div class="envio">&dollar; 35</div>
                <div class="precio">
                    <span class="precio-original">&dollar; 170.64</span><br>
                    &dollar; 141.63 <!--Precio con descuento aplicado-->
                </div>
                <div class="descuento">-&dollar; 29.01</div>
                <div class="cantidad"><input type="number" value="1" min="1"></div>
                <div class="total">&dollar; 141.63</div>
                <div class="eliminar"> <button type="eliminar" class="eliminar">
                        <span class="button__text">Eliminar</span>
                        <span class="button__icon"><svg xmlns="http://www.w3.org/2000/svg" width="512" viewBox="0 0 512 512"
                                                        height="512" class="svg">
                            <title></title>
                            <path
                                style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"
                                d="M112,112l20,320c.95,18.49,14.4,32,32,32H348c17.67,0,30.87-13.51,32-32l20-320"></path>
                            <line y2="112" y1="112" x2="432" x1="80"
                                  style="stroke:#fff;stroke-linecap:round;stroke-miterlimit:10;stroke-width:32px"></line>
                            <path
                                style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"
                                d="M192,112V72h0a23.93,23.93,0,0,1,24-24h80a23.93,23.93,0,0,1,24,24h0v40"></path>
                            <line y2="400" y1="176" x2="256" x1="256"
                                  style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px">
                            </line>
                            <line y2="400" y1="176" x2="192" x1="184"
                                  style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px">
                            </line>
                            <line y2="400" y1="176" x2="320" x1="328"
                                  style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px">
                            </line>
                            </svg></span>
                    </button></div>
            </div>
            <!--Findel item-->

            <!--Inicio del item-->
            <div class="item-carrito">
                <div class="producto-info">
                    <img src="img/gambito.jpg" alt="Gambito" />
                    <p>Gambito Mafex</p>
                </div>
                <div class="envio">&dollar; 35</div>
                <div class="precio">
                    <span class="precio-original">&dollar; 137.90</span><br>
                    &dollar; 125.48 <!--Precio con descuento aplicado-->
                </div>
                <div class="descuento">-&dollar; 12.42</div>
                <div class="cantidad"><input type="number" value="1" min="1"></div>
                <div class="total">&dollar; 125.48</div>
                <div class="eliminar"> <button type="eliminar" class="eliminar">
                        <span class="button__text">Eliminar</span>
                        <span class="button__icon"><svg xmlns="http://www.w3.org/2000/svg" width="512" viewBox="0 0 512 512"
                                                        height="512" class="svg">
                            <title></title>
                            <path
                                style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"
                                d="M112,112l20,320c.95,18.49,14.4,32,32,32H348c17.67,0,30.87-13.51,32-32l20-320"></path>
                            <line y2="112" y1="112" x2="432" x1="80"
                                  style="stroke:#fff;stroke-linecap:round;stroke-miterlimit:10;stroke-width:32px"></line>
                            <path
                                style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"
                                d="M192,112V72h0a23.93,23.93,0,0,1,24-24h80a23.93,23.93,0,0,1,24,24h0v40"></path>
                            <line y2="400" y1="176" x2="256" x1="256"
                                  style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px">
                            </line>
                            <line y2="400" y1="176" x2="192" x1="184"
                                  style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px">
                            </line>
                            <line y2="400" y1="176" x2="320" x1="328"
                                  style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px">
                            </line>
                            </svg></span>
                    </button></div>
            </div>
            <!--Findel item-->
        </div>

        <div class="resumen-carrito">
            <p><strong>Subtotal:</strong> $2,498.00</p>
            <p><strong>Descuento:</strong> -&dollar; 41.43</p>
            <h3><strong>Total:</strong> &dollar; 267.11</h3>
            <a href="factura-user.jsp">
                <button type="btn-comprar">Pagar</button>
            </a>
        </div>
    </main>


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