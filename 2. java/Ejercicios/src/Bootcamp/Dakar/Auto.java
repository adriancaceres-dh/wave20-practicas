package Bootcamp.Dakar;

public class Auto extends Vehiculo{
    public Auto(String patente) {
        super(patente);
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public String toString() {
        return String.format("Auto Mat: %8s", getPatente());
    }
}