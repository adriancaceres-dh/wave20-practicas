package bootcamp;

public class Main {
    public static void main(String[] args) {

    Libro libro = new Libro("HARRY POTTER", "J.K.Rowling",20);
        System.out.println(libro.Mostrarlibro());
        System.out.println("Cantidad de ejemplares: " + libro.CantidadDeEjemplares());
    }
}