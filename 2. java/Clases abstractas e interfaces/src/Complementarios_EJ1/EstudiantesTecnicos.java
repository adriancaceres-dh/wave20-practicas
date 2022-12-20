package Complementarios_EJ1;

public class EstudiantesTecnicos extends Estudiantes{
    public EstudiantesTecnicos(String nombre, String apellido, int numeroMatricula) {
        super(nombre, apellido, numeroMatricula);
    }

    public void enseñar(){
        System.out.println("El estudiante esta realizando ayuda a los técnicos.");
    }
}
