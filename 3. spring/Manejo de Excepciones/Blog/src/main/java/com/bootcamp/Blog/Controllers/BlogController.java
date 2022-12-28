package com.bootcamp.Blog.Controllers;

import com.bootcamp.Blog.DTO.EntradaDto;
import com.bootcamp.Blog.DTO.MensajeDto;
import com.bootcamp.Blog.Services.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    IEntradaBlogService servicio;

    @PostMapping("/blog")
    public ResponseEntity<MensajeDto> crearEntradaBlog(@RequestBody EntradaDto nuevaEntrada) {
        // La fecha de publicación será el día en el cual se recibe el request.
        return new ResponseEntity<>(servicio.crearEntradaBlog(nuevaEntrada), HttpStatus.OK);
    }
}
