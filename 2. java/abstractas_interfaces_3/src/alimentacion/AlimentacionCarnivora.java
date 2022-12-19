package alimentacion;

public class AlimentacionCarnivora implements TipoAlimentacion {
    @Override
    public void alimentarse() {
        System.out.println("Como carneee");
    }
}
