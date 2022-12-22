public class Moto extends Vehiculo{

    public Moto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        this.ruedas = 2;
        this.peso = 300;
    }
}
