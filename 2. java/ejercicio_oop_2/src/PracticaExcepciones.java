public class PracticaExcepciones {
    private static int a = 0, b = 300;

    public static void main (String[] args) {
        try {
            double cociencte =  b/a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
    //        System.out.println("No se pude dividir por cero" + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
