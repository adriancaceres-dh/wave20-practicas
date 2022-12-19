package documento;

public class Curriculum implements Imprimible {
    private String contenido;

    public Curriculum(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum impreso");
    }
}
