package objetos;

public class Informe {
    private int cantPaginas;
    private String autor;
    private String revisor;

    private String texto;

    public Informe(int cantPaginas, String autor, String revisor, String texto) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
