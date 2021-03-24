SELECT (null) as id, (0) as valor_pagado, (null) as fecha_pago ,TARIFA.id as id_tarifa, TARIFA.avaluo_minimo, TARIFA.avaluo_maximo, TARIFA.anio AS anio_tarifa, TARIFA.anio, TARIFA.valor_tarifa,
INMUEBLE.id AS id_inmueble, INMUEBLE.numero_predial, INMUEBLE.direccion as direccion,
INMUEBLE.area_total, INMUEBLE.area_construida, INMUEBLE.avaluo_catastral,
PROPIETARIO.id as id_propietario, PROPIETARIO.nombre, PROPIETARIO.numero_identificacion, PROPIETARIO.telefono,
PROPIETARIO.correo, PROPIETARIO.direccion as direccion_propietario
FROM pruebaceiba.tarifa AS TARIFA
left join pruebaceiba.inmueble as INMUEBLE on INMUEBLE.numero_predial = :numeroPredial
left join pruebaceiba.propietario as PROPIETARIO ON INMUEBLE.id_propietario = PROPIETARIO.id
where INMUEBLE.avaluo_catastral between TARIFA.avaluo_minimo and TARIFA.avaluo_maximo
and TARIFA.anio not in (SELECT PAGO.anio FROM pruebaceiba.pago AS PAGO
where PAGO.id_inmueble = INMUEBLE.id);