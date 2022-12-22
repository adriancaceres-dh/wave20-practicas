package com.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class FlotaDeNaves extends NaveBase {
    private List<NaveSimple> flota;

    public List<NaveSimple> getFlota() {
        return flota;
    }

    public FlotaDeNaves(String nombre, NaveSimple... naves) {
        super(nombre);
        flota = new ArrayList<>();
        flota.addAll(Arrays.asList(naves));
    }

    @Override
    public double distancia(double x, double y) {
        OptionalDouble promedio = flota.stream().mapToDouble(f -> f.distancia(x,y)).average();
        return promedio.orElse(-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Flota %s", nombre));
        flota.forEach(f -> sb.append("\n" + f.toString()));
        return sb.toString();
    }
}
