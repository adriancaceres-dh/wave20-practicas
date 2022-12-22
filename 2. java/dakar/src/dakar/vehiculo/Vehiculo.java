package dakar.vehiculo;

public abstract class Vehiculo {
    protected float velocidad;
    protected float aceleracion;
    protected float anguloDeGiro;
    protected float peso;
    protected int cantidadDeRuedas;
    protected String patente;

    public Vehiculo(float velocidad, float aceleracion, float anguloDeGiro, float peso, int cantidadDeRuedas, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.cantidadDeRuedas = cantidadDeRuedas;
        this.patente = patente;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public double calcularPuntaje() {
        return (velocidad * 0.5 * aceleracion) / (anguloDeGiro * (peso - cantidadDeRuedas * 100));
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(float aceleracion) {
        this.aceleracion = aceleracion;
    }

    public float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(float anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getCantidadDeRuedas() {
        return cantidadDeRuedas;
    }

    public void setCantidadDeRuedas(int cantidadDeRuedas) {
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", peso=" + peso +
                ", cantidadDeRuedas=" + cantidadDeRuedas +
                ", patente='" + patente + '\'' +
                '}';
    }
}
