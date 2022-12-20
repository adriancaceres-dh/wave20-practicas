public class main {

    public static void main(String[] args) {

        System.out.println("Serie n+1 = n + 2\n");
        Serie_n_mas_2 serie_n_mas_2 = new Serie_n_mas_2();

        serie_n_mas_2.establecerValorInicial(3);

        serie_n_mas_2.siguiente();
        serie_n_mas_2.siguiente();
        serie_n_mas_2.siguiente();
        serie_n_mas_2.establecerValorInicial(43);
        serie_n_mas_2.siguiente();
        serie_n_mas_2.siguiente();
        serie_n_mas_2.siguiente();


        System.out.println("---------------------------");
        System.out.println("Serie n+1 = 2^n\n");

        Serie_2_a_la_n serie_2_a_la_n = new Serie_2_a_la_n();

        serie_n_mas_2.establecerValorInicial(1);

        serie_2_a_la_n.siguiente();
        serie_2_a_la_n.siguiente();
        serie_2_a_la_n.siguiente();
        serie_2_a_la_n.siguiente();
        serie_2_a_la_n.reiniciarSerie();
        serie_2_a_la_n.siguiente();
        serie_2_a_la_n.siguiente();
        serie_2_a_la_n.siguiente();
    }
}
