package documento;

public class LibroPDF  implements Imprimible {
    private int cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro impreso");
    }
}
