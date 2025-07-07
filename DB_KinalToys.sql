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