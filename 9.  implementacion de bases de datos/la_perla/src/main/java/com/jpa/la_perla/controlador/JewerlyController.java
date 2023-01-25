package com.jpa.la_perla.controlador;

import com.jpa.la_perla.dto.JewerlyResponseCompleteDto;
import com.jpa.la_perla.dto.JewerlyResponseDto;
import com.jpa.la_perla.dto.JewerlyRequestDto;
import com.jpa.la_perla.excepcion.NotFound;
import com.jpa.la_perla.modelo.Jewerly;
import com.jpa.la_perla.servicio.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/jewerly"))
public class JewerlyController {

    @Autowired
    IJewerlyService jewerlyService;

    @PostMapping("/new")
    public ResponseEntity<JewerlyResponseDto> create(@RequestBody JewerlyRequestDto joya) {
        return new ResponseEntity<>(jewerlyService.create(joya), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Jewerly>> get() {
        return new ResponseEntity<>(jewerlyService.get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(jewerlyService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewerlyResponseCompleteDto> update(@PathVariable Integer id,
                                                             @RequestBody JewerlyRequestDto jewerlyRequestDto) throws NotFound {
        return new ResponseEntity<>(jewerlyService.update(id, jewerlyRequestDto), HttpStatus.OK);
    }
}
