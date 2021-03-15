SELECT count(1) FROM pago
WHERE id_propietario = :idPropietario
AND id_inmueble = :idInmueble
AND anio = :anio