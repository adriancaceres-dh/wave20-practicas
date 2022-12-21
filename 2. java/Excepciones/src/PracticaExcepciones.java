public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        double division;

        try {
            division=b/a;
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
