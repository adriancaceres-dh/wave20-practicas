public class PracticaExcepciones {
    private static int a = 0;

    private static int b = 300;

    public static int calcularCociente() {
        int resultado = -1;
        try {
            resultado = b / a;
        } catch (ArithmeticException ex) {
            System.out.println("Se ha prooducido un error");
        }
        System.out.println("Programa finalizado");
        return resultado;
    }

    public static int calcularCociente2() {
        int resultado = -1;
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        } else {
            resultado = b / a;
        }

        return resultado;
    }

}
