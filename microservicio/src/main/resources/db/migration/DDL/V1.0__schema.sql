create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE propietario (
  id int(11) not null auto_increment,
  nombre varchar(45) DEFAULT NULL,
  numero_identificacion varchar(45) DEFAULT NULL,
  telefono varchar(45) DEFAULT NULL,
  correo varchar(45) DEFAULT NULL,
  direccion varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE tarifa (
  id int(11) NOT NULL AUTO_INCREMENT,
  avaluo_minimo bigint(11) DEFAULT NULL,
  avaluo_maximo bigint(11) DEFAULT NULL,
  tarifa decimal(10,3) DEFAULT NULL,
  anio int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);

