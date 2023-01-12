package com.bootcamp.ejercicio_link_tracker.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data


public class Link {
    private int id;
    private int counter;
    private String URL;
}
