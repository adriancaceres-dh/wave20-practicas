package generador;

public abstract class GeneradorDeSeries<T extends Number> {
    protected T valorActual;
    protected T valorInicial;
    protected T salto;

    public GeneradorDeSeries(T salto) {
        this.salto = salto;
    }

    public GeneradorDeSeries(T salto, T valorInicial) {
        this.salto = salto;
        this.valorInicial = valorInicial;
    }

    public abstract T next();

    public void reset() {
        valorActual = valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        reset();
    }
}
