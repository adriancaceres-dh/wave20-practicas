package generador;

public class GeneradorDeSeriesN extends GeneradorDeSeries{
    private int salto;

    public GeneradorDeSeriesN(int salto) {
        this.salto = salto;
    }

    @Override
    public int next() {
        valorActual += salto;
        return valorActual;
    }

    public void setSalto(int salto) {
        this.salto = salto;
    }
}
