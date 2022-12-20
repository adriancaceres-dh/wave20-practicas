package Complementarios_EJ1;

public class Tutores extends Estudiantes{
    public Tutores(String nombre, String apellido, int numeroMatricula) {
        super(nombre, apellido, numeroMatricula);
    }

    public void enseñando(){
        System.out.println("El tutor está enseñando en X clase.");
    }
}
