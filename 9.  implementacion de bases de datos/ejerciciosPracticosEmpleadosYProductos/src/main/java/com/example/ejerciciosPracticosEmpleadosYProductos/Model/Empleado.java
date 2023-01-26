package com.example.ejerciciosPracticosEmpleadosYProductos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "empleados")
public class Empleado {
    @Id
    @Field(type = FieldType.Integer)
    private Integer id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String apellido;
    private Integer edad;
    @Column(length = 30)
    private String ciudad;
    @Column(name = "provincia/estado/departamento")
    private String provincia_estado_departamento;
}