package com.bootcamp.Blog.Controllers;

import com.bootcamp.Blog.DTO.EntradaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @PostMapping("/blog")
    public ResponseEntity<String> crearEntradaBlog(@RequestBody EntradaDto nuevaEntrada){
        // La fecha de publicación será el día en el cual se recibe el request.
        return new ResponseEntity<String>();
    }
}
