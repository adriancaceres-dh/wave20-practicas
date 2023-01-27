package com.example.JPA_2601.controller;

import com.example.JPA_2601.dto.ClothDTO;
import com.example.JPA_2601.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes/")
public class ClothController {
    @Autowired
    ClothService clothService;
    @PostMapping()
    public ResponseEntity<?> newCloth(@RequestBody ClothDTO clothDTO){
        return ResponseEntity.ok(clothService.saveEntity(clothDTO));
    }
    @GetMapping("find")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(clothService.getAllEntities());
    }
    @GetMapping("find/{id}")
    public ResponseEntity<?> findByID(@PathVariable Integer id){
        return ResponseEntity.ok(clothService.getEntityById(id));
    }
    @PutMapping()
    public ResponseEntity<?> updateCloth(@RequestBody ClothDTO clothDTO){
        if(clothDTO.getCodigo() != null && !clothDTO.getCodigo().equals(0)){
            if(clothService.clothExists(clothDTO.getCodigo())){
                return ResponseEntity.ok(clothService.saveEntity(clothDTO));
            }
        }else throw new RuntimeException("No se puede enviar un null como id para actualizar");
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok(clothService.deleteEntity(id));
    }
    @GetMapping("findBy/sizer/{talle}")
    public ResponseEntity<?> findByTalle(@PathVariable Integer talle){
        return ResponseEntity.ok(clothService.findByTalle(talle));
    }
    @GetMapping("findBy/nombre")
    public ResponseEntity<?> findByNombre(@RequestParam(required = true) String nombre){
        return ResponseEntity.ok(clothService.findByNombre(nombre));
    }
}
