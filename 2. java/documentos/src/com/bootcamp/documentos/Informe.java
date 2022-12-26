package com.bootcamp.documentos;

public class Informe implements IImprimir{

    String texto;
    int paginas;
    String autor;
    String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
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
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("---Informe---");
        System.out.println("autor: " + autor);
        System.out.println("texto: " + texto);
        System.out.println("revisor: " + revisor);
    }
}
