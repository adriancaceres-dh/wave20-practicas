package bootcamp;

public class Libro {

    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int CantidadDeEjemplares(){

        return ejemplares;
    }

    public String Mostrarlibro(){
        return "Titulo: " + titulo + " Autor: " + autor + " Ejemplares: " + ejemplares;
    }


}


