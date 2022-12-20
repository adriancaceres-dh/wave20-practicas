package Ejercicio2.Clases;

import Ejercicio2.Interfaces.Imprimible;

public class LibrosPdf implements Imprimible {
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String Genero;

    @Override
    public String toString() {
        return "LibrosPdf{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", Genero='" + Genero + '\'' +
                '}';
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public LibrosPdf(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        Genero = genero;
    }
}
