public class PracticaExcepciones {

    public static void main(String[] args) {
        int a, b;
        a=0;
        b=300;
        try{
            double cociente = b/a;
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
            //System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa Finalizado");
        }

    }
}
