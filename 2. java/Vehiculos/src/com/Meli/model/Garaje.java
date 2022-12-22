package com.Meli.model;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    /* Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje
    con los atributos id o identificador único y una lista de vehículos. Crea además los constructores de
    las clases y los métodos Setter y Getter.*/

    private String id;
    private List<Vehiculo> vehiculos;

    public Garaje(){
        vehiculos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id='" + id + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
