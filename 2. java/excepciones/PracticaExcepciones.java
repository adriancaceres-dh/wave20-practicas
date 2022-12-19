package excepciones;

public class PracticaExcepciones{
    int a;
    int b;
    public PracticaExcepciones(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void calculoCociente(){
        try{
           double resultado = this.b/this.a;
        }/*catch(ArithmeticException e){
            System.out.println("se ha producido un error");
        }*/
        catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
    public static void main(String[] args) {
        PracticaExcepciones calculo = new PracticaExcepciones(0,300);
        calculo.calculoCociente();
    }
}



