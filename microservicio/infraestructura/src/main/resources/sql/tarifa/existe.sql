select count(1) from tarifa
where anio = :anio
AND (
    :avaluoMinimo BETWEEN avaluo_minimo AND avaluo_maximo
    OR
    :avaluoMaximo BETWEEN avaluo_minimo AND avaluo_maximo
    )