update propietario
set nombre = :nombre,
	numero_identificacion = :numeroIdentificacion,
	telefono = :telefono,
	correo = :correo,
	direccion = :direccion
where id = :id