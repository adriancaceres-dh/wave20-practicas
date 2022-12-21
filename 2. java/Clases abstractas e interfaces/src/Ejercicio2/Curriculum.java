package Ejercicio2;

public class Curriculum {

    // Esto debería ser un objeto persona para que tuviera los atributos correspondientes. Por simplicidad solo
    // se tomará como un String.
    private String nombrePersona;
    private String listaHabilidades;

    public Curriculum(String nombrePersona, String listaHabilidades) {
        this.nombrePersona = nombrePersona;
        this.listaHabilidades = listaHabilidades;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(String listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", listaHabilidades='" + listaHabilidades + '\'' +
                '}';
    }
}
