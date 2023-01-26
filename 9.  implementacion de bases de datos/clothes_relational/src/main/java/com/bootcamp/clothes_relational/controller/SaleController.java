package com.bootcamp.clothes_relational.controller;

import com.bootcamp.clothes_relational.dto.common.GarmentDTO;
import com.bootcamp.clothes_relational.dto.common.SaleDTO;
import com.bootcamp.clothes_relational.dto.response.MessageDTO;
import com.bootcamp.clothes_relational.service.sale.ISaleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    
    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    ResponseEntity<MessageDTO> createSale(@RequestBody SaleDTO saleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.create(saleDTO));
    }

    @GetMapping
    ResponseEntity<List<SaleDTO>> getSales(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date != null)
            return ResponseEntity.status(HttpStatus.OK).body(saleService.getAllByDateEquals(date));

        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAll());
    }

    @GetMapping("/{number}")
    ResponseEntity<SaleDTO> getSaleByNumber(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getById(number));
    }

    @GetMapping("/clothes/{number}")
    ResponseEntity<List<GarmentDTO>> getClothesBySaleNumber(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getClothesBySaleNumber(number));
    }

    @PutMapping("/{number}")
    ResponseEntity<MessageDTO> updateSaleByNumber(@PathVariable Long number, @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.update(number, saleDTO));
    }

    @DeleteMapping("/{number}")
    ResponseEntity<MessageDTO> deleteSaleByNumber(@PathVariable Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.deleteById(number));
    }
}
