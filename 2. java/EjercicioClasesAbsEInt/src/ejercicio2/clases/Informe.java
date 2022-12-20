package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

public class Informe implements Imprimible {
    private String texto;
    private int nPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int nPaginas, String autor, String revisor) {
        this.texto = texto;
        this.nPaginas = nPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public void imprimir() {
        System.out.println("Impresion de informe: " +  texto + " | " + nPaginas + " | " +  autor + " | " + revisor + " | ");
    }
}
