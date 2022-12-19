package documento;

public class Informe implements Imprimible {
    private String autor;
    private String revisor;
    private String contenido;

    public Informe(String autor, String revisor, String contenido) {
        this.autor = autor;
        this.revisor = revisor;
        this.contenido = contenido;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe impreso");
    }
}
