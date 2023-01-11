package ejercicio_2;

public class App {
    public static void main(String[] args) {
        Imprimible pdf = new LibroPDF();
        Imprimible.imprimir(pdf);
    }
}
