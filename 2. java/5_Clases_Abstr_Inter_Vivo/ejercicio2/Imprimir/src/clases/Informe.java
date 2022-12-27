package clases;

public class Informe {

    int longitud;
    int paginas;
    String autor;
    String revisor;

    public Informe(int longitud, int paginas, String autor, String revisor) {
        this.longitud = longitud;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe:" +
                "Longitud=" + longitud +
                ", Páginas=" + paginas +
                ", Autor='" + autor + '\'' +
                ", Revisor='" + revisor + '\'' +
                '\n';
    }
}
