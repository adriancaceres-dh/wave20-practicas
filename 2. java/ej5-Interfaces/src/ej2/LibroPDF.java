package ej2;

public class LibroPDF implements IImprimible {

    String texto;
    Persona autor;
    Persona revisor;

    public LibroPDF(String texto, Persona autor, Persona revisor) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "texto='" + texto + '\'' +
                ", autor=" + autor +
                ", revisor=" + revisor +
                '}';
    }
}
