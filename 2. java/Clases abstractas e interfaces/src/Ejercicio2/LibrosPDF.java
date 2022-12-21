package Ejercicio2;

public class LibrosPDF {
    private int cantidadPaginas;
    private String nombreAutor;
    private String tituloLibro;
    private String generoLibro;

    public LibrosPDF(int cantidadPaginas, String nombreAutor, String tituloLibro, String generoLibro) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.tituloLibro = tituloLibro;
        this.generoLibro = generoLibro;
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

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getGeneroLibro() {
        return generoLibro;
    }

    public void setGeneroLibro(String generoLibro) {
        this.generoLibro = generoLibro;
    }

    @Override
    public String toString() {
        return "LibrosPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", tituloLibro='" + tituloLibro + '\'' +
                ", generoLibro='" + generoLibro + '\'' +
                '}';
    }
}
