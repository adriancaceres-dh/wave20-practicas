package com.bootcamp.calories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class RequestDTO {
    private String name;
    private double weithgr;

    public String getName() {
        return name;
    }

    public double getWeithgr() {
        return weithgr;
    }
}
