package ejercicio1;

public class PracticaExepciones
{

    private int a = 0;
    private int b = 300;

    public PracticaExepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PracticaExepciones()
    {

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

    public void calcularCociente() throws IllegalArgumentException {
        try{
            System.out.println((double) (b/a));

        }catch (ArithmeticException ex){
            throw new IllegalArgumentException("Se ha producido un error");

        }finally {
            System.out.println("Programa finalizado");
        }

    }


}
