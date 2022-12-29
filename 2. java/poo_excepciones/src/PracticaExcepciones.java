public class PracticaExcepciones {
    int dividendo;
    int divisor;

    public PracticaExcepciones() {
    }

    public PracticaExcepciones(int dividendo, int divisor) {
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

    public int getDividendo() {
        return dividendo;
    }

    public void setDividendo(int dividendo) {
        this.dividendo = dividendo;
    }

    public  double calcularCociente(){
        return dividendo/divisor;
    }
}
