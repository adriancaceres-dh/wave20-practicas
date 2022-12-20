package Series_Numericas;

public class SerieDouble extends SerieNumerica<Double>{


    public SerieDouble(Double valor, Double valorSerienumerica) {
        super(valor, valorSerienumerica);
    }

    @Override
    public void definirValorSerieNumerica(Double nuevoValor) {
        valorActual = nuevoValor;
    }

    @Override
    public Double valorSiguiente() {
        return valorActual + valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0.0;
    }
}
