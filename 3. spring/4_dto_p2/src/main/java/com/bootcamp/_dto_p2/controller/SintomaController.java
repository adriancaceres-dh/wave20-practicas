package com.bootcamp._dto_p2.controller;

import com.bootcamp._dto_p2.dto.SintomaDTO;
import com.bootcamp._dto_p2.model.Sintoma;
import com.bootcamp._dto_p2.repository.SintomaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SintomaController {

    @GetMapping("/findSympton")
    public ResponseEntity<List<SintomaDTO>> findSympton(){
        List<SintomaDTO> sintomasDTO = SintomaRepository.getAll().stream()
                                            .map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(),sintoma.getNivel_de_gravedad()))
                                            .collect(Collectors.toList());
        return new ResponseEntity<>(sintomasDTO, HttpStatus.OK);
    }

    @GetMapping("/findSympton/{name}")
    public ResponseEntity<String> findSymptonByName(@PathVariable String name){
        if(SintomaRepository.contiene(name)) {
            return new ResponseEntity<String>(SintomaRepository.getGravedadByName(name), HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("No se encontro el sintoma.",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/findSympton")
    public ResponseEntity<String> postSymptons(@RequestBody List<Sintoma> sintomas){
        boolean ok = SintomaRepository.addAll(sintomas);
        if (ok){ return new ResponseEntity<String>("Agregados correctamente!",HttpStatus.OK);}
        else{ return new ResponseEntity<String>("No se pudo agregar los sintomas :(",HttpStatus.INSUFFICIENT_STORAGE);}
    }

}
