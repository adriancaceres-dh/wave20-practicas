package com.jpa3.clothes.Controller;

import com.jpa3.clothes.DTO.MessageDTO;
import com.jpa3.clothes.DTO.POCResponseDTO;
import com.jpa3.clothes.DTO.SaleRequestDTO;
import com.jpa3.clothes.DTO.SaleResponseDTO;
import com.jpa3.clothes.Service.SaleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping()
    public ResponseEntity<SaleResponseDTO> saveSale(@RequestBody SaleRequestDTO dto) {
        if (dto.getCode() == null || dto.getCode().equals(0)) {
            return ResponseEntity.ok(saleService.add(dto));
        } else {
            throw new RuntimeException("No se puede enviar un id en guardado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> GetSaleById(@PathVariable Integer id) {
        return ResponseEntity.ok(saleService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<SaleResponseDTO>> findByDate(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(saleService.findByDate(date));
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<POCResponseDTO>> findClothesBySaleId(@PathVariable Integer id){
        return ResponseEntity.ok(saleService.findClothesBySaleId(id));
    }

    @PutMapping()
    public ResponseEntity<SaleResponseDTO> updateSale(@RequestBody SaleRequestDTO dto) {
        if (dto.getCode() != null && !dto.getCode().equals(0)) {
            if (saleService.saleExists(dto.getCode()))

                return ResponseEntity.ok(saleService.update(dto));
        }
        throw new RuntimeException("No se puede enviar un null como id para actualizar");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteSale(@PathVariable Integer id) {
        return ResponseEntity.ok(saleService.delete(id));
    }

}
