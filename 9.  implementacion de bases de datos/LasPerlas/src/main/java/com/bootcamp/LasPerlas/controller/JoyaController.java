package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @PostMapping ("/jewerly/new")
    public String saveJoya (@RequestBody Joya joya) {
        return joyaServ.saveJoya(joya);
    }

    @GetMapping ("/jewerly")
    public List<Joya> getJoyas () {

        return joyaServ.getJoyas();
    }

    @PutMapping ("/jewerly/delete/{id}")
    public String deleteJoya (@PathVariable Long id) {

        return joyaServ.deleteJoya(id);
    }

    @PutMapping ("/v/update/{id_modificar}")
    public String editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {

        return joyaServ.editJoya(id_modificar, joya);
    }


}
