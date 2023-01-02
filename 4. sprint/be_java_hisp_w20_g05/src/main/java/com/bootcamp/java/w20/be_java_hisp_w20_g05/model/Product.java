package com.bootcamp.java.w20.be_java_hisp_w20_g05.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int id;
    private String name;
    private String brand;
    private String type;
    private String color;
    private String notes;
    private String type;
}
