package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.MessageDto;
import com.bootcamp.showroom.dto.SaleRequestDto;
import com.bootcamp.showroom.dto.SaleResponseDto;
import com.bootcamp.showroom.service.interfaces.ISaleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("")
    public ResponseEntity<SaleResponseDto> createSale(@RequestBody SaleRequestDto saleRequestDto) {
        return ResponseEntity.ok(saleService.createSale(saleRequestDto));
    }

    @GetMapping("")
    public ResponseEntity<List<SaleResponseDto>> getAllSales(@RequestParam (required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(saleService.getAllSalesByDate(date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDto> getSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDto> updateSaleById(@RequestBody SaleRequestDto saleRequestDto, @PathVariable Long id) {
        return ResponseEntity.ok(saleService.updateSaleById(saleRequestDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.deleteSaleById(id));
    }
}
