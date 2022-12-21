package dackar;

public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int rueda;

    public Vehiculo() {
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int rueda) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.rueda = rueda;
    }
}
