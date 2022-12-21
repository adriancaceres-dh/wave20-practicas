package dakar;

import dakar.socorrista.SocorristaAuto;
import dakar.socorrista.SocorristaMoto;
import dakar.vehiculo.Auto;
import dakar.vehiculo.Moto;
import dakar.vehiculo.Vehiculo;

import java.util.Comparator;
import java.util.List;

public class Carrera {
    private float distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(float velocidad, float aceleracion, float anguloDeGiro, String patente){
        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente){
        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public Vehiculo vehiculoGanador() {
        return vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::calcularPuntaje)).get();
    }

    public void socorrerAuto(String patente) {
        Vehiculo autoBuscado = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findAny()
                .get();
        if(autoBuscado instanceof Auto)
            socorristaAuto.socorrer((Auto) autoBuscado);
    }

    public void socorrerMoto(String patente) {
        Vehiculo motoBuscada = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findAny()
                .get();
        if(motoBuscada instanceof Moto)
            socorristaMoto.socorrer((Moto) motoBuscada);
    }
}
