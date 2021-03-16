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

CREATE TABLE inmueble (
  id int(11) NOT NULL AUTO_INCREMENT,
  numero_predial bigint(11) DEFAULT NULL,
  codigo_postal int(11) DEFAULT NULL,
  direccion varchar(50) DEFAULT NULL,
  area_total int(11) DEFAULT NULL,
  area_construida int(11) DEFAULT NULL,
  avaluo_catastral bigint(11) DEFAULT NULL,
  id_propietario int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_I_PROPIETARIO_idx (id_propietario),
  CONSTRAINT FK_I_PROPIETARIO FOREIGN KEY (id_propietario) REFERENCES propietario (id) ON UPDATE NO ACTION
);

