public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
    }

    @Override
    public double getPeso() {
        return 300;
    }
    @Override
    public int getRuedas() {
        return 2;
    }
}
