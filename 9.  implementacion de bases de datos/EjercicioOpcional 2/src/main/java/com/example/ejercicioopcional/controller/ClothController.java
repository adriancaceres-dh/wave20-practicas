package com.example.ejercicioopcional.controller;

import com.example.ejercicioopcional.dto.ClothDTO;
import com.example.ejercicioopcional.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

    @Autowired
    private ClothService clothService;

    @PostMapping()
    public ResponseEntity<?> metodo1(@RequestBody ClothDTO dto){
        if(dto.getCode() == null || dto.getCode().equals(0))
            return ResponseEntity.ok(clothService.saveEntity(dto));
        else
            throw new RuntimeException("No se puede enviar un id en el guardado");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> metodo2(@PathVariable Integer id){
        return ResponseEntity.ok(clothService.getEntityById(id));
    }

    @GetMapping("find")
    public ResponseEntity<?> metodo3(){
        return ResponseEntity.ok(clothService.getAllEntities());
    }

    @PutMapping()
    public ResponseEntity<?> metodo4(@RequestBody ClothDTO dto){
        if(dto.getCode() != null && !dto.getCode().equals(0)) {
            if (clothService.clothExists(dto.getCode()))
                return ResponseEntity.ok(clothService.saveEntity(dto));
        }
        throw new RuntimeException("No se puede enviar un null como id para actualizar");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> metodo5(@PathVariable Integer id){
        return ResponseEntity.ok(clothService.deleteEntity(id));
    }

    @GetMapping("/findBy/name/{name}")
    public ResponseEntity<?> metodo6(@PathVariable String name){
        return ResponseEntity.ok(clothService.findByName(name));
    }

    @GetMapping("/findBy/size/{size}")
    public ResponseEntity<?> metodo7(@PathVariable Integer size){
        return ResponseEntity.ok(clothService.findBySize(size));
    }


}
