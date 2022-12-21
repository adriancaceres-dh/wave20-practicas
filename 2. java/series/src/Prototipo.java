public abstract class Prototipo<T extends Number>  {

    protected T valorInicial;
    protected T valorIncremento;
    protected T valorActual;

    public Prototipo(T valorInicial, T valorIncremento, T valorActual) {
        this.valorInicial = valorInicial;
        this.valorIncremento = valorIncremento;
        this.valorActual = valorActual;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorIncremento() {
        return valorIncremento;
    }

    public void setValorIncremento(T valorIncremento) {
        this.valorIncremento = valorIncremento;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public abstract T valorSiguiente();
    public abstract void reiniciarSerie();
    public abstract void valorInicial(T valor);
}
