<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1 class="users-title">Cuentas</h1>

                <form class="users-form" action="Controlador?menu=Cuentas" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="codigo-cuenta"><strong>Código de Cuenta:</strong></label>
                        <input type="text" id="codigo-cuenta" name="codigo-cuenta" placeholder="Autogenerado" readonly value="${cuentaSeleccionada.codigoCuenta}" />
                    </div>

                    <div class="form-group">
                        <label for="nombre-cuenta"><strong>Nombre de Cuenta:</strong></label>
                        <input type="text" id="nombre-cuenta" name="nombre-cuenta" placeholder="Ej. cuenta_admin" required value="${cuentaSeleccionada.nombreCuenta}" />
                    </div>

                    <div class="form-group">
                        <label for="correo-cuenta"><strong>Correo de Cuenta:</strong></label>
                        <input type="email" id="correo-cuenta" name="correo-cuenta" placeholder="ejemplo@correo.com" required value="${cuentaSeleccionada.correoCuenta}" />
                    </div>

                    <div class="form-group">
                        <label for="contrasena-cuenta"><strong>Contraseña:</strong></label>
                        <c:if test="${cuentaSeleccionada != null}">
                            <input type="password" id="contrasena-cuenta" name="contrasena-cuenta" 
                                   value="${cuentaSeleccionada.contrasenaCuenta}" readonly />
                        </c:if>
                        <c:if test="${cuentaSeleccionada == null}">
                            <input type="password" id="contrasena-cuenta" name="contrasena-cuenta" 
                                   placeholder="Ej. miClave123" required />
                        </c:if>
                    </div>

                    <div class="form-group">
                        <label for="rol-select"><strong>Rol de la cuenta:</strong></label>
                        <select id="rol-select" name="rol" required>
                            <option value="" disabled selected>Selecciona un rol</option>
                            <option value="Cliente" <c:if test="${cuentaSeleccionada.rol eq 'Cliente'}">selected</c:if>>Cliente</option>
                            <option value="Empleado" <c:if test="${cuentaSeleccionada.rol eq 'Empleado'}">selected</c:if>>Empleado</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="codigo-cliente"><strong>Código de Cliente:</strong></label>
                        <input type="number" id="codigo-cliente" name="codigo-cliente" placeholder="Solo para Clientes" value="${cuentaSeleccionada.codigoCliente}" />
                    </div>

                    <div class="form-group">
                        <label for="codigo-empleado"><strong>Código de Empleado:</strong></label>
                        <input type="number" id="codigo-empleado" name="codigo-empleado" placeholder="Solo para Empleados" value="${cuentaSeleccionada.codigoEmpleado}" />
                    </div>

                    <div class="form-group">
                        <label for="foto-cuenta"><strong>Foto de Cuenta: (Máximo de 3MB)</strong></label>
                        <input type="file" id="foto-cuenta" name="foto-cuenta" />
                    </div>

                    <div class="crud-buttons">
                        <button class="btn-crud" name="accion" value="Agregar">Agregar</button>
                        <button class="btn-crud" name="accion" value="Actualizar">Actualizar</button>
                    </div>
                </form>

                <div class="search-container">
                    <form class="search-form" action="Controlador" method="GET">
                        <input type="hidden" name="menu" value="Cuentas" />
                        <div class="search-buttons">
                            <button class="btn-crud" name="accion" value="Buscar">Buscar</button>
                            <input type="text" class="input-search" placeholder="Buscar por ID..." name="id" />
                        </div>
                    </form>
                </div>

                <div class="table-wrapper">
                    <table class="users-table">
                        <thead>
                            <tr>
                                <th>Código Cuenta</th>
                                <th>Rol</th>
                                <th>Nombre Cuenta</th>
                                <th>Correo</th>
                                <th>Foto</th>
                                <th>Código Cliente</th>
                                <th>Código Empleado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody id="detalle-cuenta">
                            <c:forEach var="cuenta" items="${cuentas}">
                                <tr>
                                    <td>${cuenta.codigoCuenta}</td>
                                    <td>${cuenta.rol}</td>
                                    <td>${cuenta.nombreCuenta}</td>
                                    <td>${cuenta.correoCuenta}</td>
                                    <td>
                                        <c:if test="${not empty cuenta.fotoCuenta}">
                                            <img src="CargarImagen?id=${cuenta.codigoCuenta}" alt="Foto de perfil" width="50" height="50"/>
                                        </c:if>
                                    </td>
                                    <td>${cuenta.codigoCliente}</td>
                                    <td>${cuenta.codigoEmpleado}</td>
                                    <td>
                                        <a href="Controlador?menu=Cuentas&accion=Cargar&id=${cuenta.codigoCuenta}" class="btn-crud">Editar</a>
                                        <a href="Controlador?menu=Cuentas&accion=Eliminar&id=${cuenta.codigoCuenta}" class="btn-crud">Eliminar</a>
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
            
            document.addEventListener('DOMContentLoaded', function() {
            const rolSelect = document.getElementById('rol-select');
            const codigoClienteInput = document.getElementById('codigo-cliente');
            const codigoEmpleadoInput = document.getElementById('codigo-empleado');

            function manejarCampos() {
                if (rolSelect.value === 'Cliente') {
                    codigoClienteInput.disabled = false;
                    codigoEmpleadoInput.value = '';
                    codigoEmpleadoInput.disabled = true;
                } else if (rolSelect.value === 'Empleado') {
                    codigoEmpleadoInput.disabled = false;
                    codigoClienteInput.value = '';
                    codigoClienteInput.disabled = true;
                } else {
                    codigoClienteInput.disabled = false;
                    codigoEmpleadoInput.disabled = false;
                }
            }

            rolSelect.addEventListener('change', manejarCampos);
        </script>

    </body>
</html>