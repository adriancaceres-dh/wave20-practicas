package interfaces;

public class EstudiateTecnico extends Estudiante implements Tecnico{
    @Override
    public void darSoporte() {
        System.out.println("Estudiante dando soporte");
    }
}
