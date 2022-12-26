package com.bootcamp.Covid19.servicios;

import com.bootcamp.Covid19.dto.PersonaSintomaDTO;
import com.bootcamp.Covid19.entity.Persona;
import com.bootcamp.Covid19.entity.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EnfermedadServicios {

    Persona p1 = new Persona(1, "Armando","Burdiles", 32);
    Persona p2 = new Persona(2, "Javiera","Reveco", 61);
    Persona p3 = new Persona(3, "Belen","Burdiles", 11);

    Sintoma s1 = new Sintoma(1,"Vomito", "Baja");
    Sintoma s2 = new Sintoma(2,"Dolor de Cabeza", "Media");
    Sintoma s3 = new Sintoma(3,"Mareo", "Alta");

    List<Sintoma> listaSintomas = new ArrayList<>(){{add(s1);add(s2);add(s3);}};

    Map<Persona, Sintoma> ps = new HashMap<Persona, Sintoma>(){{ put(p1,s2); put(p2,s3); put(p3,s1);}};

    PersonaSintomaDTO peDTO = new PersonaSintomaDTO();




    public ResponseEntity enfermedades(String name){

        if(name == null){
            return new ResponseEntity<>(listaSintomas, HttpStatus.OK);
        }else{
           Sintoma s =  listaSintomas.stream().filter(x->x.getNombre().equals(name)).findFirst().orElse(null);
            return new ResponseEntity<>(s.getNivelGravedad(), HttpStatus.OK);
        }



    }

    public ResponseEntity enfermedadPorPersona(){


      List o =    ps.entrySet().stream().filter(x->x.getKey().getEdad()>60)
              .map(y -> new PersonaSintomaDTO(y.getKey().getNombre()+" "+y.getKey().getApellido(),y.getValue()))
              .collect(Collectors.toList());


        return new ResponseEntity<>(o, HttpStatus.OK);


    }
}
