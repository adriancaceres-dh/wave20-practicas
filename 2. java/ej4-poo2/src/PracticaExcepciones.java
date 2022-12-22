public class PracticaExcepciones {

    public static void main(String[] args) {

        final int a = 0;
        final int b = 300;

        try {
            int cociente = b/a;
        } catch (ArithmeticException error) {
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }


}
