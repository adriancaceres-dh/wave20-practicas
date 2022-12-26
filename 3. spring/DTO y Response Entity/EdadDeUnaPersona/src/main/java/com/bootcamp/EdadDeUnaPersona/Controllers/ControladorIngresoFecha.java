package com.bootcamp.EdadDeUnaPersona.Controllers;

import com.bootcamp.EdadDeUnaPersona.Servicies.IServicioCalculadorEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorIngresoFecha {
    @Autowired
    IServicioCalculadorEdad servicioCalcular;

    @GetMapping("/{dia}/{mes}/{ano}")
    public long calcularEdadPersona(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano) {
        return servicioCalcular.calcularEdadAPartirDeFecha(dia, mes, ano);
    }
}
