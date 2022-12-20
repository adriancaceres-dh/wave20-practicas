package Series_Numericas;

public class SerieInteger extends SerieNumerica<Integer>{


    public SerieInteger(Integer valor, Integer valorSerienumerica) {
        super(valor, valorSerienumerica);
    }

    @Override
    public void definirValorSerieNumerica(Integer nuevoValor) {
        valorActual = nuevoValor;
    }

    @Override
    public Integer valorSiguiente() {
        return valorActual + valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0;
    }
}
