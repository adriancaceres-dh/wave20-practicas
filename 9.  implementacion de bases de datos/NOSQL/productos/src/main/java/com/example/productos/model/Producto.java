package com.example.productos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String nombre;
    @Field(type = FieldType.Text)
    private String tipo;
    @Field(type = FieldType.Text, name = "precio_venta")
    private String precioVenta;
    @Field(type = FieldType.Text, name = "precio_costo")
    private String precioCosto;
    @Field(type = FieldType.Text)
    private String cantidad;
}
