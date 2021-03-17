create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE propietario (
  id int(11) not null auto_increment,
  nombre varchar(45) not null,
  numero_identificacion varchar(45) not null,
  telefono varchar(45) not null,
  correo varchar(45) not null,
  direccion varchar(45) not null,
  PRIMARY KEY (id)
);

CREATE TABLE tarifa (
  id int(11) NOT NULL AUTO_INCREMENT,
  avaluo_minimo bigint(11) not null,
  avaluo_maximo bigint(11) not null,
  tarifa decimal(10,3) not null,
  anio int(11) not null,
  PRIMARY KEY (id)
);

CREATE TABLE inmueble (
  id int(11) NOT NULL AUTO_INCREMENT,
  numero_predial bigint(11) not null,
  codigo_postal int(11) not null,
  direccion varchar(50) not null,
  area_total int(11) not null,
  area_construida int(11) not null,
  avaluo_catastral bigint(11) not null,
  id_propietario int(11) not null,
  PRIMARY KEY (id),
  foreign key (id_propietario) REFERENCES propietario(id)
);

CREATE TABLE pago (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_propietario int(11) DEFAULT NULL,
  id_inmueble int(11) DEFAULT NULL,
  fecha_pago date DEFAULT NULL,
  anio int(11) DEFAULT NULL,
  valor_pagado bigint(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_P_PROPIETARIO_idx (id_propietario),
  KEY FK_P_INMUEBLE_idx (id_inmueble),
  CONSTRAINT FK_P_INMUEBLE FOREIGN KEY (id_inmueble) REFERENCES inmueble (id) ON UPDATE NO ACTION,
  CONSTRAINT FK_P_PROPIETARIO FOREIGN KEY (id_propietario) REFERENCES propietario (id) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;




