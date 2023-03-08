package com.bootcamp.clothes.controller;

import com.bootcamp.clothes.dto.request.SaleDTO;
import com.bootcamp.clothes.dto.response.MessageDTO;
import com.bootcamp.clothes.service.SaleService;
import com.bootcamp.clothes.service.interfaces.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/")
    ResponseEntity<MessageDTO> saveSale(@RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.saveEntity(saleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/")
    ResponseEntity<List<SaleDTO>> getAllSale() {
        return new ResponseEntity<>(saleService.getAllEntities(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    ResponseEntity<SaleDTO> getByNumberSale(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.getEntityById(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    ResponseEntity<MessageDTO> updateSale(@PathVariable Integer number, @RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.updateEntity(number, saleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    ResponseEntity<MessageDTO> deleteSale(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.deleteEntity(number), HttpStatus.OK);
    }

    @GetMapping("/date")
    ResponseEntity<List<SaleDTO>> getAllSaleByDate(@RequestParam LocalDate date) {
        return new ResponseEntity<>(saleService.getAllSaleByDate(date), HttpStatus.OK);
    }
}
