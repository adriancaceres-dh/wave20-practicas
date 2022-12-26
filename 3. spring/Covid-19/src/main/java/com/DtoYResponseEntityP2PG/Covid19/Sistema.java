package com.DtoYResponseEntityP2PG.Covid19;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Sistema {

    @GetMapping("/sintomas")
    public SintomasDto allSintomas()
    {
        //Sintomas de personas distintas.
        List<Sintoma> sintomas1 = new ArrayList<>();
        sintomas1.add(new Sintoma(1, "Tos", 1));
        sintomas1.add(new Sintoma(2, "Flemas", 1));

        List<Sintoma> sintomas2 = new ArrayList<>();
        sintomas2.add(new Sintoma(3, "Fiebre", 1));
        sintomas2.add(new Sintoma(4, "Manchas en la piel", 3));
        sintomas2.add(new Sintoma(5, "Dolor de garganta", 4));

        List<Sintoma> sintomas3 = new ArrayList<>();
        sintomas3.add(new Sintoma(6, "Mareos", 2));
        sintomas3.add(new Sintoma(7, "Gripe", 2));

        //Creo las personas y les asigno sus sintomas.
        Persona persona1 = new Persona(1, "Santiago", 23, "Valdez", sintomas1);
        Persona persona2 = new Persona(2, "Leonel", 23, "Messi", sintomas2);
        Persona persona3 = new Persona(3, "Luis", 23, "Suarez", sintomas3);

        //Guardo todas las personas en una lista y consulto que sintomas tienen cada uno.
        List<Persona> personasHospitalizadas = new ArrayList<>();
        personasHospitalizadas.add(persona1);
        personasHospitalizadas.add(persona2);
        personasHospitalizadas.add(persona3);

        List<Sintoma> totalSintomas = new ArrayList<>();
        personasHospitalizadas.stream().forEach(p -> totalSintomas.addAll(p.getSintomas()));

        SintomasDto sintomasDto = new SintomasDto();
        totalSintomas.stream().forEach(ts -> sintomasDto.setSintomas(ts.getNombre()));
        return sintomasDto;
    };

    @GetMapping("/buscar-sintoma/{sintoma}")
    public ResponseEntity<String> buscarSintoma(@PathVariable String sintoma)
    {
        //Sintomas de personas distintas.
        List<Sintoma> sintomas1 = new ArrayList<>();
        sintomas1.add(new Sintoma(1, "Tos", 1));
        sintomas1.add(new Sintoma(2, "Flemas", 1));

        List<Sintoma> sintomas2 = new ArrayList<>();
        sintomas2.add(new Sintoma(3, "Fiebre", 1));
        sintomas2.add(new Sintoma(4, "Manchas en la piel", 3));
        sintomas2.add(new Sintoma(5, "Dolor de garganta", 4));

        List<Sintoma> sintomas3 = new ArrayList<>();
        sintomas3.add(new Sintoma(6, "Mareos", 2));
        sintomas3.add(new Sintoma(7, "Gripe", 2));

        //Creo las personas y les asigno sus sintomas.
        Persona persona1 = new Persona(1, "Santiago", 23, "Valdez", sintomas1);
        Persona persona2 = new Persona(2, "Leonel", 23, "Messi", sintomas2);
        Persona persona3 = new Persona(3, "Luis", 23, "Suarez", sintomas3);

        //Guardo todas las personas en una lista y consulto que sintomas tienen cada uno.
        List<Persona> personasHospitalizadas = new ArrayList<>();
        personasHospitalizadas.add(persona1);
        personasHospitalizadas.add(persona2);
        personasHospitalizadas.add(persona3);

        List<Sintoma> totalSintomas = new ArrayList<>();
        personasHospitalizadas.stream().forEach(p -> totalSintomas.addAll(p.getSintomas()));

        List<Sintoma> total = totalSintomas.stream().filter(ts -> ts.getNombre().equalsIgnoreCase(sintoma)).collect(Collectors.toList());

        if(!total.isEmpty())
        {
            return new ResponseEntity<>("Encontrado! -> " + total.toString(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No se encontro sintoma :( , pruebe con tos, gripe .. ", HttpStatus.BAD_REQUEST);
        }
    };
}
