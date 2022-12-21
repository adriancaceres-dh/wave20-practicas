public class Informe implements IImpresion<Informe>{

    String texto ;
    int cantidadDePaginas;
    Persona autor;
    Persona revisor;

    public Informe(String texto, int cantidadDePaginas, Persona autor, Persona revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "texto : '" + texto + '\'' +
                ", \ncantidad de paginas : " + cantidadDePaginas +
                ", \nautor : " + autor.getNombreCompleto() +
                ", \nrevisor : " + revisor.getNombreCompleto()
                ;
    }

    @Override
    public String imprimir(Informe documento) {
        return toString();
    }
}
