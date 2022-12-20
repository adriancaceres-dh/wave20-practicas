public class Main {
    public static void main(String[] args) {
        //PracticaExcepciones ejercicio1 = new PracticaExcepciones();
        //ejercicio1.calcularCociente();
        Perecedero perecedero = new Perecedero("jamon", 120.5, 3);
        System.out.println(perecedero.calcular(10));
        System.out.println(perecedero.toString());
    }
}