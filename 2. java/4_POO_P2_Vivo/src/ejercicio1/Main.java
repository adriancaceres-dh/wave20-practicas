package ejercicio1;

public class Main {

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        double resultado;
        try{
            practica.setA(0);
            practica.setB(300);

            resultado = practica.getB() / practica.getA();

        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
