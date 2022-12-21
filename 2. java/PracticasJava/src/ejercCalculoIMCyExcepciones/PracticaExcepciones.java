package ejercCalculoIMCyExcepciones;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public  void calcularCociente() throws IllegalArgumentException{

        /*try {
            int cociente = b / a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error" + e.getMessage());
        } finally {
            System.out.println("Programa Finalizado");
        }*/
        try {
            int cociente = b / a;
        } catch (ArithmeticException   e) {
           throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }
    }

    public static void main(String[] args) {
        new PracticaExcepciones().calcularCociente();
    }
}
