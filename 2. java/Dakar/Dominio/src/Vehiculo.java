public abstract class Vehiculo {
    private double Velocidad;
    private double Aceleración;
    private double AnguloDeGiro;
    private String Patente;
    private double Peso;
    private int Ruedas;

    public Vehiculo(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        Velocidad = velocidad;
        Aceleración = aceleración;
        AnguloDeGiro = anguloDeGiro;
        Patente = patente;
    }

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double velocidad) {
        Velocidad = velocidad;
    }

    public double getAceleración() {
        return Aceleración;
    }

    public void setAceleración(double aceleración) {
        Aceleración = aceleración;
    }

    public double getAnguloDeGiro() {
        return AnguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        AnguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public double getPeso() {
        return Peso;
    }

    public int getRuedas() {
        return Ruedas;
    }

}
