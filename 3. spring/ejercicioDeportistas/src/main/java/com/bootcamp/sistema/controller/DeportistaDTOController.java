package com.bootcamp.sistema.controller;

import com.bootcamp.sistema.dto.DeportistaDTO;
import com.bootcamp.sistema.service.DeportistaDTOService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeportistaDTOController {

    DeportistaDTOService deportistaDTOService = new DeportistaDTOService();

    /*public DeportistaDTOController() {
       deportistaDTOService = new DeportistaDTOService();
    }*/

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> devolverDeportistas(){
        return deportistaDTOService.getDeportistas();
    }

}
