create database DB_KinalToys;
use DB_KinalToys;

create table Usuarios (
	codigoUsuario int,
	nombreUsuario varchar(50),
	apellidoUsuario varchar(60),
	direccionUsuario varchar(100),
	telefonoUsuario varchar(9),
	primary key PK_codigoUsuario (codigoUsuario)
);

create table Facturas (
	codigoFactura int,
	fechaEmision datetime,
    metodo_pago enum('Efectivo', 'Credito'),
    total decimal(10,2),
	codigoUsuario int,
	primary key PK_codigoFactura (codigoFactura),
	constraint FK_Factura_Usuario foreign key (codigoUsuario)
		references Usuarios (codigoUsuario)
);

create table Noticias (
	codigoNoticia int,
    encabezado varchar(100),
    informacion varchar(250),
    categoria varchar(50),
    fechaNoticia datetime,
    primary key PK_codigoNoticia (codigoNoticia)
);

create table Proveedores (
	codigoProveedor int,
    nombreProveedor varchar(50),
    telefonoProveedor varchar(9),
    correoProveedor varchar(100),
    direccionProveedor varchar(125),
    primary key PK_codigoProveedor (codigoProveedor)
);

create table Juguetes (
	codigoJuguete int,
	nombreJuguete varchar(50),
    precio decimal(10,2),
    categoria varchar(50),
    marca varchar(50),
    stock int,
	codigoNoticia int,
    primary key PK_codigoJuguete (codigoJuguete),
	constraint FK_Juguete_Noticia foreign key (codigoNoticia)
		references Noticias (codigoNoticia)
);

create table Compras (
	codigoCompra int,
    fechaCompra datetime,
    cantidad int,
    precioUnitario decimal(10,2),
    codigoJuguete int,
    codigoProveedor int,
    primary key PK_codigoCompra (codigoCompra),
    constraint FK_Compra_Juguete foreign key (codigoJuguete) 
		references Juguetes (codigoJuguete),
	constraint FK_Compra_Proveedor foreign key (codigoProveedor) 
		references Proveedores (codigoProveedor)
);

create table Carritos (
	codigoCarrito int,
    fecha_creacion datetime,
    estado enum('Activo', 'Comprado'),
	total decimal(10,2),
    codigoUsuario int,
    primary key PK_codigoCarrito (codigoCarrito),
	constraint FK_Carrito_Usuario foreign key (codigoUsuario) 
		references Usuarios (codigoUsuario)
);


create table DetallesCarritos (
	codigoDetalleC int,
    cantidad int,
	subTotal decimal(10,2),
    descuentoAplicado decimal(10,2),
    codigoCarrito int,
    codigoJuguete int,
    primary key PK_codigoDetalleC (codigoDetalleC),
    constraint FK_DetalleC_Carrito foreign key (codigoCarrito) 
		references Carritos (codigoCarrito),
	constraint FK_DetalleC_Juguete foreign key (codigoJuguete) 
		references Juguetes (codigoJuguete)
);

-- PROCEDIMIENTOS ALMACENADOS (USUARIOS) -------------------------
-- AGREGAR USUARIO
Delimiter $$
create procedure sp_AgregarUsuario (
	in nombre varchar(50),
	in apellido varchar(60),
	in direccion varchar(100),
	in telefono varchar(9))
begin
	insert into Usuarios (nombreUsuario, apellidoUsuario, direccionUsuario, telefonoUsuario)
	values (nombre, apellido, direccion, telefono);
end$$
Delimiter ;
call sp_AgregarUsuario('Carlos', 'Mejía', 'Zona 10, Guatemala', '45981230');
call sp_AgregarUsuario('Andrea', 'Gómez', 'Zona 5, Guatemala', '55678921');

-- LISTAR USUARIOS
Delimiter $$
create procedure sp_ListarUsuarios ()
begin
	select * from Usuarios;
end$$
Delimiter ;
call sp_ListarUsuarios();

-- ELIMINAR USUARIO
Delimiter $$
create procedure sp_EliminarUsuario (
	in codUsuario int)
begin
	delete from Usuarios where codigoUsuario = codUsuario;
end$$
Delimiter ;
call sp_EliminarUsuario(2);

-- BUSCAR USUARIO
Delimiter $$
create procedure sp_BuscarUsuario (
	in codUsuario int)
begin
	select * from Usuarios where codigoUsuario = codUsuario;
end$$
Delimiter ;
call sp_BuscarUsuario(1);

-- EDITAR USUARIO
Delimiter $$
create procedure sp_EditarUsuario (
	in codUsuario int,
	in nombre varchar(50),
	in apellido varchar(60),
	in direccion varchar(100),
	in telefono varchar(9))
begin
	update Usuarios set nombreUsuario = nombre, apellidoUsuario = apellido,
		direccionUsuario = direccion, telefonoUsuario = telefono
			where codigoUsuario = codUsuario;
end$$
Delimiter ;
call sp_EditarUsuario(1, 'Carlos', 'Mejía', 'Zona 14, Guatemala', '12345678');

-- PROCEDIMIENTOS ALMACENADOS (FACTURAS) -------------------------
-- AGREGAR FACTURA
Delimiter $$
create procedure sp_AgregarFactura (
	in fecha datetime,
	in metodo enum('Efectivo', 'Credito'),
	in totalFactura decimal(10,2),
	in codUsuario int)
begin
	insert into Facturas (fechaEmision, metodo_pago, total, codigoUsuario)
	values (fecha, metodo, totalFactura, codUsuario);
end$$
Delimiter ;
call sp_AgregarFactura('2023-06-15 11:30:00', 'Efectivo', 250.75, 1);
call sp_AgregarFactura('2023-06-16 09:15:00', 'Credito', 450.00, 1);
 
-- LISTAR FACTURAS
Delimiter $$
create procedure sp_ListarFacturas ()
begin
	select * from Facturas;
end$$
Delimiter ;
call sp_ListarFacturas();
 
-- ELIMINAR FACTURA
Delimiter $$
create procedure sp_EliminarFactura (
	in codFactura int)
begin
	delete from Facturas where codigoFactura = codFactura;
end$$
Delimiter ;
call sp_EliminarFactura(2);
 
-- BUSCAR FACTURA
Delimiter $$
create procedure sp_BuscarFactura (
	in codFactura int)
begin
	select * from Facturas where codigoFactura = codFactura;
end$$
Delimiter ;
call sp_BuscarFactura(1);
 
-- EDITAR FACTURA
Delimiter $$
create procedure sp_EditarFactura (
	in codFactura int,
	in fecha datetime,
	in metodo enum('Efectivo', 'Credito'),
	in totalFactura decimal(10,2),
	in codUsuario int)
begin
	update Facturas set fechaEmision = fecha, metodo_pago = metodo,
		total = totalFactura, codigoUsuario = codUsuario
	where codigoFactura = codFactura;
end$$
Delimiter ;
call sp_EditarFactura(1, '2023-06-15 12:00:00', 'Credito', 275.00, 1);

-- PROCEDIMIENTOS ALMACENADOS (NOTICIAS) -------------------------
-- AGREGAR NOTICIA
Delimiter $$
create procedure sp_AgregarNoticia (
	in encabezadoNot varchar(100),
	in info varchar(250),
	in categoriaNot varchar(50),
	in fecha datetime)
begin
	insert into Noticias (encabezado, informacion, categoria, fechaNoticia)
	values (encabezadoNot, info, categoriaNot, fecha);
end$$
Delimiter ;
call sp_AgregarNoticia('Nueva colección de juguetes', 'La nueva colección incluye figuras exclusivas.', 'Novedades', '2023-06-01 08:00:00');
call sp_AgregarNoticia('Descuentos especiales', 'Aprovecha los descuentos del 20% en compras mayores a Q500.', 'Promoción', '2023-06-02 09:30:00');
 
-- LISTAR NOTICIAS
Delimiter $$
create procedure sp_ListarNoticias ()
begin
	select * from Noticias;
end$$
Delimiter ;
call sp_ListarNoticias();
 
-- ELIMINAR NOTICIA
Delimiter $$
create procedure sp_EliminarNoticia (
	in codNoticia int)
begin
	delete from Noticias where codigoNoticia = codNoticia;
end$$
Delimiter ;
call sp_EliminarNoticia(2);
 
-- BUSCAR NOTICIA
Delimiter $$
create procedure sp_BuscarNoticia (
	in codNoticia int)
begin
	select * from Noticias where codigoNoticia = codNoticia;
end$$
Delimiter ;
call sp_BuscarNoticia(1);
 
-- EDITAR NOTICIA
Delimiter $$
create procedure sp_EditarNoticia (
	in codNoticia int,
	in encabezadoNot varchar(100),
	in info varchar(250),
	in categoriaNot varchar(50),
	in fecha datetime)
begin
	update Noticias set encabezado = encabezadoNot, informacion = info,
		categoria = categoriaNot, fechaNoticia = fecha
	where codigoNoticia = codNoticia;
end$$
Delimiter ;
call sp_EditarNoticia(1, 'Colección actualizada', 'Ahora con más figuras disponibles.', 'Novedades', '2023-06-03 10:00:00');

-- PROCEDIMIENTOS ALMACENADOS (PROVEEDORES) -------------------------
-- AGREGAR PROVEEDOR
Delimiter $$
create procedure sp_AgregarProveedor (
	in nombreProv varchar(50),
	in telefonoProv varchar(9),
	in correoProv varchar(100),
	in direccionProv varchar(125))
begin
	insert into Proveedores (nombreProveedor, telefonoProveedor, correoProveedor, direccionProveedor)
	values (nombreProv, telefonoProv, correoProv, direccionProv);
end$$
Delimiter ;
call sp_AgregarProveedor('Distribuciones GT', '78451230', 'contacto@gt.com', 'Zona 1, Guatemala');
call sp_AgregarProveedor('Juguetón', '45678912', 'ventas@jugueton.com', 'Zona 12, Guatemala');
 
-- LISTAR PROVEEDORES
Delimiter $$
create procedure sp_ListarProveedores ()
begin
	select * from Proveedores;
end$$
Delimiter ;
call sp_ListarProveedores();
 
-- ELIMINAR PROVEEDOR
Delimiter $$
create procedure sp_EliminarProveedor (
	in codProveedor int)
begin
	delete from Proveedores where codigoProveedor = codProveedor;
end$$
Delimiter ;
call sp_EliminarProveedor(2);
 
-- BUSCAR PROVEEDOR
Delimiter $$
create procedure sp_BuscarProveedor (
	in codProveedor int)
begin
	select * from Proveedores where codigoProveedor = codProveedor;
end$$
Delimiter ;
call sp_BuscarProveedor(1);
 
-- EDITAR PROVEEDOR
Delimiter $$
create procedure sp_EditarProveedor (
	in codProveedor int,
	in nombreProv varchar(50),
	in telefonoProv varchar(9),
	in correoProv varchar(100),
	in direccionProv varchar(125))
begin
	update Proveedores set nombreProveedor = nombreProv,
		telefonoProveedor = telefonoProv, correoProveedor = correoProv,
		direccionProveedor = direccionProv
	where codigoProveedor = codProveedor;
end$$
Delimiter ;
call sp_EditarProveedor(1, 'Distribuciones GT', '12345678', 'nuevo@gt.com', 'Zona 10, Guatemala');

-- PROCEDIMIENTOS ALMACENADOS (JUGUETES) -------------------------
-- AGREGAR JUGUETE
Delimiter $$
create procedure sp_AgregarJuguete (
	in nombreJuguete varchar(50),
	in precioJuguete decimal(10,2),
	in categoriaJuguete varchar(50),
	in marcaJuguete varchar(50),
	in stockJuguete int,
	in codNoticia int)
begin
	insert into Juguetes (nombreJuguete, precio, categoria, marca, stock, codigoNoticia)
	values (nombreJuguete, precioJuguete, categoriaJuguete, marcaJuguete, stockJuguete, codNoticia);
end$$
Delimiter ;
call sp_AgregarJuguete('Batman', 150.00, 'Figuras', 'DC', 20, 1);
call sp_AgregarJuguete('Buzz Lightyear', 180.00, 'Figuras', 'Pixar', 15, 1);
 
-- LISTAR JUGUETES
Delimiter $$
create procedure sp_ListarJuguetes ()
begin
	select * from Juguetes;
end$$
Delimiter ;
call sp_ListarJuguetes();
 
-- ELIMINAR JUGUETE
Delimiter $$
create procedure sp_EliminarJuguete (
	in codJuguete int)
begin
	delete from Juguetes where codigoJuguete = codJuguete;
end$$
Delimiter ;
call sp_EliminarJuguete(2);
 
-- BUSCAR JUGUETE
Delimiter $$
create procedure sp_BuscarJuguete (
	in codJuguete int)
begin
	select * from Juguetes where codigoJuguete = codJuguete;
end$$
Delimiter ;
call sp_BuscarJuguete(1);
 
-- EDITAR JUGUETE
Delimiter $$
create procedure sp_EditarJuguete (
	in codJuguete int,
	in nombreJuguete varchar(50),
	in precioJuguete decimal(10,2),
	in categoriaJuguete varchar(50),
	in marcaJuguete varchar(50),
	in stockJuguete int,
	in codNoticia int)
begin
	update Juguetes set nombreJuguete = nombreJuguete, precio = precioJuguete,
		categoria = categoriaJuguete, marca = marcaJuguete, stock = stockJuguete,
		codigoNoticia = codNoticia
	where codigoJuguete = codJuguete;
end$$
Delimiter ;
call sp_EditarJuguete(1, 'Batman Deluxe', 160.00, 'Figuras', 'DC Comics', 25, 1);

-- PROCEDIMIENTOS ALMACENADOS (COMPRAS) -------------------------
-- AGREGAR COMPRA
Delimiter $$
create procedure sp_AgregarCompra (
	in fecha datetime,
	in cantidadCompra int,
	in precioUnit decimal(10,2),
	in codJuguete int,
	in codProveedor int)
begin
	insert into Compras (fechaCompra, cantidad, precioUnitario, codigoJuguete, codigoProveedor)
	values (fecha, cantidadCompra, precioUnit, codJuguete, codProveedor);
end$$
Delimiter ;
call sp_AgregarCompra('2023-06-10 10:00:00', 30, 75.00, 1, 1);
call sp_AgregarCompra('2023-06-11 14:30:00', 20, 90.00, 1, 1);

-- LISTAR COMPRAS
Delimiter $$
create procedure sp_ListarCompras ()
begin
	select * from Compras;
end$$
Delimiter ;
call sp_ListarCompras();

-- ELIMINAR COMPRA
Delimiter $$
create procedure sp_EliminarCompra (
	in codCompra int)
begin
	delete from Compras where codigoCompra = codCompra;
end$$
Delimiter ;
call sp_EliminarCompra(2);

-- BUSCAR COMPRA
Delimiter $$
create procedure sp_BuscarCompra (
	in codCompra int)
begin
	select * from Compras where codigoCompra = codCompra;
end$$
Delimiter ;
call sp_BuscarCompra(1);

-- EDITAR COMPRA
Delimiter $$
create procedure sp_EditarCompra (
	in codCompra int,
	in fecha datetime,
	in cantidadCompra int,
	in precioUnit decimal(10,2),
	in codJuguete int,
	in codProveedor int)
begin
	update Compras set fechaCompra = fecha, cantidad = cantidadCompra,
		precioUnitario = precioUnit, codigoJuguete = codJuguete,
		codigoProveedor = codProveedor
	where codigoCompra = codCompra;
end$$
Delimiter ;
call sp_EditarCompra(1, '2023-06-10 11:00:00', 40, 72, 1, 1);


-- PROCEDIMIENTOS ALMACENADOS (CARRITOS) -------------------------
-- AGREGAR CARRITO
Delimiter $$
create procedure sp_AgregarCarrito (
	in fecha datetime,
	in estadoCarrito enum('Activo', 'Comprado'),
	in totalCarrito decimal(10,2),
	in codUsuario int)
begin
	insert into Carritos (fecha_creacion, estado, total, codigoUsuario)
	values (fecha, estadoCarrito, totalCarrito, codUsuario);
end$$
Delimiter ;
call sp_AgregarCarrito('2023-06-20 09:00:00', 'Activo', 300.00, 1);
call sp_AgregarCarrito('2023-06-21 10:30:00', 'Comprado', 450.00, 1);
 
-- LISTAR CARRITOS
Delimiter $$
create procedure sp_ListarCarritos ()
begin
	select * from Carritos;
end$$
Delimiter ;
call sp_ListarCarritos();

-- ELIMINAR CARRITO
Delimiter $$
create procedure sp_EliminarCarrito (
	in codCarrito int)
begin
	delete from Carritos where codigoCarrito = codCarrito;
end$$
Delimiter ;
call sp_EliminarCarrito(2);
 
-- BUSCAR CARRITO
Delimiter $$
create procedure sp_BuscarCarrito (
	in codCarrito int)
begin
	select * from Carritos where codigoCarrito = codCarrito;
end$$
Delimiter ;
call sp_BuscarCarrito(1);
 
-- EDITAR CARRITO
Delimiter $$
create procedure sp_EditarCarrito (
	in codCarrito int,
	in fecha datetime,
	in estadoCarrito enum('Activo', 'Comprado'),
	in totalCarrito decimal(10,2),
	in codUsuario int)
begin
	update Carritos set fecha_creacion = fecha,
		estado = estadoCarrito, total = totalCarrito,
		codigoUsuario = codUsuario
	where codigoCarrito = codCarrito;
end$$
Delimiter ;
call sp_EditarCarrito(1, '2023-06-20 09:30:00', 'Comprado', 320.00, 1);