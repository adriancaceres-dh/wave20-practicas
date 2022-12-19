package alimentacion;

public class AlimentacionHerbivora implements TipoAlimentacion {
    @Override
    public void alimentarse() {
        System.out.println("Como plantas");
    }
}
