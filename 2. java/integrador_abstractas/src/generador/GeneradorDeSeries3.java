package generador;

public class GeneradorDeSeries3 extends GeneradorDeSeries{
    @Override
    public int next() {
        valorActual += 3;
        return valorActual;
    }
}
