create database DB_KinalToys;
use DB_KinalToys;

create table Usuarios (
	codigoUsuario int,
	nombreUsuario varchar(50),
	apellidoUsuario varchar(60),
	direccionUsuario varchar(100),
	telefonoProveedor varchar(9),
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