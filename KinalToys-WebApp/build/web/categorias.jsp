<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>KinalToys - Mafex</title>
        <link rel="stylesheet" href="css/categorias.css">
        <link rel="stylesheet" href="css/administrador.css">
        <link rel="stylesheet" href="css/principal.css">        
        <link rel="icon" href="img/kinal toys.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
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

        <main class="product-category-layout">
            <aside class="filters">
                <h2>Filtros</h2>
                <form class="search-forms filtros-search-form">
                    <input type="search" placeholder="Buscar..." class="search-input filtros-search-input" />
                    <button class="btn-search filtros-btn-search" type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>



                <details open>
                    <summary>Tipo</summary>
                    <label><input type="checkbox" name="tipo" value="accion"> Figuras de acción</label><br>
                    <label><input type="checkbox" name="tipo" value="estatua"> Estatuas</label><br>
                    <label><input type="checkbox" name="tipo" value="nendoroid"> Nendoroids</label>
                </details>

                <details open>
                    <summary>Marca</summary>
                    <label><input type="checkbox" id="marca-mafex" name="marca" value="mafex"> Mafex</label><br>
                    <label><input type="checkbox" id="marca-figma" name="marca" value="figma"> Figma</label><br>
                    <label><input type="checkbox" id="marca-megahouse" name="marca" value="megahouse"> MegaHouse</label>
                </details>


                <details open>
                    <summary>Estado</summary>
                    <label><input type="checkbox" name="estado" value="stock"> En stock</label><br>
                    <label><input type="checkbox" name="estado" value="oferta"> En oferta</label>
                </details>

                <details open>
                    <summary>Precio</summary>
                    <label>Mín:</label><br>
                    <input type="number" id="min-price" placeholder="0" style="width: 80%;"><br>
                    <label>Máx:</label><br>
                    <input type="number" id="max-price" placeholder="200" style="width: 80%;">
                </details>

                <details open>
                    <summary>Color</summary>
                    <label><input type="checkbox" name="color" value="rojo"> Rojo</label><br>
                    <label><input type="checkbox" name="color" value="azul"> Azul</label><br>
                    <label><input type="checkbox" name="color" value="negro"> Negro</label><br>
                    <label><input type="checkbox" name="color" value="blanco"> Blanco</label>
                </details>

                <details open>
                    <summary>Tamaño</summary>
                    <label><input type="checkbox" name="size" value="pequeno"> Pequeño</label><br>
                    <label><input type="checkbox" name="size" value="mediano"> Mediano</label><br>
                    <label><input type="checkbox" name="size" value="grande"> Grande</label>
                </details>

                <button onclick="filtrarProductos()">Filtrar</button>
            </aside>

            <!-- Productos Mafex -->
            <section class="product-list">
                <a href="detalle-spiderman-.html" class="product-card-link">
                    <div class="product-card">
                        <img src="img/spiderman-catalogo.jpg" alt="Spider-Man Mafex">
                        <div class="product-info">

                            <!-- Encabezado -->
                            <div class="top-info">
                                <span class="product-type">Figura de Acción</span>
                                <span class="badge new">NUEVO</span>
                                <span class="badge limited">LIMITADO</span>
                                <i class="fa-regular fa-heart favorite-icon"></i>
                            </div>

                            <h3>Spider-Man Mafex 075</h3>
                            <p class="brand">Marca: Mafex</p>

                            <div class="stock-sale">
                                <span class="in-stock">EN STOCK</span>
                                <span class="on-sale">EN OFERTA</span>
                            </div>

                            <div class="price">
                                <strong>$141.63</strong> <span class="old-price">$170.64</span>
                            </div>

                            <hr class="divider">

                            <p class="description">Figura articulada de Spider-Man con múltiples puntos de movimiento y accesorios incluidos.</p>
                            <p class="release-date">Lanzamiento: Marzo 2025</p>


                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                        </div>
                    </div>
                </a>

                <a href="detalle-gambito.html" class="product-card-link">
                    <div class="product-card">
                        <img src="img/gambito-catalogo.jpg" alt="Gambito Mafex">
                        <div class="product-info">

                            <!-- Encabezado -->
                            <div class="top-info">
                                <span class="product-type">Figura de Acción</span>
                                <span class="badge new">NUEVO</span>
                                <span class="badge limited">LIMITADO</span>
                                <i class="fa-regular fa-heart favorite-icon"></i>
                            </div>

                            <h3>Gambito: Figura de Accion</h3>
                            <p class="brand">Marca: Mafex</p>

                            <div class="stock-sale">
                                <span class="in-stock">EN STOCK</span>
                                <span class="on-sale">EN OFERTA</span>
                            </div>

                            <div class="price">
                                <strong>$141.63</strong> <span class="old-price">$170.64</span>
                            </div>

                            <hr class="divider">

                            <p class="description">Figura de Accion de Gambito con múltiples puntos de movimiento y accesorios incluidos.</p>
                            <p class="release-date">Lanzamiento: Enero 2024</p>

                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                        </div>
                    </div>
                </a>

            </section>


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
        <script>
            function getQueryParam(param) {
                const urlParams = new URLSearchParams(window.location.search);
                return urlParams.get(param);
            }

            window.addEventListener('DOMContentLoaded', () => {
                const marca = getQueryParam('categoria');
                if (marca) {
                    const checkboxId = 'marca-' + marca.toLowerCase();
                    const checkbox = document.getElementById(checkboxId);
                    if (checkbox) {
                        checkbox.checked = true;
                    }
                }
            });
        </script>

    </body>
</html>
