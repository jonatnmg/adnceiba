select count(1) from tarifa
where id <> :id
AND anio = :anio
AND (
    :avaluoMinimo BETWEEN avaluo_minimo AND avaluo_maximo
    OR
    :avaluoMaximo BETWEEN avaluo_minimo AND avaluo_maximo
    )