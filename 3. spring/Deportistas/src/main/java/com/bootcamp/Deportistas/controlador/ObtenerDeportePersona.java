package com.bootcamp.Deportistas.controlador;

import com.bootcamp.Deportistas.DTO.DeportePersonaDTO;
import com.bootcamp.Deportistas.entity.Deporte;
import com.bootcamp.Deportistas.entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ObtenerDeportePersona {
    @GetMapping("/findSports/{deporte}")
    public ResponseEntity devolverDeportePorNombre(@PathVariable String deporte){
        Deporte d1 = new Deporte("Tenis", "avanzado");
        Deporte d2 = new Deporte("Futbol", "Principiante");
        Deporte d3 = new Deporte("Voley", "Master");

        List<Deporte> listaDeportes = new ArrayList<>();
        listaDeportes.add(d1);
        listaDeportes.add(d2);
        listaDeportes.add(d3);

        Deporte deporteEncontrado = listaDeportes.stream().filter(x->x.getNombre().equals(deporte)).findFirst().orElse(null);


        return new ResponseEntity<Deporte>(deporteEncontrado, HttpStatus.OK);
    }

    @GetMapping("/findSports")
    public ResponseEntity devolverDeportes(){
        Deporte d1 = new Deporte("Tenis", "avanzado");
        Deporte d2 = new Deporte("Futbol", "Principiante");
        Deporte d3 = new Deporte("Voley", "Master");

        List<Deporte> listaDeportes = new ArrayList<>();
        listaDeportes.add(d1);
        listaDeportes.add(d2);
        listaDeportes.add(d3);


        return new ResponseEntity<List>(listaDeportes, HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity devolverPersonaDeporte(){
        Persona p = new Persona("Armando","Burdiles",32);
        Persona p2 = new Persona("Javiera","Burdiles",89);
        Deporte d = new Deporte("Tenis", "avanzado");
        Deporte d2 = new Deporte("Futbol", "Principiante");
        Deporte d3 = new Deporte("Voley", "Master");
        List<DeportePersonaDTO> listadoDTO = new ArrayList<>();
        //primera
        DeportePersonaDTO dp = new DeportePersonaDTO();
        List listaDeportes = new ArrayList<>();
        listaDeportes.add(d.getNombre());
        listaDeportes.add(d3.getNombre());
        dp.setDeportes(listaDeportes);
        dp.setFullName(p.getNombre()+" "+p.getApellido());
        listadoDTO.add(dp);
        //segunda
        DeportePersonaDTO dp2 = new DeportePersonaDTO();
        listaDeportes.clear();
        listaDeportes.add(d.getNombre());
        listaDeportes.add(d2.getNombre());
        listaDeportes.add(d3.getNombre());
        dp2.setDeportes(listaDeportes);
        dp2.setFullName(p2.getNombre()+" "+p2.getApellido());
        listadoDTO.add(dp2);


        return new ResponseEntity<List<DeportePersonaDTO>>(listadoDTO, HttpStatus.OK);
    }
}
