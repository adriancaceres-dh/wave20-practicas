package com.bootcamp.Blog.controller;

import com.bootcamp.Blog.dto.EntradaBlogRequestDTO;
import com.bootcamp.Blog.dto.EntradaBlogResponseDTO;
import com.bootcamp.Blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BlogController {
    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogRequestDTO> crearBlog (@RequestBody EntradaBlogRequestDTO dto){
        return new ResponseEntity<>(entradaBlogService.crearBlog(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = {"/blogs", "/blogs/{id}"})
    public ResponseEntity<List<EntradaBlogResponseDTO>> buscarBlog(@PathVariable(required = false) Long id){
        return new ResponseEntity<>(entradaBlogService.buscarBlog(id), HttpStatus.OK);
    }
}
