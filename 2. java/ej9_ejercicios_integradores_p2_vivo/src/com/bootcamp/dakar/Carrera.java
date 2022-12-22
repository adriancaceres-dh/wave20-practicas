package com.bootcamp.dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia, premioDolares;
    private String Nombre;
    private int cantVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public Carrera(double distancia, double premioDolares, String nombre, int cantVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        Nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.listaVehiculos= new ArrayList<>();
        this.socorristaAuto= new SocorristaAuto();
        this.socorristaMoto= new SocorristaMoto();
    }

    public boolean hayCupo(){
        return this.listaVehiculos.size()<this.cantVehiculosPermitidos;
    }

    public boolean darDeAltaAuto(double velocidad, double aceleracion, double angulo, String patente){
        if(hayCupo()) {
            Auto auto = new Auto(velocidad,aceleracion,angulo,patente);
            this.listaVehiculos.add(auto);
            return true;
        }else{
            return false;
        }
    }

    public boolean darDeAltaMoto(double velocidad, double aceleracion, double angulo, String patente){
        if(hayCupo()){
            Moto moto = new Moto(velocidad,aceleracion,angulo,patente);
            listaVehiculos.add(moto);
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo){
        return listaVehiculos.remove(vehiculo);
    }

    public boolean eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculo = this.getListaVehiculos().stream()
                                    .filter(v->v.getPatente().equals(patente))
                                    .findFirst().orElse(null);
        return listaVehiculos.remove(vehiculo);
    }

    public Vehiculo definirGanador(){
        double maxRapidez=Double.MIN_VALUE;
        Vehiculo masRapido=null;
        for(Vehiculo vehiculo: this.getListaVehiculos()){
            if(vehiculo.rapidez()>maxRapidez){
                maxRapidez=vehiculo.rapidez();
                masRapido=vehiculo;
            }
        }
        return masRapido;
    }

    /*
    public Vehiculo determinarGanador() {
        return this.getListaVehiculos().stream()
                .max(Comparator.comparingDouble(Vehiculo::rapidez))
                .get();
    }
    */

    public boolean socorrerAuto(String patente){
        try {
            Auto auto = this.getListaVehiculos().stream()
                    .filter(a -> a.getPatente().equals(patente))
                    .findFirst()
                    .map(Auto.class::cast)
                    .orElse(null);
            return socorristaAuto.socorrer(auto);
        }catch (Exception e){
            System.out.println("No se pudo socorrer el auto.");
            return false;
        }
    }

    public boolean socorrerMoto(String patente){
        try {
            Moto moto = this.getListaVehiculos().stream()
                    .filter(a -> a.getPatente().equals(patente))
                    .findFirst()
                    .map(Moto.class::cast)
                    .orElse(null);
            return socorristaMoto.socorrer(moto);
        }catch (Exception e){
            System.out.println("No se pudo socorrer el moto.");
            return false;
        }
    }

}
