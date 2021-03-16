insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into propietario(nombre, numero_identificacion, telefono, correo, direccion)
values('jonathan', '102574699', '3202918941', 'email@default.com', 'Calle 50');

insert into tarifa (avaluo_minimo, avaluo_maximo, tarifa, anio)
values (137325001, 158092000, 5.7, 2021);

insert into inmueble (numero_predial, codigo_postal, direccion, area_total, area_construida, avaluo_catastral, id_propietario)
values (14563687, 638974, 'Calle 50 No. 19-5 Br. Los Andres', 132, 125, 137325001, 1)