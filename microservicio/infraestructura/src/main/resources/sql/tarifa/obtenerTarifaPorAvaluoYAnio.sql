select tarifa as valor
from tarifa
where :avaluoCatastral BETWEEN avaluo_minimo AND avaluo_maximo
and anio = :anio