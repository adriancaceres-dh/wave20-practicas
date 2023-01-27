package com.example.JPA_2601.controller;

import com.example.JPA_2601.dto.ClothDTO;
import com.example.JPA_2601.dto.SaleDTO;
import com.example.JPA_2601.entity.Sale;
import com.example.JPA_2601.repository.ISaleRepository;
import com.example.JPA_2601.service.ClothService;
import com.example.JPA_2601.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    SaleService saleService;
    @PostMapping()
    public ResponseEntity<?> newSale(@RequestBody SaleDTO sale){
        return ResponseEntity.ok(saleService.saveEntity(sale));
    }
    @GetMapping("/{number}")
    public ResponseEntity<?> findSaleById(@PathVariable Integer number){
        return ResponseEntity.ok(saleService.getEntityById(number));
    }
    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@PathVariable Integer number, @RequestBody SaleDTO saleDTO){
        if(number != null && number != 0){
            if(saleService.saleExists(saleDTO.getNumero())){
                return ResponseEntity.ok(saleService.saveEntity(saleDTO));
            }
        }else throw new RuntimeException("No se puede enviar un id nulo");

        return null;
    }
    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Integer number){
        if (saleService.saleExists(number)){
            return ResponseEntity.ok(saleService.deleteEntity(number));
        }
        return null;
    }
}
