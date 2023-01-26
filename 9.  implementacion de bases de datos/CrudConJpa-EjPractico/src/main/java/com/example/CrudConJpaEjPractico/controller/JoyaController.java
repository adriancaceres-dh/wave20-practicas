package com.example.CrudConJpaEjPractico.controller;


import com.example.CrudConJpaEjPractico.DTO.JoyaDTO;
import com.example.CrudConJpaEjPractico.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaservice;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> createJoya(@RequestBody JoyaDTO joyaDto){
        Integer idJoyaCreada = joyaservice.create(joyaDto);
        return new ResponseEntity<>("Nro identificatorio es : " + idJoyaCreada, HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaDTO>> getAllJoyas(){
        return ResponseEntity.ok(joyaservice.getJoyas());
    }

    @GetMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteLogic(@PathVariable int id){

        int idBorrado = joyaservice.deleteLogic(id);

        if(idBorrado > 0)
        {
            return new ResponseEntity<>("Id borrado correctamente : " + idBorrado, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Id no existente. ", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ping")
    public String pong(){
        return "Ping-pong";
    }
}
