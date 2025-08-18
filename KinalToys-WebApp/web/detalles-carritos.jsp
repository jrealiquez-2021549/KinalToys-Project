<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <img src="CuentaFoto" class="profile-pic" alt="Foto de Perfil">
                            <ul class="user-dropdown">
                                <li><a href="cuenta-admin.jsp">Mi cuenta</a></li>
                                <li><a href="#">Cambiar cuenta</a></li>
                                <li>
                                    <a href="Controlador?menu=Salir">
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
                        <li><a href="Controlador?menu=Principal">Inicio</a></li>
                        <li><a href="Controlador?menu=Usuarios&accion=Listar">Usuarios</a></li>
                        <li><a href="Controlador?menu=Facturas&accion=Listar">Facturas</a></li>
                        <li><a href="Controlador?menu=Noticias&accion=Listar">Noticias</a></li>
                        <li><a href="Controlador?menu=Proveedores&accion=Listar">Proveedores</a></li>
                        <li><a href="Controlador?menu=Juguetes&accion=Listar">Juguetes</a></li>
                        <li><a href="Controlador?menu=Cuentas&accion=Listar">Cuentas</a></li>
                        <li><a href="Controlador?menu=Carritos&accion=Listar">Carritos</a></li>
                        <li><a href="Controlador?menu=DetallesCarritos&accion=Listar">Detalles Carritos</a></li>
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

        <main class="main-users">
            <section class="users-section container">
                <h1 class="users-title">Detalles Carritos</h1>

                <!-- Formulario para agregar detalle -->
                <form action="Controlador?menu=DetallesCarritos" method="POST" class="formulario-detalle">
                    <div class="form-row">
                        <label>Cantidad:
                            <input type="number" name="txtCantidad" placeholder="Ej. 2" required>
                        </label>
                        <label>SubTotal:
                            <input type="number" step="0.01" name="txtSubTotal" placeholder="Ej. 300.00" required>
                        </label>
                    </div>

                    <div class="form-row">
                        <label>Descuento:
                            <input type="number" step="0.01" name="txtDescuento" placeholder="Ej. 20.00">
                        </label>
                        <label>Código Carrito:
                            <input type="number" name="txtCodigoCarrito" placeholder="Ej. 1" required>
                        </label>
                        <label>Código Juguete:
                            <input type="number" name="txtCodigoJuguete" placeholder="Ej. 1" required>
                        </label>
                    </div>

                    <div class="crud-buttons">
                        <button class="btn-crud" type="submit" name="accion" value="Agregar">Agregar</button>
                        <button class="btn-crud">Actualizar</button>
                    </div>
                </form>

                <div class="search-container">
                    <form class="search-form" action="Controlador" method="GET">
                        <input type="hidden" name="menu" value="Facturas" />
                        <div class="search-buttons">
                            <button class="btn-crud" name="accion" value="Buscar">Buscar</button>
                            <input type="text" class="input-search" placeholder="Buscar por ID..." name="id" />
                        </div>
                    </form>
                </div>

                <!-- Tabla de detalles -->
                <div class="table-wrapper">
                    <table class="users-table">
                        <thead>
                            <tr>
                                <th>Código Detalle</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Descuento Aplicado</th>
                                <th>Código Carrito</th>
                                <th>Código Juguete</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="detalle" items="${detallesCarritos}">
                                <tr>
                                    <td>${detalle.codigoDetalleC}</td>
                                    <td>${detalle.cantidad}</td>
                                    <td>${detalle.subTotal}</td>
                                    <td>${detalle.descuentoAplicado}</td>
                                    <td>${detalle.codigoCarrito}</td>
                                    <td>${detalle.codigoJuguete}</td>
                                    <td>
                                        <button class="btn-crud">Editar</button>
                                        <button class="btn-crud">Eliminar</button></td>
                                    </tr>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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