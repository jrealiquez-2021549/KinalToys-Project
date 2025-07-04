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