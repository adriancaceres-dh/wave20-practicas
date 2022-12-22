package com.bootcamp;

import java.util.Objects;

public class Vehiculo {
    int velocidad;
    int aceleracion;
    int anguloDeGiro;
    String patente;
    int peso;
    int ruedas;

    public Vehiculo(){

    }

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return velocidad == vehiculo.velocidad && aceleracion == vehiculo.aceleracion && anguloDeGiro == vehiculo.anguloDeGiro && peso == vehiculo.peso && ruedas == vehiculo.ruedas && Objects.equals(patente, vehiculo.patente);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}
