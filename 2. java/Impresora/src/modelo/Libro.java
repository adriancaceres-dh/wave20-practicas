package modelo;

public class Libro {
    private String autor;
    private String titulo;
    private String genero;
    private int CantidadPaginas;

    public Libro(String autor, String titulo, String genero, int cantidadPaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        CantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return CantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        CantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", CantidadPaginas=" + CantidadPaginas +
                '}';
    }
}
