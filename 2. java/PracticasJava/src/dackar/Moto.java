package dackar;

public class Moto extends Vehiculo{
    private double peso =  300;

    private int ruedas = 2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int rueda, double peso1, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, rueda);
        this.peso = peso1;
        this.ruedas = ruedas;
    }
}
