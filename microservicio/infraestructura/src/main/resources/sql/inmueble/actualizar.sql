update inmueble
set numero_predial = :numeroPredial,
	codigo_postal = :codigoPostal,
	direccion = :direccion,
	area_total = :areaTotal,
	area_construida = :areaConstruida,
	avaluo_catastral = :avaluoCatastral,
	id_propietario = :idPropietario
where id = :id