public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        try {
            PracticaExcepcions.calcularCociente();
        }catch(ArithmeticException ex) {
            System.out.println("Se ha producido un error.");
        }catch( IllegalArgumentException ex){
            System.out.println("No se puede dividir por cero.");
        }finally {
            System.out.println("Programa finalizado.");
        }

        //Ejercicio 2

    }
}