package com.bootcamp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {

    int id;
    List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
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

    public void ordenarGaragePorPrecio(){
        this.vehiculos = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).collect(Collectors.toList());
        this.imprimirGarage();
    }

    public void ordenarGaragePorMarcaYPrecio(){
        Comparator<Vehiculo> comparador = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        this.vehiculos = vehiculos.stream().sorted(comparador).collect(Collectors.toList());
        this.imprimirGarage();
    }

    public List<Vehiculo> listaPrecioHasta(int num){
        return vehiculos.stream().filter(v-> v.getCosto()<=num).collect(Collectors.toList());
    }
    public List<Vehiculo> listaPrecioDesde(int num){
        return vehiculos.stream().filter(v-> v.getCosto()>=num).collect(Collectors.toList());
    }
    public int promedioCosto(){
        return vehiculos.stream().mapToInt(a -> a.getCosto()).sum() / vehiculos.size();
    }
    public void imprimirGarage(){
        vehiculos.forEach(System.out::println);
    }
}
