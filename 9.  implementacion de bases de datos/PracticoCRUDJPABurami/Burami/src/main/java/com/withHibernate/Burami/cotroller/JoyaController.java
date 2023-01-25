package com.withHibernate.Burami.cotroller;

import com.withHibernate.Burami.dto.JoyaDTO;
import com.withHibernate.Burami.dto.MessageDTO;
import com.withHibernate.Burami.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createEntity(@RequestBody JoyaDTO dto){
        return ResponseEntity.ok(joyaService.createEntity(dto));
    }

    @PutMapping("/id")
    public ResponseEntity<MessageDTO> updateEntity(@RequestBody JoyaDTO dto){
        return ResponseEntity.ok(joyaService.updateEntity(dto));
    }

}
