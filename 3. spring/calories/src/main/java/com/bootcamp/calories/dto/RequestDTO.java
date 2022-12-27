package com.bootcamp.calories.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestDTO {
    String name;
    double weithgr;

    public String getName() {
        return name;
    }

    public double getWeithgr() {
        return weithgr;
    }
}
