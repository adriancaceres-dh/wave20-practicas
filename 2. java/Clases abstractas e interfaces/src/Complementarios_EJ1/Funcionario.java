package Complementarios_EJ1;

public class Funcionario {
    private int identificadorEmpleado;
    private String horarioDeTrabajo;

    public Funcionario(int identificadorEmpleado, String horarioDeTrabajo) {
        this.identificadorEmpleado = identificadorEmpleado;
        this.horarioDeTrabajo = horarioDeTrabajo;
    }

    public int getIdentificadorEmpleado() {
        return identificadorEmpleado;
    }

    public void setIdentificadorEmpleado(int identificadorEmpleado) {
        this.identificadorEmpleado = identificadorEmpleado;
    }

    public String getHorarioDeTrabajo() {
        return horarioDeTrabajo;
    }

    public void setHorarioDeTrabajo(String horarioDeTrabajo) {
        this.horarioDeTrabajo = horarioDeTrabajo;
    }
}
