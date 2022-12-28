package com.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }
    public boolean hayCuposDisponibles(){
        return cantidadDeVehiculosPermitidos >= listaDeVehiculos.size();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (!hayCuposDisponibles()){
            System.out.println("No hay mas cupos para inscribir un vehiculo");
        }else {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);

            for (Vehiculo vehiculo : listaDeVehiculos){
                if (vehiculo.getPatente().equals(auto.getPatente())){
                    System.out.println("El auto ya esta inscripta");
                }
            }
            listaDeVehiculos.add(auto);
            System.out.println("Auto inscripto");
        }

    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (!hayCuposDisponibles()){
            System.out.println("No hay mas cupos para inscribir un vehiculo");
        }else {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

            for (Vehiculo vehiculo : listaDeVehiculos){
                if (vehiculo.getPatente().equals(moto.getPatente())){
                    System.out.println("La moto ya esta inscripta");
                }
            }
            listaDeVehiculos.add(moto);
            System.out.println("Moto inscripta");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(!listaDeVehiculos.contains(vehiculo)){
            System.out.println("El vehiculo no esta inscripto");
        }else {
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado de la lista de participantes");
        }

    }

    public void eliminarVehiculoConPatente(String patente){
        if (patente.isEmpty()){
            System.out.println("Debe indicar una patente");
        }else {
            Vehiculo vehiculoEncontrado = null;
            for (Vehiculo vehiculo : listaDeVehiculos){
                if(vehiculo.getPatente().equals(patente)){
                    System.out.println("Vehiculo eliminado");
                    vehiculoEncontrado = vehiculo;
                }
            }
            listaDeVehiculos.remove(vehiculoEncontrado);
        }
    }
    public List<Vehiculo> ganadores(){
        List<Vehiculo> vehiculosGanadores = new ArrayList<>();
        Double resultado = 0.0;
        for (Vehiculo vehiculo : listaDeVehiculos){
            if (resultado <= vehiculo.formulaGanador()){
                vehiculosGanadores.add(vehiculo);
                resultado = vehiculo.formulaGanador();
            }
        }
        List<Vehiculo> otros = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculosGanadores){
            if (resultado > vehiculo.formulaGanador()){
                otros.add(vehiculo);
            }
        }
        if (!otros.isEmpty()){
            for (Vehiculo vehiculo : otros){
                vehiculosGanadores.remove(vehiculo);
            }
        }
        System.out.println("El o los gandores son -> " + vehiculosGanadores);
        return vehiculosGanadores;
    }

}
