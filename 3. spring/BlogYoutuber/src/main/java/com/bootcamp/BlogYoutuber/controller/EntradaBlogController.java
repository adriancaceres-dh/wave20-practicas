package com.bootcamp.BlogYoutuber.controller;

import com.bootcamp.BlogYoutuber.dto.EntradaBlogDTO;
import com.bootcamp.BlogYoutuber.exceptions.InsertBlogException;
import com.bootcamp.BlogYoutuber.exceptions.NotFoundBlogException;
import com.bootcamp.BlogYoutuber.model.EntradaBlog;
import com.bootcamp.BlogYoutuber.services.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntradaBlogController {
    @Autowired
    EntradaBlogService entradaBlogService;

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDTO>> getAllBlogs(){
        return new ResponseEntity<List<EntradaBlogDTO>>(entradaBlogService.getAllBlogs(), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<String> publicarBlog(@RequestBody EntradaBlogDTO blog){
        if(entradaBlogService.addBlog(blog)){
            return ResponseEntity.status(201).body("Blog creado con exito");
        }else{
            throw new InsertBlogException("El blog ya existe");
        }

    }
    @GetMapping("/blog/{id}")
    public Optional<EntradaBlog> getBlogId(@PathVariable int id){
        if(entradaBlogService.getBlogById(id).isEmpty()){
            throw new NotFoundBlogException("El blog no se encuentra");
        }else{
            return entradaBlogService.getBlogById(id);
        }
    }
}
