package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Garage addVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
        return this;
    }

    public void ordenarGaragePorPrecio(){
        this.vehiculos = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).collect(Collectors.toList());

    }

    public void ordenarGaragePorMarcaYPrecio(){
        Comparator<Vehiculo> comparador = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        this.vehiculos = vehiculos.stream().sorted(comparador).collect(Collectors.toList());
    }

    public List<Vehiculo> listaPrecioBajo(int num){
        return vehiculos.stream().filter(v-> v.getCosto()<=num).collect(Collectors.toList());
    }
    public List<Vehiculo> listaPrecioSobre(int num){
        return vehiculos.stream().filter(v-> v.getCosto()>=num).collect(Collectors.toList());
    }
    public double promedioCosto(){
        OptionalDouble average = vehiculos.stream().mapToDouble(a -> a.getCosto()).average();
        return average.getAsDouble();
    }
    public void imprimirGarage(){
        vehiculos.forEach(System.out::println);
    }
}
