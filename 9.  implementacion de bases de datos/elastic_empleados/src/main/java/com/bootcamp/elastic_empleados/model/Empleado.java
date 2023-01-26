package com.bootcamp.elastic_empleados.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "employees")
public class Empleado {
    @Id
    String id;

    String nombre;

    String apellido;

    Short edad;

    String ciudad;

    String provincia;
}
