public class Main {
    public static void main(String[] args) {
        //Ejercicio 2:
        Distribuidora distribuidora = new Distribuidora();
        distribuidora.agregarProductos();
        distribuidora.imprimirTotal();

        //Ejercicio 1: cambio el orden ya que sino corta y no ejecuta el ejercicio 2
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        practicaExcepciones.calcularCociente();

    }
}