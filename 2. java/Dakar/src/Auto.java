public class Auto extends Vehiculo {

    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        super.ruedas = 4;
        super.peso = 1000;
    }
}
