package com.bootcamp;

public class LibroPDF implements Imprimible{
    private int paginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF() {
    }

    public LibroPDF(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Libro impreso");
    }
}
