package com.bootcamp.be_java_hisp_w20_g1_berthet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && name.equals(product.name) && type.equals(product.type) && brand.equals(product.brand) && color.equals(product.color) && notes.equals(product.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, brand, color, notes);
    }
}
