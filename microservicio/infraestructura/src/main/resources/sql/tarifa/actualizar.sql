update tarifa
set avaluo_minimo = :avaluoMinimo,
	avaluo_maximo = :avaluoMaximo,
	tarifa = :valor,
	anio = :anio
where id = :id