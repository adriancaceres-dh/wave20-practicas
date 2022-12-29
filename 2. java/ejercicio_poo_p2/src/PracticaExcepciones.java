
public class PracticaExcepciones {

    int a;
    int b;


    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void calcularCociente(){

        int resultado = 0;
        try {
            resultado = this.b/this.a;
        }
        catch (ArithmeticException exception){
            System.out.println("IllegalArgumentException / No se puede divir por cero " + exception.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }

    }



}
