package com.bootcamp._excepciones_p1_vivo.controller;

import com.bootcamp._excepciones_p1_vivo.dto.request.RequestBlogDto;
import com.bootcamp._excepciones_p1_vivo.dto.response.ResponseBlogDto;
import com.bootcamp._excepciones_p1_vivo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @PostMapping("blog")
    public ResponseEntity<String> addBlog(@RequestBody RequestBlogDto blogDto){
        return new ResponseEntity<>("Se ha agregado con exito con id: "+blogService.addBlogInId(blogDto), HttpStatus.OK);
        //No me quedo del todo claro si era correcto mostrar el id, pero trate de respetar el enunciado.
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<ResponseBlogDto> getBlog(@PathVariable Long id){
        return new ResponseEntity<>(blogService.getBlogById(id),HttpStatus.OK);
    }

    @GetMapping("blogs")
    public ResponseEntity<List<ResponseBlogDto>> getAll(){
        return new ResponseEntity<List<ResponseBlogDto>>(blogService.getAll(),HttpStatus.OK);
    }



}
