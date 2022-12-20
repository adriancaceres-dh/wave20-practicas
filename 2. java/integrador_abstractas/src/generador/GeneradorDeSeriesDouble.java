package generador;

public class GeneradorDeSeriesDouble extends GeneradorDeSeries<Double>{

    public GeneradorDeSeriesDouble(Double salto) {
        super(salto);
        valorActual = 0D;
        valorInicial = 0D;
    }

    public GeneradorDeSeriesDouble(Double salto, Double valorInicial) {
        super(salto, valorInicial);
        valorActual = 0D;
    }

    @Override
    public Double next() {
        valorActual += salto;
        return valorActual;
    }
}
