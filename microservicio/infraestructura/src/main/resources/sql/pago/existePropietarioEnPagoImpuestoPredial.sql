SELECT count(1) FROM pago
WHERE id_propietario = :idPropietario
LIMIT 1;