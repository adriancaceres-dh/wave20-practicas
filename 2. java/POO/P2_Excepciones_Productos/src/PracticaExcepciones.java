public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int resultado = b/a;
            System.out.println(resultado);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir entre 0.");
        }finally {
            System.out.println("Programa finalizado.");
        }



    }
}
