package com.bootcamp.DeportesPersona.colector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClubDeporte {

    Deporte deporte1 = new Deporte("tennis",2);
    Deporte deporte2 = new Deporte("futbol",1);
    Deporte deporte3 = new Deporte("tejo",3);

    Persona persona1 = new Persona("Julian","Atehortua",25);
    Persona persona2 = new Persona("Carolina","Zuluaga",24);
    Persona persona3 = new Persona("Luis","Atehortua",70);


    Map<String,String> relacion1= persona1.practica(String.valueOf(persona1.getNombre()),String.valueOf(deporte1.getNombreDeporte()));
    Map<String,String> relacion2= persona2.practica(String.valueOf(persona2.getNombre()),String.valueOf(deporte2.getNombreDeporte()));
    Map<String,String> relacion3= persona3.practica(String.valueOf(persona3.getNombre()),String.valueOf(deporte3.getNombreDeporte()));

    Map<String,String > relaciones = new HashMap<>();

    @GetMapping("/finSports")

    public List<Deporte> mostrarDeporte(){
        List<Deporte> deportes = new ArrayList<>();
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);

        return deportes;
    }

    @GetMapping("/finSports/{nombrePersona}")

    public String mostrarDeportePersona(@PathVariable String nombrePersona){

        relaciones.put(String.valueOf(persona1.getNombre()),String.valueOf(deporte1.getNombreDeporte()));
        relaciones.put(String.valueOf(persona2.getNombre()),String.valueOf(deporte2.getNombreDeporte()));
        relaciones.put(String.valueOf(persona3.getNombre()),String.valueOf(deporte3.getNombreDeporte()));


        for (String i: relaciones.keySet()){



            if (i.equals(nombrePersona)){
                String mensaje = "La persona: "+i+" practica "+relaciones.get(i);
                 return mensaje;

            }
        }


        return "no se encontro";
    }
    @GetMapping("/mostrarTodo")
    public List<String > mostrarTodos(){

        List<String> TODO = new ArrayList<>();
        for (String i: relaciones.keySet()){

            String mensajeTodo = "La persona: "+i+" practica: "+relaciones.get(i);
            TODO.add(mensajeTodo);

        }

        return TODO;

    }

}
