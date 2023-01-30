package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.JoyaResponse;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "jewerly")
public class JoyaController
{
    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("new")
    public ResponseEntity<JoyaResponse> create(@RequestBody Joya joya)
    {
        Joya res = joyaService.create(joya);
        JoyaResponse joyaResponse = new JoyaResponse(res.getNro_identificatorio());
        return ResponseEntity.ok(joyaResponse);

    }

    @PostMapping("delete/{id}")
    public ResponseEntity<JoyaResponse> delete(@RequestParam int id){
        int res = joyaService.delete(id);
        JoyaResponse joyaResponse = new JoyaResponse(id);
        return ResponseEntity.ok(joyaResponse);
    }
    @PostMapping("update/{id}")
    public ResponseEntity<Joya> edit(@RequestBody Joya joya, @RequestParam int id)
    {
        if(id != joya.getNro_identificatorio()){
            throw new RuntimeException("Id para editar no es válido");
        }


        Joya res = joyaService.edit(joya);
        return ResponseEntity.ok(res);

    }
    @GetMapping
    public List<Joya> getAll(){
        return joyaService.getAll();
    }


}

