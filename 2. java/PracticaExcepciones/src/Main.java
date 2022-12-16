public class Main {
    public static void main(String[] args) {
        //PracticaExcepciones.calcularCociente();

        try{
            PracticaExcepciones.calcularCociente2();
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}