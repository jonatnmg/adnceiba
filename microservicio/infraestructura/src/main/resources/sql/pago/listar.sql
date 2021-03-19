select PA.id, PA.fecha_pago, PA.anio, PA.valor_pagado,
P.id as id_propietario, P.nombre, P.numero_identificacion, P.telefono, P.correo, P.direccion as direccion_propietario,
I.id as id_inmueble, I.numero_predial, I.codigo_postal, I.direccion, I.area_total, I.area_construida, I.avaluo_catastral,
T.id as id_tarifa, T.avaluo_minimo, T.avaluo_maximo, T.valor_tarifa, T.anio_tarifa
from pago AS PA
inner join propietario AS P on PA.id_propietario = P.id
inner join inmueble AS I on PA.id_inmueble = I.id
inner join tarifa AS T on PA.id_tarifa = T.id
