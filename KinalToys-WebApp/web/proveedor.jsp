<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kinal Toy's (Proveedores)</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="icon" href="img/kinal toys.png">
        <link rel="stylesheet" href="css/principal.css">
        <link rel="stylesheet" href="css/crud.css">
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
                            <li><a href="Controlador?menu=Empleados&accion=Listar">Emplados</a></li>
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
                <h1 class="users-title">Proveedores</h1>

                <form action="Controlador" method="POST" class="users-form">
                    <input type="hidden" name="menu" value="Proveedores"/>
                    <input type="hidden" name="codigoProveedor" value="${proveedorSeleccionado.codigoProveedor}"/>

                    <div class="form-group">
                        <label for="nombre-proveedor"><strong>Nombre Proveedor:</strong></label>
                        <input type="text" id="nombre-proveedor" name="nombre-proveedor" placeholder="Ej. Farmacias del Ahorro" 
                               value="${proveedorSeleccionado.nombreProveedor}" required />
                    </div>

                    <div class="form-group">
                        <label for="telefono-proveedor"><strong>Teléfono:</strong></label>
                        <input type="text" id="telefono-proveedor" name="telefono-proveedor" placeholder="Ej. 123456789" 
                               value="${proveedorSeleccionado.telefonoProveedor}" required />
                    </div>

                    <div class="form-group">
                        <label for="correo-proveedor"><strong>Correo Electrónico:</strong></label>
                        <input type="email" id="correo-proveedor" name="correo-proveedor" placeholder="Ej. proveedor@correo.com" 
                               value="${proveedorSeleccionado.correoProveedor}" required />
                    </div>

                    <div class="form-group">
                        <label for="direccion-proveedor"><strong>Dirección:</strong></label>
                        <input type="text" id="direccion-proveedor" name="direccion-proveedor" placeholder="Ej. Zona 1, Guatemala" 
                               value="${proveedorSeleccionado.direccionProveedor}" required />
                    </div>

                    <div class="crud-buttons">
                        <c:choose>
                            <c:when test="${proveedorSeleccionado != null}">
                                <!-- Solo mostrar Actualizar cuando hay un proveedor seleccionado -->
                                <button type="submit" name="accion" value="Actualizar" class="btn-crud">Actualizar</button>
                                <a href="Controlador?menu=Proveedores&accion=Listar" class="btn-crud">Cancelar</a>
                            </c:when>
                            <c:otherwise>
                                <!-- Solo mostrar Agregar cuando NO hay proveedor seleccionado -->
                                <button type="submit" name="accion" value="Agregar" class="btn-crud">Agregar</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </form>

                <div class="search-container">
                <form action="Controlador?menu=Proveedores" method="POST" class="search-form">
                    <div class="search-buttons">
                        <input type="text" name="id" class="input-search" placeholder="Buscar por ID..." />
                        <button type="submit" name="accion" value="Buscar" class="btn-crud">Buscar</button>
                        </div>
                    </form>
                </div>


                <div class="table-wrapper">
                    <table class="users-table">
                        <thead>
                            <tr>
                                <th>Código Proveedor</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Correo</th>
                                <th>Dirección</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody id="detalle-proveedor">
                            <c:forEach var="proveedor" items="${proveedores}">
                                <tr>
                                    <td>${proveedor.getCodigoProveedor()}</td>
                                    <td>${proveedor.getNombreProveedor()}</td>
                                    <td>${proveedor.getTelefonoProveedor()}</td>
                                    <td>${proveedor.getCorreoProveedor()}</td>
                                    <td>${proveedor.getDireccionProveedor()}</td>
                                    <td>                                       
                                        <a href="Controlador?menu=Proveedores&accion=Editar&codigoProveedor=${proveedor.getCodigoProveedor()}" class="btn-crud">Editar</a>                                            
                                        <a href="Controlador?menu=Proveedores&accion=Eliminar&codigoProveedor=${proveedor.getCodigoProveedor()}" class="btn-crud" 
                                           onclick=>Eliminar</a>                                            
                                    </td>
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
                            <li>Dirección: 71 Pennington Lane Vernon Rockville, CT 06066</li>
                            <li>Teléfono: 123-456-7890</li>
                            <li>Fax: 55555300</li>
                            <li>EmaiL: baristas@support.com</li>
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
                            <li><a href="cuenta-admin.jsp">Mi cuenta</a></li>
                            <li><a href="#">Historial de órdenes</a></li>
                            <li><a href="#">Lista de deseos</a></li>
                            <li><a href="#">Boletín</a></li>
                            <li><a href="#">Reembolsos</a></li>
                        </ul>
                    </div>

                    <div class="newsletter">
                        <p class="title-footer">Boletín informativo</p>
                        <div class="content">
                            <p>Suscríbete a nuestros boletines ahora y mantente al día con nuevas colecciones y ofertas exclusivas.</p>
                            <input type="email" placeholder="Ingresa el correo aquí...">
                            <button>Suscríbete</button>
                        </div>
                    </div>
                </div>

                <div class="copyright">
                    <p>Kinal Toy's &copy; 2025</p>
                    <img src="img/payment.png" alt="Pagos">
                </div>
            </div>
        </footer>

        <script>
            document.addEventListener('DOMContentLoaded', () => {
                // Lógica para scroll automático al formulario cuando se está editando
                const codigoProveedor = document.querySelector('input[name="codigoProveedor"]').value;
                if (codigoProveedor && codigoProveedor !== '') {
                    // Hacer scroll hacia el formulario
                    document.querySelector('.users-form').scrollIntoView({ 
                        behavior: 'smooth',
                        block: 'start'
                    });
                    
                    // Opcional: resaltar el formulario por un momento
                    const form = document.querySelector('.users-form');
                    form.style.border = '2px solid #007bff';
                    setTimeout(() => {
                        form.style.border = '';
                    }, 3000);
                }

                // Validación del formulario antes de enviar
                const form = document.querySelector('.users-form');
                form.addEventListener('submit', function(e) {
                    const accion = e.submitter.value;
                    const codigoProveedor = document.querySelector('input[name="codigoProveedor"]').value;

                    if (accion === 'Actualizar' && (!codigoProveedor || codigoProveedor === '')) {
                        e.preventDefault();
                        alert('Error: No hay ningún proveedor seleccionado para actualizar.');
                        return false;
                    }
                });
            });
        </script>
    </body>
</html>