package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

public class LibroPdf implements Imprimible {
    int cantPaginas;
    String autor;
    String genero;
    String titulo;

    public LibroPdf(int cantPaginas, String autor, String genero, String titulo) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
    }
    public void imprimir() {
        System.out.println("Impresion de PDF: " + cantPaginas + " | " + autor + " | " + genero + " | " + titulo);
    }
}
