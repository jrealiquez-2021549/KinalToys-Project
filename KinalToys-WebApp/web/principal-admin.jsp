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
                                <li><a href="cuenta-admin.jsp">Mi cuenta</a></li>
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
                        <li><a href="principal-admin.jsp">Inicio</a></li>
                        <li><a href="usuario.jsp">Usuarios</a></li>
                        <li><a href="factura.jsp">Facturas</a></li>
                        <li><a href="noticia.jsp">Noticias</a></li>
                        <li><a href="proveedor.jsp">Proveedores</a></li>
                        <li><a href="juguete.jsp">Juguetes</a></li>
                        <li><a href="cuenta.jsp">Cuentas</a></li>
                        <li><a href="carrito.jsp">Carritos</a></li>
                        <li><a href="detalles-carritos.jsp">Detalles Carritos</a></li>
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

        <main class="main-content">
            <section class="container container-dashboard">
                <!-- LADO IZQUIERDO: Lista de tareas -->
                <div class="dashboard-left">
                    <h2 class="heading-1">Lista de Tareas a Realizar</h2>

                    <form id="task-form" class="task-form">
                        <ul class="task-list">
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Registrar nuevo usuario
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Revisar facturas pendientes
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Publicar nueva noticia
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Actualizar stock de juguetes
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Revisar cuentas de usuarios
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Agregar proveedor nuevo
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Revisar carritos activos
                                </label>
                            </li>
                            <li>
                                <label>
                                    <input type="checkbox" class="task-checkbox" />
                                    Detallar compras recientes
                                </label>
                            </li>
                        </ul>

                        <div class="task-summary">
                            <p><strong>Tareas Completadas:</strong> <span id="completed-count">0</span> / 8</p>
                        </div>

                        <button type="submit" class="btn-submit-report">Enviar Informe</button>
                    </form>
                </div>

                <!-- LADO DERECHO: Botones como categorías -->
                <div class="dashboard-right">
                    <div class="container-cruds">
                        <div class="card-category usuarios-bg">
                            <p>Usuarios</p>
                            <a href="usuario.jsp?categoria=usuarios"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category facturas-bg">
                            <p>Facturas</p>
                            <a href="factura.jsp?categoria=facturas"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category noticias-bg">
                            <p>Noticias</p>
                            <a href="noticia.jsp?categoria=noticias"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category proveedores-bg">
                            <p>Proveedores</p>
                            <a href="proveedor.jsp?categoria=proveedores"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category juguetes-bg">
                            <p>Juguetes</p>
                            <a href="juguete.jsp?categoria=juguetes"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category cuentas-bg">
                            <p>Cuentas</p>
                            <a href="cuenta.jsp?categoria=cuentas"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category carritos-bg">
                            <p>Carritos</p>
                            <a href="carrito.jsp?categoria=carritos"><span>Ingresar</span></a>
                        </div>
                        <div class="card-category detalles-bg">
                            <p>Detalles Carritos</p>
                            <a href="detalle.jsp?categoria=detalles"><span>Ingresar</span></a>
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
                            <li><a href="cuenta-admin.jsp">Mi cuenta</a></li>
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
            document.addEventListener('DOMContentLoaded', () => {
                const checkboxes = document.querySelectorAll('.task-checkbox');
                const completedCount = document.getElementById('completed-count');

                function updateCount() {
                    const count = Array.from(checkboxes).filter(cb => cb.checked).length;
                    completedCount.textContent = count;
                }

                checkboxes.forEach(cb => {
                    cb.addEventListener('change', updateCount);
                });

                document.getElementById('task-form').addEventListener('submit', function (e) {
                    e.preventDefault();
                    alert('Informe enviado correctamente ?');
                });
            });
        </script>
    </body>
</html>