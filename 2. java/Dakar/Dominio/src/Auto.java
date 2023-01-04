public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
    }

    @Override
    public double getPeso() {
        return 1000;
    }

    @Override
    public int getRuedas() {
        return 4;
    }
}
