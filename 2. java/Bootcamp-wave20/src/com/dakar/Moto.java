package com.dakar;

    public class Moto extends Vehiculo{
        public Moto(String patente) {
            super(patente);
        }

        public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
            super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
        }

        @Override
        public String toString() {
            return String.format("Moto Mat: %8s", getPatente());
        }
    }

