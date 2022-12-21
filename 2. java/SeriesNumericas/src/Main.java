import modelo.Calculo;

public class Main {
    public static void main(String[] args) {
        Calculo c = new Calculo();
        c.reiniciarSerie();
        c.establecerValorInicial(2);
        System.out.println(c.valorSiguiente());
       // c.establecerValorInicial(1);
        System.out.println(c.valorSiguiente());
        System.out.println(c.valorSiguiente());
        System.out.println(c.valorSiguiente());
        c.establecerValorInicial(5);
        System.out.println(c.valorSiguiente());


    }
}