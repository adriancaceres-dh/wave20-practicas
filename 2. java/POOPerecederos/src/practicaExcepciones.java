public class practicaExcepciones {
    public static void calcular() throws Exception{
        int a = 0;
        int b = 300;

        try {
            System.out.println(b/a);
        } catch (Exception e){
            throw new IllegalArgumentException("no se puede dividir por cero");
        }
        finally {
            System.out.println("El programa ha finalizado" );
        }
    }
}
