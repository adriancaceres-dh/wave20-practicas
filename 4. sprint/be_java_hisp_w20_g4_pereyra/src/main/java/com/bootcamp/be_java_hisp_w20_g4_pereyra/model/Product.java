package com.bootcamp.be_java_hisp_w20_g4_pereyra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private static int contador = 4;
    private int product_id;
    private String product_name;
    private String color;
    private String notes;
    private String type;
    private String brand;

    public Product(String product_name, String color, String notes, String type, String brand) {
        this.product_name = product_name;
        this.color = color;
        this.notes = notes;
        this.type = type;
        this.brand = brand;
        contador++;
        this.product_id = contador;
    }
}
