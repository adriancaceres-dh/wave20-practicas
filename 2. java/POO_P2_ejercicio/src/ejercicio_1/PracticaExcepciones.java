package ejercicio_1;

import java.util.HashMap;
import java.util.List;

public class PracticaExcepciones {

    static private int b = 300;
    static private int a = 0;

    public static void main(String[] args) {

        try{


            throw new IllegalArgumentException();

        } catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        } catch (IllegalArgumentException e){
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("programa finalizado");
        }

    }
}
