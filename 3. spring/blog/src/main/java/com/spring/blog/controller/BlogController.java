package com.spring.blog.controller;

import com.spring.blog.dto.EntradaBlogRequestDto;
import com.spring.blog.dto.EntradaBlogResponseDto;
import com.spring.blog.dto.MensajeEntradaBlogResponseDto;
import com.spring.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(value={"/blogs","/blogs/{id}"})
    public ResponseEntity<List<EntradaBlogResponseDto>> getEntradaBlobDto(@PathVariable(required = false) String id) {
        return new ResponseEntity<>(blogService.getEntradaBlogResponseDtos(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<MensajeEntradaBlogResponseDto> addEntrada(
            @RequestBody EntradaBlogRequestDto entradaBlogRequestDto) {
        return new ResponseEntity<>(blogService.addEntrada(entradaBlogRequestDto), HttpStatus.OK);
    }

}
