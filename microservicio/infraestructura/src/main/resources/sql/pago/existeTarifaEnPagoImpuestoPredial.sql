SELECT count(1) FROM pago
WHERE id_tarifa = :idTarifa
LIMIT 1;