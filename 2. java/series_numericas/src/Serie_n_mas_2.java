public class Serie_n_mas_2 extends Serie{

    public Serie_n_mas_2() {
        valorInicial = 0;
        valorActual = 0;
    }

    @Override
    void siguiente() {
        System.out.println(valorActual);
        valorActual += 2;
    }

    @Override
    void reiniciarSerie() {
        valorActual = valorInicial;
    }
}
