update tarifa
set avaluo_minimo = :avaluoMinimo,
	avaluo_maximo = :avaluoMaximo,
	valor_tarifa = :valor,
	anio = :anio
where id = :id