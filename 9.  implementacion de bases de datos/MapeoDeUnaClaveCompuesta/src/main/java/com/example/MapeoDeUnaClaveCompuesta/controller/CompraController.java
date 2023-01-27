package com.example.MapeoDeUnaClaveCompuesta.controller;


import com.example.MapeoDeUnaClaveCompuesta.dto.CompraDTO;
import com.example.MapeoDeUnaClaveCompuesta.dto.MessagesDTO;
import com.example.MapeoDeUnaClaveCompuesta.service.ICompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final ICompraService compraService;

    public CompraController(ICompraService serviceCompra) {
        this.compraService = serviceCompra;
    }

    @PostMapping("")
    public ResponseEntity<MessagesDTO> createCompra(@RequestBody CompraDTO compraDto){
        return ResponseEntity.ok(compraService.compraSeve(compraDto));
    }
}
