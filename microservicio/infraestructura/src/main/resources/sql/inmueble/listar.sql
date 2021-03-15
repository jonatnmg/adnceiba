select I.id, I.numero_predial, I.codigo_postal, I.direccion, I.area_total, I.area_construida, I.avaluo_catastral,
P.id as id_propietario, P.nombre, P.numero_identificacion, P.telefono, P.correo, P.direccion as direccion_propietario
from inmueble AS I
inner join propietario AS P on I.id_propietario = P.id