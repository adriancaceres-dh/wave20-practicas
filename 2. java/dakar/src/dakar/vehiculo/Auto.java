package dakar.vehiculo;

public class Auto extends Vehiculo {

    public Auto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, 1000, 4, patente);
    }
}
