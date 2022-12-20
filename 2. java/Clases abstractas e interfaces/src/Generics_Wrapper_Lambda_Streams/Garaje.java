package Generics_Wrapper_Lambda_Streams;

import java.util.LinkedList;

public class Garaje {
    private int ID;
    private LinkedList<Vehiculo> vehiculos;

    public Garaje() {
    }

    public Garaje(int ID) {
        this.ID = ID;
        vehiculos = new LinkedList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void agregarNuevoVehiculo(Vehiculo nuevoVehiculo) {
        vehiculos.add(nuevoVehiculo);
    }
}
