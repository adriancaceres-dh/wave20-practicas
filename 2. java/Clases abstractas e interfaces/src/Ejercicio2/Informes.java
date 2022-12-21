package Ejercicio2;

import java.util.ArrayList;

public class Informes {
    private ArrayList<String> texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes(ArrayList<String> texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto; // Se intuye que las líneas serán verificadas antes de ser creadas el objeto y están bien.
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public ArrayList<String> getTexto() {
        return texto;
    }

    public void setTexto(ArrayList<String> texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "texto=" + texto.toString() +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
