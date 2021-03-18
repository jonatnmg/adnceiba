package com.ceiba.configuracion;

import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.inmueble.servicio.ServicioActualizarInmueble;
import com.ceiba.inmueble.servicio.ServicioCrearInmueble;
import com.ceiba.inmueble.servicio.ServicioEliminarInmueble;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioPagoInmpuestoPredial;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.servicio.ServicioActualizarPropietario;
import com.ceiba.propietario.servicio.ServicioCrearPropietario;
import com.ceiba.propietario.servicio.ServicioEliminarPropietario;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.servicio.ServicioActualizarTarifa;
import com.ceiba.tarifa.servicio.ServicioCrearTarifa;
import com.ceiba.tarifa.servicio.ServicioEliminarTarifa;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearPropietario servicioCrearPropietario(RepositorioPropietario repositorioPropietario) {
        return new ServicioCrearPropietario(repositorioPropietario);
    }

    @Bean
    public ServicioEliminarPropietario servicioEliminarPropietario(RepositorioPropietario repositorioPropietario) {
        return new ServicioEliminarPropietario(repositorioPropietario);
    }

    @Bean
    public ServicioActualizarPropietario servicioActualizarPropietario(RepositorioPropietario repositorioPropietario) {
        return new ServicioActualizarPropietario(repositorioPropietario);
    }

    @Bean
    public ServicioCrearTarifa servicioCrearTarifa(RepositorioTarifa repositorioTarifa) {
        return new ServicioCrearTarifa(repositorioTarifa);
    }

    @Bean
    public ServicioActualizarTarifa servicioActualizarTarifa(RepositorioTarifa repositorioTarifa) {
        return new ServicioActualizarTarifa(repositorioTarifa);
    }

    @Bean
    public ServicioEliminarTarifa servicioEliminarTarifa(RepositorioTarifa repositorioTarifa) {
        return new ServicioEliminarTarifa(repositorioTarifa);
    }

    @Bean
    public ServicioCrearInmueble servicioCrearInmueble(RepositorioInmueble repositorioInmueble) {
        return new ServicioCrearInmueble(repositorioInmueble);
    }

    @Bean
    public ServicioActualizarInmueble servicioActualizarInmueble(RepositorioInmueble repositorioInmueble) {
        return new ServicioActualizarInmueble(repositorioInmueble);
    }

    @Bean
    public ServicioEliminarInmueble servicioEliminarInmueble(RepositorioInmueble repositorioInmueble) {
        return new ServicioEliminarInmueble(repositorioInmueble);
    }

    @Bean
    public ServicioPagoInmpuestoPredial servicioCrearPago(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioPagoInmpuestoPredial(repositorioPagoImpuestoPredial);
    }
}
