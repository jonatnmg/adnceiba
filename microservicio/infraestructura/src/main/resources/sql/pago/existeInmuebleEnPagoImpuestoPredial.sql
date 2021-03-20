SELECT count(1) FROM pago
WHERE id_inmueble = :idInmueble
LIMIT 1;