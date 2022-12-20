package Complementarios_EJ1;

import java.util.LinkedList;
import java.util.Map;

public abstract class Curso {
    private Map<Integer ,Estudiantes> estudiantesCursando;
    private LinkedList<Profesores> profesoresDictanCurso;
    private String nombreCurso;

    private int idCurso;

    public Curso(String nombreCurso, int idCurso) {
        this.nombreCurso = nombreCurso;
        this.idCurso = idCurso;
    }

    public Map<Integer, Estudiantes> getEstudiantesCursando() {
        return estudiantesCursando;
    }

    public void agregarEstudianteAlCurso(Estudiantes nuevoEstuddiante) {
        estudiantesCursando.put(nuevoEstuddiante.getNumeroMatricula(),nuevoEstuddiante);
    }

    public LinkedList<Profesores> getProfesoresDictanCurso() {
        return profesoresDictanCurso;
    }

    public void setProfesoresDictanCurso(LinkedList<Profesores> profesoresDictanCurso) {
        this.profesoresDictanCurso = profesoresDictanCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public abstract Map<Integer, Estudiantes> aprobaronCurso(LinkedList<Estudiantes> estudiantesAprobados);
}
