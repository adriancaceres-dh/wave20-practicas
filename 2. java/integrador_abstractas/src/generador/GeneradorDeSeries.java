package generador;

public abstract class GeneradorDeSeries {
    protected int valorActual;
    protected int valorInicial;

    public abstract int next();

    public void reset() {
        valorActual = valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
        reset();
    }
}
