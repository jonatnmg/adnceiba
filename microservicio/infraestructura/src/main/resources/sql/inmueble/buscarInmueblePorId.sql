select id, numero_predial, direccion, area_total, area_construida, avaluo_catastral, id_propietario
from inmueble
where id = :id