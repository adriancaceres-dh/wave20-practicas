package Complementarios_EJ1;

import java.util.LinkedList;
import java.util.Map;

public class CursoProgramacion1 extends Curso{
    public CursoProgramacion1(String nombreCurso, int idCurso) {
        super(nombreCurso, idCurso);
    }

    @Override
    public Map<Integer, Estudiantes> aprobaronCurso(LinkedList<Estudiantes> estudiantesAprobados) {
        Map<Integer, Estudiantes> estudiantesCurso = getEstudiantesCursando();
        return estudiantesCurso;
    }
}
