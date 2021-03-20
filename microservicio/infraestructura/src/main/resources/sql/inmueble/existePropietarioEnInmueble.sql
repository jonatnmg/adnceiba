SELECT count(1) FROM inmueble
WHERE id_propietario = :idPropietario
LIMIT 1;