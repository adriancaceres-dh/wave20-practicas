public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente() {
        try {
            System.out.println(b/a);
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("Se ha produicido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
