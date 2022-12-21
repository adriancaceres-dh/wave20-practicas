public class Main {
    public static void main(String[] args) {

        Serie serie = new Serie(2);
        serie.valorInicial(5);
        for (int i = 0 ; i < 4 ; i++) {
            System.out.println(serie.valorSiguiente());
        }
        serie.reiniciarSerie();
        System.out.println("------REINICIANDO------");
        for (int i = 0 ; i < 2 ; i++) {
            System.out.println(serie.valorSiguiente());
        }
    }
}