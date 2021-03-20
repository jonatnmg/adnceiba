insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into propietario(nombre, numero_identificacion, telefono, correo, direccion)
values('jonathan', '102574699', '3202918941', 'email@default.com', 'Calle 50');

insert into tarifa (avaluo_minimo, avaluo_maximo, valor_tarifa, anio)
values (137325001, 158092000, 5.7, 2021);

insert into tarifa (avaluo_minimo, avaluo_maximo, valor_tarifa, anio)
values (137325001, 158092000, 5.7, 2020);

insert into inmueble (numero_predial, direccion, area_total, area_construida, avaluo_catastral, id_propietario)
values (14563687, 'Calle 50 No. 19-5 Br. Los Andres', 132, 125, 137325001, 1);

insert into inmueble (numero_predial, direccion, area_total, area_construida, avaluo_catastral, id_propietario)
values (14305499, 'Carrega 16 No. 9-15 Br. Los Laureles', 130, 0, 158092000, 1);

insert into pago (id_propietario, id_inmueble, id_tarifa, fecha_pago, anio, valor_pagado)
values (1, 1, 1 , '2021-03-16', 2021, 180000)

