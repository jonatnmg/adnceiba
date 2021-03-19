update pago
set id_propietario = :idPropietario,
    id_inmueble = :idInmueble,
    id_tarifa = :idTarifa,
    fecha_pago = :fechaPago,
    anio =  :anio,
    valor_pagado = :valorPagado
where id = :id