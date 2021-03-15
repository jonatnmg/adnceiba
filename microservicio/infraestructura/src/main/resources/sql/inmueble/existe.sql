SELECT count(1) FROM inmueble
WHERE numero_predial = :numeroPredial
OR direccion = :direccion