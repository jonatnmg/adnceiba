select id, nombre, numero_identificacion, telefono, correo, direccion
from propietario
where numero_identificacion = :numeroIdentificacion
LIMIT 1;