package modelo;

public class Informe {

    private int nLongitud ;
    private int cantidadPaginas ;
    private String autor;
    private String revisor;

    public Informe(int nLongitud, int cantidadPaginas, String autor, String revisor) {
        this.nLongitud = nLongitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getnLongitud() {
        return nLongitud;
    }

    public void setnLongitud(int nLongitud) {
        this.nLongitud = nLongitud;
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
        return "Informe{" +
                "nLongitud=" + nLongitud +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}

