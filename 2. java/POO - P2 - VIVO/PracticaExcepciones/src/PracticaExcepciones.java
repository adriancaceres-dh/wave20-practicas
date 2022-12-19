public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public void calcularCociente(){

        try{
            int res = b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }catch (Exception e){
            System.out.println("Se ha producido un error. " + e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        new PracticaExcepciones().calcularCociente();
    }
}
