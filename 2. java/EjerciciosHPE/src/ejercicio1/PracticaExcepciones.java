package ejercicio1;

public class PracticaExcepciones{
    static int a = 0;
    static int b = 300;

    public static void cociente() throws IllegalArgumentException{
        try{
            double division = b/a;
            System.out.println("El cociente es: " + division);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException();
        }finally {
            System.out.println("El programa ha finalizado");
        }
    }
}
