package com.jpa3.clothes.Controller;

import com.jpa3.clothes.DTO.MessageDTO;
import com.jpa3.clothes.DTO.POCResponseDTO;
import com.jpa3.clothes.Entity.PieceOfClothing;
import com.jpa3.clothes.Service.PieceOfClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class POCController {

    @Autowired
    PieceOfClothingService service;

    @PostMapping()
    public ResponseEntity<POCResponseDTO> savePOC(@RequestBody PieceOfClothing dto) {
        if (dto.getCode() == null || dto.getCode().equals(0)) {

            return ResponseEntity.ok(service.add(dto));
        } else {
            throw new RuntimeException("No se puede enviar un id en guardado");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<POCResponseDTO> GetPOCById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<POCResponseDTO>> getAllClothes() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping()
    public ResponseEntity<POCResponseDTO> updatePOC(@RequestBody PieceOfClothing dto) {
        if (dto.getCode() != null && !dto.getCode().equals(0)) {
            if (service.POCExists(dto.getCode()))
                return ResponseEntity.ok(service.update(dto));
        }
        throw new RuntimeException("No se puede enviar un null como id para actualizar");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deletePOC(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/findBy/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/findBy/size/{size}")
    public ResponseEntity<?> findBySize(@PathVariable String size) {
        return ResponseEntity.ok(service.findBySize(size));
    }
}
