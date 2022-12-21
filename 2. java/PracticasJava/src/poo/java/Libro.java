package poo.java;


public class Libro {

    String titulo;
    String autor;
    int ejemplo;


    public Libro(String titulo, String autor, int ejemplo) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplo = ejemplo;
    }

    public int cantidadDeEjemplo(){
        return  ejemplo;
    }
    public String mostrarLibro(){
        return "Titulo" + titulo + "autor " + "Ejemplares: "+ ejemplo;
    }

    public static void main(String[] args) {
        Libro libro = new Libro("harry", "J:K",20);
        System.out.println(libro.mostrarLibro());
        System.out.println("la cantidad de ejemplares para este libro es de " + libro.cantidadDeEjemplo());
    }
}
