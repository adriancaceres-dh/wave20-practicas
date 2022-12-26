package com.bootcamp._dto_p2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Sintoma {

    private String codigo, nombre, nivel_de_gravedad;
    private List<Long> id_sintomaticos; //La alternativa era agregar una lista en Persona de Sintoma, pero pense que de esta manera era mejor para practicar como relacionar las entidades.

    public Sintoma(String codigo, String nombre, String nivel_de_gravedad, List<Long> id_sintomaticos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
        this.id_sintomaticos = id_sintomaticos;
    }
    /*
    public Sintoma(String codigo, String nombre, String nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
        id_sintomaticos=new ArrayList<>();
    }
     */
}
