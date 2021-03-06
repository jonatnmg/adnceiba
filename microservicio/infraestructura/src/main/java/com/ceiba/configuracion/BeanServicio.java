package com.ceiba.configuracion;

import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.inmueble.servicio.ServicioActualizarInmueble;
import com.ceiba.inmueble.servicio.ServicioCrearInmueble;
import com.ceiba.inmueble.servicio.ServicioEliminarInmueble;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioActualizarPagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioEliminarPagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioPagarImpuestoPredial;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.servicio.ServicioActualizarPropietario;
import com.ceiba.propietario.servicio.ServicioCrearPropietario;
import com.ceiba.propietario.servicio.ServicioEliminarPropietario;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.servicio.ServicioActualizarTarifa;
import com.ceiba.tarifa.servicio.ServicioCrearTarifa;
import com.ceiba.tarifa.servicio.ServicioEliminarTarifa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPropietario servicioCrearPropietario(RepositorioPropietario repositorioPropietario) {
        return new ServicioCrearPropietario(repositorioPropietario);
    }

    @Bean
    public ServicioEliminarPropietario servicioEliminarPropietario(RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioEliminarPropietario(repositorioPropietario, repositorioInmueble, repositorioPagoImpuestoPredial);
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
    public ServicioEliminarTarifa servicioEliminarTarifa(RepositorioTarifa repositorioTarifa, RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioEliminarTarifa(repositorioTarifa, repositorioPagoImpuestoPredial);
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
    public ServicioEliminarInmueble servicioEliminarInmueble(RepositorioInmueble repositorioInmueble, RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioEliminarInmueble(repositorioInmueble, repositorioPagoImpuestoPredial);
    }

    @Bean
    public ServicioPagarImpuestoPredial servicioCrearPago(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioPagarImpuestoPredial(repositorioPagoImpuestoPredial);
    }

    @Bean
    public ServicioActualizarPagoImpuestoPredial servicioActualizarPagoImpuestoPredial(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioActualizarPagoImpuestoPredial(repositorioPagoImpuestoPredial);
    }

    @Bean
    public ServicioEliminarPagoImpuestoPredial servicioEliminarPagoImpuestoPredial(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        return new ServicioEliminarPagoImpuestoPredial(repositorioPagoImpuestoPredial);
    }
}
