public class PracticaExcepciones {
    int a;
    int b;
    public PracticaExcepciones(int a, int b){
        this.a = 0;
        this.b = 300;
    }

    public int division() {
        if (a == 0) {
            System.out.println("Se ha producido un error");
        } else {
            int resultado = b / a;
        }
        return 0;
    }
    public int divisionTry(){
        try {
            int resultado =  b / a;
        } catch (ArithmeticException e){
            System.out.println("No se puede dividir por cero");
        }
        return 0;
    }
}
