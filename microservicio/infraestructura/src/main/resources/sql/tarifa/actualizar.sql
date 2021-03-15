update tarifa
set avaluo_minimo = :avaluoMinimo,
	avaluo_maximo = :avaluoMaximo,
	tarifa = :tarifa,
	anio = :anio
where id = :id