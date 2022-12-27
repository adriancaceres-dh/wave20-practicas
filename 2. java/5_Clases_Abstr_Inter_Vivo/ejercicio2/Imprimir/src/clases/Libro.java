package clases;

public class Libro {

    int paginas;
    String autor;
    String titulo;
    String genero;

    public Libro(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro:" +
                "Páginas=" + paginas +
                ", Autor='" + autor + '\'' +
                ", Título='" + titulo + '\'' +
                ", Género='" + genero + '\'';
    }
}