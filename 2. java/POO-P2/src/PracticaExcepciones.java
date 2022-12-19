public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int calcularCociente() {
        int result;
        try {
            result = b/a;

        } catch (ArithmeticException e) {
            //System.out.println("Se ha producido un error: " + e.getMessage());
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }
}
