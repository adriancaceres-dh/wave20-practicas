public class Serie_2_a_la_n extends  Serie {


    @Override
    void siguiente() {
        System.out.println(Math.pow(2,valorActual++));
    }

    @Override
    void reiniciarSerie() {
        valorActual = valorInicial;
    }
}
