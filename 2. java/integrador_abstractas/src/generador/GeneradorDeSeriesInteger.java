package generador;

public class GeneradorDeSeriesInteger extends GeneradorDeSeries<Integer>{

    public GeneradorDeSeriesInteger(Integer salto) {
        super(salto);
        valorActual = 0;
        valorInicial = 0;
    }

    public GeneradorDeSeriesInteger(Integer salto, Integer valorInicial) {
        super(salto, valorInicial);
        valorActual = 0;
    }

    @Override
    public Integer next() {
        valorActual += salto;
        return valorActual;
    }
}
