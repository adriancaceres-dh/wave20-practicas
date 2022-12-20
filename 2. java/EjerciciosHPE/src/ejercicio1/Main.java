package ejercicio1;

public class Main {
    public static void main(String[] args) {
        try{
            PracticaExcepciones.cociente();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
