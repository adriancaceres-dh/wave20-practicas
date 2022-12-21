public class LibroPDF implements IImpresion<LibroPDF>{

    int cantidadDePaginas;
    Persona autor;
    String titulo;
    String genero;

    public LibroPDF(int cantidadDePaginas, Persona autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "cantidad de paginas : " + cantidadDePaginas +
                ", \nautor : " + autor.getNombreCompleto() +
                ", \ntitulo : '" + titulo + '\'' +
                ", \ngenero : '" + genero + '\''
                ;
    }

    @Override
    public String imprimir(LibroPDF documento) {
        return toString();
    }
}
