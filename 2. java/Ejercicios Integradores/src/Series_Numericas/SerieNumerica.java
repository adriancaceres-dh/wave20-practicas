package Series_Numericas;

public abstract class SerieNumerica<T extends Number> {
    protected T valorActual;
    protected T valorSerienumerica;

    public SerieNumerica(T valor, T valorSerienumerica) {
        this.valorActual = valor;
        this.valorSerienumerica = valorSerienumerica;
    }

    public abstract void definirValorSerieNumerica(T nuevoValor);

    public abstract T valorSiguiente();

    public abstract void reiniciarSerie();
}
