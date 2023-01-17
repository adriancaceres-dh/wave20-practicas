package com.bootcamp.be_java_hisp_w20_g2_podio.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {
    private Integer id;
    private int code;
    private String name;

    public Category(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
