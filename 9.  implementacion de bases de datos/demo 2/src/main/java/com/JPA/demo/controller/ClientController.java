package com.JPA.demo.controller;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.ProductDTO;
import com.JPA.demo.service.ClientService;
import com.JPA.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.saveEntity(clientDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> getAll(){
        return ResponseEntity.ok(clientService.getAllEntities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(clientService.getEntityById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(clientService.deleteEntity(id));
    }
}
