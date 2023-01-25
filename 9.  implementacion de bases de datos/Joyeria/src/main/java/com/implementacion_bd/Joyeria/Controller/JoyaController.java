package com.implementacion_bd.Joyeria.Controller;

import com.implementacion_bd.Joyeria.Entities.Joya;
import com.implementacion_bd.Joyeria.Service.ICRUDService;
import com.implementacion_bd.Joyeria.Service.JoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jewerly")
public class JoyaController {
    @Autowired
    JoyeriaService service;

    @PostMapping("/new")
    public Joya postJoya(@RequestBody Joya joya){
        return service.create(joya);
    }

    @GetMapping("/id/{id}")
    public Joya getJoyaById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping()
    public List<Joya> getAllJoyas(){
        return service.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void deleteJoya(@PathVariable Integer id){
        service.delete(id);
    }
}
