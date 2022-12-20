package Complementarios_EJ1;

import java.util.Map;

public abstract class Estudiantes {
    private String nombre;
    private String apellido;
    private int numeroMatricula;

    private Map<Integer, Curso> cursosCursandoActual;

    public Map<Integer, Curso> getCursosCursandoActual() {
        return cursosCursandoActual;
    }

    public void agregarCursoActual(Curso cursoCursandoActual) {
        cursosCursandoActual.put(cursoCursandoActual.getIdCurso(), cursoCursandoActual);
    }

    public boolean isPrimeraInscripcion() {
        return primeraInscripcion;
    }

    private boolean primeraInscripcion = true;

    public Estudiantes(String nombre, String apellido, int numeroMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        if (primeraInscripcion) {
            this.numeroMatricula = numeroMatricula;
            primeraInscripcion = false;
        }
    }
}
