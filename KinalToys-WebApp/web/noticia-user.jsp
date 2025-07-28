<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kinal Toy's (Novedades)</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="icon" href="img/kinal toys.png">
        <link rel="stylesheet" href="css/noticias.css">
        <link rel="stylesheet" href="css/principal.css">
        <link rel="stylesheet" href="css/administrador.css">
        <link rel="stylesheet" href="css/crud.css">
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

        <main>
            <section class="highlight-news-section">
                <div class="container highlight-news">
                    <div class="highlight-image">
                        <img src="img/anuncio-Pokemon.jpeg" alt="Anuncio de la nueva colaboración Lego Pokémon">
                    </div>
                    <div class="highlight-content">
                        <h2>Lego Anuncia Colaboración con Pokémon: Una Nueva Era de Construcción Creativa</h2>
                        <p> Lego se complace en anunciar su ambiciosa nueva línea
                            de productos, resultado de una emocionante colaboración
                            con la icónica franquicia Pokémon. Este proyecto representa
                            un hito significativo para la compañía, ya que expande su
                            universo de construcción hacia una de las propiedades intelectuales
                            más queridas a nivel mundial.</p>
                        <div class="btn-read-more">Leer más</div>
                    </div>
                </div>
            </section>

            <section class="regular-news-section">
                <div class="container carousel-container">
                    <button class="carousel-arrow left-arrow" aria-label="Noticia anterior">
                        <i class="fa-solid fa-chevron-left"></i>
                    </button>
                    <div class="carousel-wrapper">
                        <div class="container-blogs carousel-inner">
                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-momo.jpg" alt="Figma de Momo Ayase de DanDaDan">
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Figma Momo Ayase de DanDaDan en desarrollo</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-leon.jpeg" alt="Funko Pop de El Rey León (Hakuna Matata)">
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Funko Pop Hakuna Matata</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-star.jpg" alt="Juego de construcción Gravitrax Star Wars Death Star">
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Gravitrax Star Wars Death Star</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-estelladelamuerte.jpeg" alt="Imagen de la Estrella de la Muerte">
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Anuncio de la Estrella de la Muerte</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-nate.jpg" alt="Figura Mafex de X-Man (Nate Grey)" />
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Mafex ha anunciado No.251: X-Man (Nate Grey)</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-final.jpg" alt="Colaboración con Square Enix para figuras de Final Fantasy" />
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Colaboración con Square Enix para figuras escala de Final Fantasy</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                            <div class="card-blog carousel-item">
                                <div class="container-img">
                                    <img src="img/anuncio-BlueLock.jpeg" alt="Otra noticia de carrusel 1" />
                                    <div class="button-group-blog">
                                        <span>
                                            <i class="fa-solid fa-magnifying-glass" aria-label="Ver imagen más grande"></i>
                                        </span>
                                        <span>
                                            <i class="fa-solid fa-link" aria-label="Ir a la noticia"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="content-blog">
                                    <h3>Blue Lock anuncia su nueva figura de Isagi</h3>
                                    <div class="btn-read-more">Leer más</div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <button class="carousel-arrow right-arrow" aria-label="Siguiente noticia">
                        <i class="fa-solid fa-chevron-right"></i>
                    </button>
                </div>
            </section>

            <section class="news-categories-buttons-section">
                <div class="container buttons-container">
                    <button class="category-button">Destacados</button>
                    <button class="category-button">Próximamente</button>
                    <button class="category-button">Lanzamientos Recientes</button> </div>
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
                            <li>Teléfono: <a href="tel:123-456-7890">123-456-7890</a></li>
                            <li>Fax: 55555300</li>
                            <li>Email: <a href="mailto:baristas@support.com">baristas@support.com</a></li>
                        </ul>
                        <div class="social-icons">
                            <span class="facebook">
                                <i class="fa-brands fa-facebook-f" aria-label="Facebook"></i>
                            </span>
                            <span class="twitter">
                                <i class="fa-brands fa-twitter" aria-label="Twitter"></i>
                            </span>
                            <span class="youtube">
                                <i class="fa-brands fa-youtube" aria-label="YouTube"></i>
                            </span>
                            <span class="pinterest">
                                <i class="fa-brands fa-pinterest-p" aria-label="Pinterest"></i>
                            </span>
                            <span class="instagram">
                                <i class="fa-brands fa-instagram" aria-label="Instagram"></i>
                            </span>
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
                            <li><a href="#">Historial de órdenes</a></li>
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
                            <input type="email" placeholder="Ingresa el correo aquí..." aria-label="Dirección de correo electrónico para suscripción">
                            <button aria-label="Suscribirse al boletín">Suscríbete</button>
                        </div>
                    </div>
                </div>

                <div class="copyright">
                    <p>
                        Kinal Toy's &copy; 2025
                    </p>
                    <img src="img/payment.png" alt="Métodos de pago aceptados">
                </div>
            </div>
        </footer>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                // Apuntamos al nuevo carousel-inner que ahora es .container-blogs
                const carouselInner = document.querySelector('.container-blogs.carousel-inner');
                const carouselItems = document.querySelectorAll('.card-blog.carousel-item');
                const leftArrow = document.querySelector('.carousel-arrow.left-arrow');
                const rightArrow = document.querySelector('.carousel-arrow.right-arrow');

                if (!carouselInner || carouselItems.length === 0 || !leftArrow || !rightArrow) {
                    console.warn('Uno o más elementos del carrusel no encontrados. La funcionalidad podría estar afectada.');
                    return; // Salir si faltan elementos
                }

                let currentIndex = 0; // Índice del primer ítem visible
                const totalItems = carouselItems.length;
                const itemsPerPage = 4; // Queremos mostrar 4 ítems a la vez inicialmente

                // Función para obtener el valor del gap en píxeles
                const getGapValue = () => {
                    const style = window.getComputedStyle(carouselInner);
                    const gap = style.getPropertyValue('gap');
                    return parseFloat(gap) || 0; // Convierte '2rem' o '32px' a un número, o 0 si no hay gap
                };

                // Función para actualizar la posición del carrusel
                const updateCarousel = () => {
                    // Obtenemos el ancho de un solo ítem (incluyendo su propio padding/borde)
                    // Y le sumamos el valor del gap para el desplazamiento efectivo de un ítem
                    const itemWidthWithGap = carouselItems[0].offsetWidth + getGapValue();

                    // El desplazamiento total es el índice actual multiplicado por el ancho de un ítem + gap
                    carouselInner.style.transform = `translateX(${-currentIndex * itemWidthWithGap}px)`;

                    // Control de las flechas para deshabilitarlas si estamos al principio o al final
                    leftArrow.disabled = currentIndex === 0;
                    rightArrow.disabled = currentIndex >= totalItems - itemsPerPage; // Deshabilita si quedan menos de `itemsPerPage` ítems por mostrar

                    leftArrow.style.opacity = currentIndex === 0 ? '0.5' : '1';
                    rightArrow.style.opacity = currentIndex >= totalItems - itemsPerPage ? '0.5' : '1';
                };

                // Event listener para la flecha derecha (Siguiente)
                rightArrow.addEventListener('click', () => {
                    // Solo avanza si no estamos en los últimos ítems que pueden mostrarse
                    if (currentIndex < totalItems - itemsPerPage) {
                        currentIndex++;
                        updateCarousel();
                    }
                });

                // Event listener para la flecha izquierda (Anterior)
                leftArrow.addEventListener('click', () => {
                    if (currentIndex > 0) {
                        currentIndex--;
                        updateCarousel();
                    }
                });

                // Inicializa la posición del carrusel al cargar la página
                updateCarousel();

                // Recalcula el ancho de los ítems y actualiza la posición al redimensionar la ventana
                window.addEventListener('resize', updateCarousel);
            });

            document.addEventListener('DOMContentLoaded', () => {

                // Lógica para los botones de categorías de noticias
                const categoryButtons = document.querySelectorAll('.category-button');

                // Opcional: Para que "Destacados" esté activo al cargar la página por primera vez
                // Descomenta la siguiente línea si quieres que uno inicie activo
                // if (categoryButtons.length > 0) {
                //     categoryButtons[0].classList.add('active');
                // }

                // Función para manejar el clic en los botones de categoría
                const handleCategoryButtonClick = (event) => {
                    // Remover la clase 'active' de todos los botones
                    categoryButtons.forEach(button => {
                        button.classList.remove('active');
                    });

                    // Añadir la clase 'active' al botón que fue clicado
                    event.target.classList.add('active');

                    // Aquí podrías añadir lógica adicional para cargar contenido
                    // basado en el botón seleccionado (ej. 'Destacados', 'Proximamente', 'Lanzamientos Recientes')
                    // console.log(`Categoría seleccionada: ${event.target.textContent}`);
                };

                // Añadir el event listener a cada botón de categoría
                categoryButtons.forEach(button => {
                    button.addEventListener('click', handleCategoryButtonClick);
                });
            });
        </script>
    </body>
</html>