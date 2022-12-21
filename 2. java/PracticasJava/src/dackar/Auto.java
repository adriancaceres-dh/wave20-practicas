package dackar;

public class Auto extends Vehiculo{
    private double peso =  1000;
    private int ruedas = 4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int rueda, double peso1, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, rueda);
        this.peso = peso1;
        this.ruedas = ruedas;
    }
}
