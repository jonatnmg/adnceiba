insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into propietario(nombre, numero_identificacion, telefono, correo, direccion)
values('jonathan', '102574699', '3202918941', 'email@default.com', 'Calle 50 No. 20 - 20 Br. Colombia');

insert into propietario(nombre, numero_identificacion, telefono, correo, direccion)
values('Juan Cortinez', '15996499', '3145203699', 'email@default.com', 'Diagonal 25 No. 15b-30 Br. Los pajaritos');

insert into propietario(nombre, numero_identificacion, telefono, correo, direccion)
values('Martha Gonzalez', '2796413', '320259461', 'email@default.com', 'Diagonal 25 No. 15b-30 Br. Los pajaritos');

insert into tarifa (avaluo_minimo, avaluo_maximo, valor_tarifa, anio)
values (0, 158092000, 5.7, 2021);

insert into tarifa (avaluo_minimo, avaluo_maximo, valor_tarifa, anio)
values (0, 158092000, 5.7, 2020);

insert into inmueble (numero_predial, direccion, area_total, area_construida, avaluo_catastral, id_propietario)
values (14563687, 'Calle 50 No. 19-5 Br. Los Andres', 132, 125, 137325001, 1);

insert into inmueble (numero_predial, direccion, area_total, area_construida, avaluo_catastral, id_propietario)
values (14305499, 'Carrera 16 No. 9-15 Br. Los Laureles', 130, 0, 137325001, 1);

insert into inmueble (numero_predial, direccion, area_total, area_construida, avaluo_catastral, id_propietario)
values (14989640, 'Carrega 6 No. 20-30 Br. Los Laureles', 120, 120, 158092000, 2);

insert into pago (id_propietario, id_inmueble, id_tarifa, fecha_pago, anio, valor_pagado)
values (1, 1, 1 , '2021-03-16', 2021, 180000)

