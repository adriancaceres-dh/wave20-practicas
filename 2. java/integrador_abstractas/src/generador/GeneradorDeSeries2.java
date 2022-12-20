package generador;

public class GeneradorDeSeries2 extends GeneradorDeSeries{
    @Override
    public int next() {
        valorActual += 2;
        return valorActual;
    }
}
