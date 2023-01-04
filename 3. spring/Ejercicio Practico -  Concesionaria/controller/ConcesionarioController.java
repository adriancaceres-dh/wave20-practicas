package com.bootcamp.prueba.controller;

import com.bootcamp.prueba.models.Auto;
import com.bootcamp.prueba.models.AutoDTO;
import com.bootcamp.prueba.services.IVehiculosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class ConcesionarioController {

    @Autowired
    IVehiculosServicio IVehiculosServicio;

    @PostMapping
    public boolean addAuto(@RequestBody Auto auto){
        return IVehiculosServicio.addAuto(auto);
    }

    @GetMapping
    public List<AutoDTO> getAutos(){
        return IVehiculosServicio.getAutos();
    }

    @GetMapping("dates")
    public List<Auto> getAutosEntreFechas(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                          @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return IVehiculosServicio.getAutosEntreFechas(since, to);
    }

    @GetMapping("prices")
    public List<Auto> getAutosEntrePrecios(@RequestParam Double since, @RequestParam Double to){
        return IVehiculosServicio.getAutosEntrePrecios(since, to);
    }

    @GetMapping("{id}")
    public Auto getAutoPorId(@PathVariable int id){
        return IVehiculosServicio.getCar(id);
    }
}
