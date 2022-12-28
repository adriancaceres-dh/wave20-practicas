package com.bootcamp;

import java.util.List;

public class Garage{

    private int i;
    private List<Vehiculo> garage;

    public Garage(int i, List<Vehiculo> garage) {
        this.i = i;
        this.garage = garage;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public List<Vehiculo> getGarage() {
        return garage;
    }

    public void setGarage(List<Vehiculo> garage) {
        this.garage = garage;
    }
}
