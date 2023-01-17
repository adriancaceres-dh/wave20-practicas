package com.bootcamp.be_java_hisp_w20_g2.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Category {
    private int id;
    private String code;
    private String name;
}
