<%-- 
    Document   : DetallesCarritos
    Created on : 26/07/2025, 19:24:27
    Author     : leocu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles Carrito</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="css/detalle-carrito.css">
        <link rel="stylesheet" href="css/principal.css">
        <link rel="stylesheet" href="css/crud.css">
        <link rel="icon" href="img/kinal toys.png">
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
                            <i class="fa-solid fa-basket-shopping"></i>
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

        <main>
            <!-- Formulario de detalles -->
            <section class="formulario-container">
                <h1 class="users-title">Detalles de Carritos</h1>
                
                <form class="formulario-detalle">
                    <div class="form-row">
                        <label>Cantidad:
                            <input type="number" name="cantidad" min="1"  placeholder="Ej. 1">
                        </label>

                        <label>Subtotal:
                            <input type="number" step="0.01" name="subTotal"  placeholder="Ej. 599.99">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>Descuento Aplicado:
                            <input type="number" step="0.01" name="descuento"  placeholder="Ej. 20">
                        </label>

                        <label>Código Carrito:
                            <input type="number" name="codigoCarrito"  placeholder="Ej. 1">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>Código Juguete:
                            <input type="number" name="codigoJuguete"  placeholder="Ej. 1">
                        </label>
                    </div>

                </form>
                <!-- Lista de detalles -->
            <div class="table-wrapper">
                    <table class="users-table">
                        <thead>
                            <tr>
                                <th>Código Detalles Carrito</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Descuento Aplicado</th>
                                <th>Código Carrito</th>
                                <th>Código Juguete</th>
                            </tr>
                        </thead>
                        <tbody id="detalle-carrito">
                            <tr>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="crud-buttons">
                    <button class="btn-crud">Agregar</button>
                    <button class="btn-crud">Listar</button>
                    <button class="btn-crud">Buscar</button>
                    <input type="text" class="input-search" placeholder="código de Detalle carrito..." />
                    <button class="btn-crud">Eliminar</button>
                    <button class="btn-crud">Actualizar</button>
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