package com.bootcamp;

import java.util.List;

public class Garage {
 int id;
 List<Vehiculo> vehiculoList;

    public Garage() {
    }

    public Garage(int id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }
    public  void addVehicle(Vehiculo vehiculo){
        vehiculoList.add(vehiculo);
    }
    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculoList=" + vehiculoList +
                '}';
    }
}
