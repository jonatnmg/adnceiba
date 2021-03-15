SELECT count(1) FROM inmueble
WHERE id <> :id
AND (
    numero_predial = :numeroPredial
    OR
    direccion = :direccion
    )