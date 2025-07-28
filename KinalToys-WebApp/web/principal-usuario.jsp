<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kinal Toy's (Menú Principal)</title>
        <!-- Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Icono -->
        <link rel="icon" href="img/kinal toys.png">
        <!-- CSS -->
        <link rel="stylesheet" href="css/principal.css">
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

        <section class="banner">
            <div class="content-banner">
                <p>Kinal TOYs</p>
                <h2>Donde la imaginación<br />cobra vida</h2>
                <a href="categorias.jsp">Comprar ahora</a>
            </div>
        </section>

        <main class="main-content">
            <section class="container container-features">
                <div class="card-feature">
                    <i class="fa-solid fa-plane-up"></i>
                    <div class="feature-content">
                        <span>Envío gratuito a nivel mundial</span>
                        <p>En pedido superior a $150</p>
                    </div>
                </div>
                <div class="card-feature">
                    <i class="fa-solid fa-wallet"></i>
                    <div class="feature-content">
                        <span>Contrareembolso</span>
                        <p>100% garantía de devolución de dinero</p>
                    </div>
                </div>
                <div class="card-feature">
                    <i class="fa-solid fa-gift"></i>
                    <div class="feature-content">
                        <span>Tarjeta regalo especial</span>
                        <p>Ofrece bonos especiales con regalo</p>
                    </div>
                </div>
                <div class="card-feature">
                    <i class="fa-solid fa-headset"></i>
                    <div class="feature-content">
                        <span>Servicio al cliente 24/7</span>
                        <p>LLámenos 24/7 al 123-456-7890</p>
                    </div>
                </div>
            </section>

            <section class="container top-categories">
                <h1 class="heading-1">Mejores Categorías</h1>
                <div class="container-categories">
                    <div class="card-category category-moca">
                        <p>Figma</p>
                        <a href="categorias.jsp?categoria=figma"><span>Ver más</span></a>
                    </div>
                    <div class="card-category category-expreso">
                        <p>MegaHouse</p>
                        <a href="categorias.jsp?categoria=megahouse"><span>Ver más</span></a>
                    </div>
                    <div class="card-category category-capuchino">
                        <p>Mafex</p>
                        <a href="categorias.jsp?categoria=mafex"><span>Ver más</span></a>
                    </div>
                </div>
            </section>

            <section class="container top-products">
                <h1 class="heading-1">Mejores Productos</h1>

                <div class="container-options">
                    <button class="btn-category active" data-category="featured">Destacados</button>
                    <button class="btn-category" data-category="latest">Más Recientes</button>
                    <button class="btn-category" data-category="best">Mejores Vendidos</button>
                </div>

                <div class="container-products">
                    <!-- Producto 1 -->
                    <div class="card-product">
                        <div class="container-img">
                            <img src="img/rem.jpg" alt="Re Zero Starting Life in Another World Rem Figma Figura" />
                            <span class="discount">-10%</span>
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                            <h3>Rem Figma Figure</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$125.73 <span>$139.70</span></p>
                        </div>
                    </div>
                    <!-- Producto 2 -->
                    <div class="card-product">
                        <div class="container-img">
                            <img
                                src="img/bell.jpg"
                                alt="Toy bell.jpg"
                                />
                            <span class="discount">-17%</span>
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                            <h3>Belle Good Smile</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$118.85 <span>$143.20</span></p>
                        </div>
                    </div>
                    <!--  -->
                    <div class="card-product">
                        <div class="container-img">
                            <img
                                src="img/link.jpg"
                                alt="Toy link"
                                />
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                            </div>
                            <h3>Link Figma Figure</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$137.80</p>
                        </div>
                    </div>
                    <!--  -->
                    <div class="card-product">
                        <div class="container-img">
                            <img src="img/frieren.jpg" alt="Toy frieren" />
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                            <h3>Frieren Nendoroid</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$132.20</p>
                        </div>
                    </div>
                </div>
            </section>

            <section class="gallery">
                <img
                    src="img/Figma.jpg"
                    alt="Gallery Img1"
                    class="gallery-img-1"
                    /><img
                    src="img/Good Smile Company.jpg"
                    alt="Gallery Img2"
                    class="gallery-img-2"
                    /><img
                    src="img/Kotobukiya.jpg"
                    alt="Gallery Img3"
                    class="gallery-img-3"
                    /><img
                    src="img/Mafex.jpg"
                    alt="Gallery Img4"
                    class="gallery-img-4"
                    /><img
                    src="img/MegaHouse.png"
                    alt="Gallery Img5"
                    class="gallery-img-5"
                    />
            </section>

            <section class="container specials">
                <h1 class="heading-1">Pre-Orden</h1>

                <div class="container-products">
                    <!-- Producto 1 -->
                    <div class="card-product">
                        <div class="container-img">
                            <img src="img/spiderman.jpg" alt="Cafe spiderman" />
                            <span class="discount">-17%</span>
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                            <h3>Spider-Man Mafex 075</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$141.63 <span>$170.64</span></p>
                        </div>
                    </div>
                    <!-- Producto 2 -->
                    <div class="card-product">
                        <div class="container-img">
                            <img
                                src="img/gambito.jpg"
                                alt="Toy gambito"
                                />
                            <span class="discount">-9%</span>
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                            <h3>Gambito Mafex</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$125.48 <span>$137.90</span></p>
                        </div>
                    </div>
                    <!--  -->
                    <div class="card-product">
                        <div class="container-img">
                            <img src="img/marcill.jpg" alt="Marcill" />
                            <span class="discount">-13%</span>
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                            </div>
                            <h3>Marcille Figma</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$132.41 <span>$152.20</span></p>
                        </div>
                    </div>
                    <!--  -->
                    <div class="card-product">
                        <div class="container-img">
                            <img src="img/madoka.jpg" alt="Madoka" />
                            <div class="button-group">
                                <span>
                                    <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-code-compare"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-card-product">
                            <div class="stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-regular fa-star"></i>
                            </div>
                            <h3>Madoka Good Smile</h3>
                            <span class="add-cart">
                                <i class="fa-solid fa-basket-shopping"></i>
                            </span>
                            <p class="price">$186.98</p>
                        </div>
                    </div>
                </div>
            </section>

            <section class="container blogs">
                <h1 class="heading-1">Últimas Novedades</h1>

                <div class="container-blogs">
                    <div class="card-blog">
                        <div class="container-img">
                            <img src="img/anuncio-momo.jpg" alt="Anuncio Momo" />
                            <div class="button-group-blog">
                                <span>
                                    <i class="fa-solid fa-magnifying-glass"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-link"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-blog">
                            <h3>Figma Momo Ayase de DanDaDan en desarrollo</h3>
                            <span>4 de Abril de 2025</span>
                            <p>
                                Figma ha anunciado el desarrollo de una figura de Momo Ayase de la serie DanDaDan.
                                Aunque aún no se ha revelado una fecha de lanzamiento específica, los fanáticos
                                esperan que esta figura compita con otras versiones disponibles en el mercado,
                                como la de SHFiguarts. Se anticipa que más detalles se revelen en eventos como
                                el Wonder Festival 2025.
                            </p>
                            <div class="btn-read-more">Leer más</div>
                        </div>
                    </div>
                    <div class="card-blog">
                        <div class="container-img">
                            <img src="img/anuncio-nate.jpg" alt="Anuncio Nate" />
                            <div class="button-group-blog">
                                <span>
                                    <i class="fa-solid fa-magnifying-glass"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-link"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-blog">
                            <h3>Mafex a anunciado No.251: X-Man (Nate Grey)</h3>
                            <span>23 de Septiembre de 2024</span>
                            <p>
                                Medicom Toy ha anunciado la figura Mafex No.251 de X-Man (Nate Grey), programada
                                para su lanzamiento en julio de 2025. Esta figura destaca por su diseño detallado y
                                articulación, características distintivas de la línea Mafex. Los fanáticos pueden
                                esperar una representación fiel del personaje, con múltiples puntos de articulación
                                y accesorios intercambiables.
                            </p>
                            <div class="btn-read-more">Leer más</div>
                        </div>
                    </div>
                    <div class="card-blog">
                        <div class="container-img">
                            <img src="img/anuncio-final.jpg" alt="Anuncio Final" />
                            <div class="button-group-blog">
                                <span>
                                    <i class="fa-solid fa-magnifying-glass"></i>
                                </span>
                                <span>
                                    <i class="fa-solid fa-link"></i>
                                </span>
                            </div>
                        </div>
                        <div class="content-blog">
                            <h3>Colaboración con Square Enix para figuras escala de Final Fantasy</h3>
                            <span>9 de Febrero de 2025</span>
                            <p>
                                Good Smile Company en el evento WONDERFUL HOBBY LIFE FOR YOU!! 39 anunció una colaboración con Square
                                Enix para lanzar figuras escala de Final Fantasy, con prototipos de Noctis
                                (FFXV) y Lightning (FFXIII) ya revelados, y Fran (FFXII) en desarrollo; la
                                línea apunta a fans y coleccionistas con figuras de alta calidad.
                            </p>
                            <div class="btn-read-more">Leer más</div>
                        </div>
                    </div>
                </div>
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
                    </div>                     </div> 
                <div class="copyright">
                    <p>
                        Kinal Toy's &copy; 2025
                    </p>

                    <img src="img/payment.png" alt="Pagos">
                </div>
            </div>
        </footer>
        <script>
                    document.addEventListener("DOMContentLoaded", () => {
                const buttons = document.querySelectorAll(".btn-category");
                    const productsContainer = document.querySelector(".container-products");
            // Aquí defines tus productos por categoría (puedes personalizarlos)
            const productsByCategory = {                 featured: `
            <!-- Producto 1 -->
                            <div class="card-product">
            <div class="container-img">
                            <img src="img/rem.jpg" alt="Re Zero Starting Life in Another World Rem Figma Figura" />
                                <span class="discount">-10%</span>
                                <div class="button-group">                             <span>
                                <i class="fa-regular fa-eye"></i>
                                </span>
                                <span>                                         <i class="fa-regular fa-heart"></i>
                                </span>
                                <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                            </div>
                            </div>
                    <div class="content-card-product">
                    <div class="stars">
                        <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                </div>
                                <h3>Rem Figma Figure</h3>
                                    <span class="add-cart">
                        <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$125.73 <span>$139.70</span></p>
                            </div>
                            </div>
                            <!-- Producto 2 -->
                                <div class="card-product">
                                <div class="container-img">
                            <img
                                src="img/bell.jpg"
                                alt="Toy bell.jpg"
                            />
                                <span class="discount">-17%</span>
                                <div class="button-group">
                                <span>
                                <i class="fa-regular fa-eye"></i>
                                </span>
                            <span>
                        <i class="fa-regular fa-heart"></i>
                    </span>
                <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                    </div>
                            </div>
                    <div class="content-card-product">
                                <div class="stars">
                                <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Belle Good Smile</h3>
                            <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                                    </span>
                                    <p class="price">$118.85 <span>$143.20</span></p>
                                </div>
                                    </div>
                                    <!--  -->
                                <div class="card-product">
                                    <div class="container-img">
                                <img
                            src="img/link.jpg"
                        alt="Toy link"
                                                         />
                                                         <div class="button-group">
                                                                 <span>
                                                                         <i class="fa-regular fa-eye"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-regular fa-heart"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-solid fa-code-compare"></i>
                                                                 </span>
                                                         </div>
                                                 </div>
                                                 <div class="content-card-product">
                                                         <div class="stars">
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                         </div>
                                                         <h3>Link Figma Figure</h3>
                                                         <span class="add-cart">
                                                                 <i class="fa-solid fa-basket-shopping"></i>
                                                         </span>
                                                         <p class="price">$137.80</p>
                                                 </div>
                                         </div>
                                         <!--  -->
                                         <div class="card-product">
                                         <div class="container-img">
                                                 <img src="img/frieren.jpg" alt="Toy frieren" />
                                                 <div class="button-group">
                                         <span>
                                                 <i class="fa-regular fa-eye"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-regular fa-heart"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-solid fa-code-compare"></i>
                                         </span>
                                         </div>
                                 </div>
                                 <div class="content-card-product">
                                 <div class="stars">
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-regular fa-star"></i>
                                 </div>
                                 <h3>Frieren Nendoroid</h3>
                                 <span class="add-cart">
                                         <i class="fa-solid fa-basket-shopping"></i>
                                 </span>
                                 <p class="price">$132.20</p>
                         </div>
                 </div>
         `,
         latest: `
                 <!-- Producto 1 -->
                 <div class="card-product">
                         <div class="container-img">
                                 <img src="img/frieren-figma.jpg" alt="Sousou no Frieren Frieren Figma Figura" />
                                 <div class="button-group">
                                         <span>
                                                 <i class="fa-regular fa-eye"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-regular fa-heart"></i>
                                         </span>
                                         <span>
                                         <i class="fa-solid fa-code-compare"></i>
                                         </span>
                                                 </div>
                                         </div>
                                         <div class="content-card-product">
                                                 <div class="stars">
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                 </div>
                                                 <h3>Frieren Figma Figure</h3>
                                                 <span class="add-cart">
                                                         <i class="fa-solid fa-basket-shopping"></i>
                                                 </span>
                                                 <p class="price">$124.45</p>
                                         </div>
                                         </div>
                                         <!-- Producto 2 -->
                                         <div class="card-product">
                                                 <div class="container-img">
                                                         <img
                                                                 src="img/lufi.jpg"
                                                                 alt="Toy lufi.jpg"
                                                         />
                                                         <span class="discount">-10%</span>
                                                         <div class="button-group">
                                                                 <span>
                                                                         <i class="fa-regular fa-eye"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-regular fa-heart"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-solid fa-code-compare"></i>
                                                                 </span>
                                                         </div>
                                                 </div>
                                                 <div class="content-card-product">
                                                         <div class="stars">
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-regular fa-star"></i>
                                                         </div>
                                                         <h3>Luffy Mafex</h3>
                                                         <span class="add-cart">
                                                                 <i class="fa-solid fa-basket-shopping"></i>
                                                         </span>
                                                         <p class="price">$114.65 <span>$129.43</span></p>
                                                 </div>
                                         </div>
                                         <!--  -->
                                         <div class="card-product">
                                                 <div class="container-img">
                                                         <img
                                                                 src="img/captain-america.jpg"
                                                                 alt="Toy Captain"
                                                         />
                                                         <div class="button-group">
                                                                 <span>
                                                                         <i class="fa-regular fa-eye"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-regular fa-heart"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-solid fa-code-compare"></i>
                                                                 </span>
                                                         </div>
                                                 </div>
                                                 <div class="content-card-product">
                                                         <div class="stars">
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                         </div>
                                                         <h3>Captain America Mafex</h3>
                                                         <span class="add-cart">
                                                                 <i class="fa-solid fa-basket-shopping"></i>
                                                         </span>
                                                         <p class="price">$128.75</p>
                                                 </div>
                                         </div>
                                         <!--  -->
                                         <div class="card-product">
                                         <div class="container-img">
                                                 <img src="img/wolverine.jpg" alt="Toy Wolverine" />
                                                 <div class="button-group">
                                         <span>
                                                 <i class="fa-regular fa-eye"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-regular fa-heart"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-solid fa-code-compare"></i>
                                         </span>
                                         </div>
                                 </div>
                                 <div class="content-card-product">
                                 <div class="stars">
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                 </div>
                                 <h3>Wolverine Mafex Figure</h3>
                                 <span class="add-cart">
                                         <i class="fa-solid fa-basket-shopping"></i>
                                 </span>
                                 <p class="price">$143.15</p>
                         </div>
                 </div>
         `,
         best: `
                 <!-- Producto 1 -->
                 <div class="card-product">
                         <div class="container-img">
                                 <img src="img/laios.jpg" alt="Dungeon Meshi Laios Figma Figura" />
                                 <div class="button-group">
                                         <span>
                                                 <i class="fa-regular fa-eye"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-regular fa-heart"></i>
                                         </span>
                                         <span>
                                         <i class="fa-solid fa-code-compare"></i>
                                         </span>
                                                 </div>
                                         </div>
                                         <div class="content-card-product">
                                                 <div class="stars">
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                         <i class="fa-solid fa-star"></i>
                                                 </div>
                                                 <h3>Rem Figma Figure</h3>
                                                 <span class="add-cart">
                                                         <i class="fa-solid fa-basket-shopping"></i>
                                                 </span>
                                                 <p class="price">$110.48</p>
                                         </div>
                                         </div>
                                         <!-- Producto 2 -->
                                         <div class="card-product">
                                                 <div class="container-img">
                                                         <img
                                                                 src="img/keibol.jpg"
                                                                 alt="Toy Keibol.jpg"
                                                         />
                                                         <div class="button-group">
                                                                 <span>
                                                                         <i class="fa-regular fa-eye"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-regular fa-heart"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-solid fa-code-compare"></i>
                                                                 </span>
                                                         </div>
                                                 </div>
                                                 <div class="content-card-product">
                                                         <div class="stars">
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                         </div>
                                                         <h3>Keibol Yamaguchi</h3>
                                                         <span class="add-cart">
                                                                 <i class="fa-solid fa-basket-shopping"></i>
                                                         </span>
                                                         <p class="price">$150.99</p>
                                                 </div>
                                         </div>
                                         <!--  -->
                                         <div class="card-product">
                                                 <div class="container-img">
                                                         <img
                                                                 src="img/samus.jpg"
                                                                 alt="Toy Samus"
                                                         />
                                                         <div class="button-group">
                                                                 <span>
                                                                         <i class="fa-regular fa-eye"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-regular fa-heart"></i>
                                                                 </span>
                                                                 <span>
                                                                         <i class="fa-solid fa-code-compare"></i>
                                                                 </span>
                                                         </div>
                                                 </div>
                                                 <div class="content-card-product">
                                                         <div class="stars">
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                                 <i class="fa-solid fa-star"></i>
                                                         </div>
                                                         <h3>Samus Figma Figure</h3>
                                                         <span class="add-cart">
                                                                 <i class="fa-solid fa-basket-shopping"></i>
                                                         </span>
                                                         <p class="price">$137.87</p>
                                                 </div>
                                         </div>
                                         <!--  -->
                                         <div class="card-product">
                                         <div class="container-img">
                                                 <img src="img/bell-nendo.jpg" alt="Toy Bell Nendo" />
                                                 <div class="button-group">
                                         <span>
                                                 <i class="fa-regular fa-eye"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-regular fa-heart"></i>
                                         </span>
                                         <span>
                                                 <i class="fa-solid fa-code-compare"></i>
                                         </span>
                                         </div>
                                 </div>
                                 <div class="content-card-product">
                                 <div class="stars">
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                         <i class="fa-solid fa-star"></i>
                                 </div>
                                 <h3>Bell Nendoroid</h3>
                                 <span class="add-cart">
                                         <i class="fa-solid fa-basket-shopping"></i>
                                 </span>
                                 <p class="price">$121.30</p>
                         </div>
                 </div>
         `
         };

         buttons.forEach(button => {
         button.addEventListener("click", () => {
                 // 1. Activar botón seleccionado
                 buttons.forEach(btn => btn.classList.remove("active"));
                 button.classList.add("active");

                 // 2. Leer categoría desde el atributo data-category
                 const category = button.getAttribute("data-category");

                 // 3. Animación de fade out -> cambio -> fade in
                 productsContainer.style.opacity = 0;

                 setTimeout(() => {
                 productsContainer.innerHTML = productsByCategory[category] || "<p>No products available</p>";
                 productsContainer.style.opacity = 1;
                 }, 300); // tiempo igual a la transición CSS
         });
         });
 });
        </script>
    </body>
</html>