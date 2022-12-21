import java.lang.Math;
class PrototipoG <T> {

    private T datoSerie;
    Integer valorInicial;
    Integer valorSiguiente;
    Integer incremento;

    public PrototipoG(Integer valorInicial, Integer incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
    }

    public double valorSiguiente()
    {
        valorInicial = valorInicial + incremento;
        return valorInicial;
    }
    public void valorInicial(int valorInicial)
    {
        this.valorInicial = valorInicial;
    }

    public void reiniciarSerie()
    {
        this.valorInicial = 0;
    };

}
