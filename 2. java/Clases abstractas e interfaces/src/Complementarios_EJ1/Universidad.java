package Complementarios_EJ1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Universidad {

    // Esto también debería ser un Map para no tener repetidos.
    private LinkedList<Funcionario> funcionarios = new LinkedList<>();
    private Map<Integer, Estudiantes> estudiantes = new HashMap<>();

    private Map<Integer, Curso> cursos = new HashMap<>();

    private String nombreuniversidad;
    private int RUT;

    public Universidad(String nombreuniversidad, int RUT) {
        this.nombreuniversidad = nombreuniversidad;
        this.RUT = RUT;
    }

    public LinkedList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void agregarFuncionario(Funcionario nuevoFuncionario) {
        nuevoFuncionario.setIdentificadorEmpleado(funcionarios.size() + 1);
        funcionarios.add(nuevoFuncionario);
    }

    public Map<Integer, Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiantes nuevoEstudiante) {
        estudiantes.put(nuevoEstudiante.getNumeroMatricula(),nuevoEstudiante);
    }

    public String getNombreuniversidad() {
        return nombreuniversidad;
    }

    public void setNombreuniversidad(String nombreuniversidad) {
        this.nombreuniversidad = nombreuniversidad;
    }

    public int getRUT() {
        return RUT;
    }

    public void setRUT(int RUT) {
        this.RUT = RUT;
    }
}
