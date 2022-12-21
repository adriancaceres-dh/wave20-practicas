public class Main {
    public static void main(String[] args)
    {
        System.out.println(" SERIE A DE 2, valor inicial 1. ");
        PrototipoG <Integer> serie = new PrototipoG<Integer>(1, 2);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());

        System.out.println("");

        System.out.println(" Cambio de valor inical a 2.");
        serie.valorInicial(2);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());

        System.out.println("");

        System.out.println(" SERIE B DE 3, valor inicial 2. ");
        PrototipoG <Integer> serie2 = new PrototipoG<Integer>(0, 2);

        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());

        System.out.println("");

        System.out.println(" Reiniciando series ...");
        System.out.println(" Impimiendo series ...");
        serie.reiniciarSerie();
        serie2.reiniciarSerie();

    }
}