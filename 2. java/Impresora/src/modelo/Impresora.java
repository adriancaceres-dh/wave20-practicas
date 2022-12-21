package modelo;

public class Impresora implements IImprimir{
    @Override
    public void imprimirCurriculum(Persona p) {
        System.out.println("Se ha impreso el Curriculum de:  "+p.getNombre());
    }

    @Override
    public void imprimirLibrosPDF(Libro l) {
        System.out.println("Se ha impreso el libro "+l);
    }

    @Override
    public void imprimirInformes(Informe i) {
        System.out.println("Se ha impreso el Informe del autor: "+i.getAutor());
    }
}
