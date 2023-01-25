package com.bootcamp.clavescompuestas.controller;

import com.bootcamp.clavescompuestas.model.Compra;
import com.bootcamp.clavescompuestas.model.CompraKey;
import com.bootcamp.clavescompuestas.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compras/")
public class CompraController {

    CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping("/buscar/cliente/{id}")
    public ResponseEntity<List<Compra>> buscarComprasPorIdCliente(@PathVariable Integer id) {
        return ResponseEntity.ok(compraService.buscarComprasPorIdCliente(id));
    }

    @GetMapping("buscar")
    public ResponseEntity<Compra> buscarCompraPorClaveCompuesta(@RequestBody CompraKey id) {
        return ResponseEntity.ok(compraService.buscarCompra(id));
    }
}
